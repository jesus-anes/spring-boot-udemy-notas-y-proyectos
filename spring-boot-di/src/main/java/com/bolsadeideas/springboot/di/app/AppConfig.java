package com.bolsadeideas.springboot.di.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.bolsadeideas.springboot.di.app.models.domain.ItemFactura;
import com.bolsadeideas.springboot.di.app.models.domain.Producto;
import com.bolsadeideas.springboot.di.app.models.service.IServicio;
import com.bolsadeideas.springboot.di.app.models.service.MiServicio;
import com.bolsadeideas.springboot.di.app.models.service.MiServicioComplejo;

//Desde aquí configuramos los servicios de otra forma que no sea desde su clase
@Configuration
public class AppConfig {

	@Bean("miServicioSimple")
	public IServicio regirtrarMiServicio() {
		return new MiServicio();
	}

	@Bean("miServicioComplejo")
	// Le damos prioridad
	@Primary
	public IServicio regirtrarMiServicioComplejo() {
		return new MiServicioComplejo();
	}

	@Bean("itemsFactura")
	public List<ItemFactura> registrarItems() {

		Producto producto1 = new Producto("Crema", 4);
		Producto producto2 = new Producto("Patatas", 5);
		Producto producto3 = new Producto("Camara Sony", 234);

		ItemFactura linea1 = new ItemFactura(producto1, 3);
		ItemFactura linea2 = new ItemFactura(producto2, 13);
		ItemFactura linea3 = new ItemFactura(producto3, 1);

		return Arrays.asList(linea1, linea2, linea3);
	}

	@Bean("itemsFacturaOficina")
	@Primary
	public List<ItemFactura> registrarItemsOficiona() {

		Producto producto1 = new Producto("Monitor LG LCD 24", 320);
		Producto producto2 = new Producto("Notebook Asus", 567);
		Producto producto3 = new Producto("Teclado Corsair K95", 155);
		Producto producto4 = new Producto("Escritorio Oficina", 54);

		ItemFactura linea1 = new ItemFactura(producto1, 3);
		ItemFactura linea2 = new ItemFactura(producto2, 13);
		ItemFactura linea3 = new ItemFactura(producto3, 1);
		ItemFactura linea4 = new ItemFactura(producto4, 2);

		return Arrays.asList(linea1, linea2, linea3, linea4);
	}

}
