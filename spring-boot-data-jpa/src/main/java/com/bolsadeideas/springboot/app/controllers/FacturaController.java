package com.bolsadeideas.springboot.app.controllers;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bolsadeideas.springboot.app.models.dao.service.IClienteService;
import com.bolsadeideas.springboot.app.models.entity.Cliente;
import com.bolsadeideas.springboot.app.models.entity.Factura;
import com.bolsadeideas.springboot.app.models.entity.ItemFactura;
import com.bolsadeideas.springboot.app.models.entity.Producto;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/factura")
//Usamos la sesion para crear la factura hasta que se guarde en la base de datos
@SessionAttributes("factura")
public class FacturaController {

	// Inyectamos el servicio de cliente
	@Autowired
	private IClienteService clienteService;

	private final Logger log = LoggerFactory.getLogger(getClass());

	// {clienteId} para vincular la factura a un cliente
	@GetMapping("/form/{clienteId}")
	public String crear(@PathVariable(value = "clienteId") Long clienteId, Map<String, Object> model,
			RedirectAttributes flash) {

		Cliente cliente = clienteService.findOne(clienteId);

		// Si no existe el cliente
		if (cliente == null) {

			flash.addFlashAttribute("error", "El cliente no existe en la base de datos");

			return "redirect:/listar";
		}

		Factura factura = new Factura();
		factura.setCliente(cliente);

		model.put("factura", factura);
		model.put("titulo", "Crear Factura");

		return "factura/form";
	}

	@GetMapping(value = "/cargar-producto/{term}", produces = "application/json")
	// @ResponseBody para suprimir el cargar una vista, y toma el resultado que se
	// retorna
	public @ResponseBody List<Producto> cargarProducto(@PathVariable String term) {
		return clienteService.findByNombre(term);

	}

	// Guardar la factura
	@PostMapping("/form")
	public String guardar(@Valid Factura factura, BindingResult result, Model model,
			@RequestParam(name = "item_id[]", required = false) Long[] itemId,
			@RequestParam(name = "cantidad[]", required = false) Integer[] cantidad, RedirectAttributes flash,
			SessionStatus status) {

		if (result.hasErrors()) {

			model.addAttribute("titulo", "Crear Factura");

			return "factura/form";
		}

		if (itemId == null || itemId.length == 0) {

			model.addAttribute("titulo", "Crear Factura");
			model.addAttribute("error", "Error: La factura NO puede no tener líneas!");

			return "factura/form";
		}

		for (int i = 0; i < itemId.length; i++) {
			Producto producto = clienteService.findProductoById(itemId[i]);

			ItemFactura linea = new ItemFactura();

			linea.setCantidad(cantidad[i]);
			linea.setProducto(producto);

			factura.addItemFactura(linea);

			log.info("ID: " + itemId[i] + ", cantidad: " + cantidad[i].toString());

			clienteService.saveFactura(factura);

			status.setComplete();

			flash.addFlashAttribute("success", "Factura creada con éxito!");
		}

		return "redirect:/ver/" + factura.getCliente().getId();
	}

	// Vista de los detalles de la factura
	@GetMapping("/ver/{id}")
	public String verFactura(@PathVariable(value = "id") Long id, Model model, RedirectAttributes flash) {

		// Factura factura = clienteService.findFacturaById(id);
		// Consulta para optimizar
		Factura factura = clienteService.fetchByIdWithClienteWithItemFacturaWithProducto(id);

		if (factura == null) {
			flash.addFlashAttribute("error", "La factura no existe en la base de datos!");

			return "redirect:/listar";
		}

		model.addAttribute("factura", factura);
		model.addAttribute("titulo", "Factura: ".concat(factura.getDescripcion()));

		return "factura/ver";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) {

		Factura factura = clienteService.findFacturaById(id);

		if (factura != null) {
			clienteService.deleteFactura(id);

			flash.addFlashAttribute("success", "Factura eliminada con éxito!");
			return "redirect:/ver/" + factura.getCliente().getId();
		}
		flash.addFlashAttribute("error", "La factura no existe en la base de datos!");
		return "redirect:/listar";
	}
}
