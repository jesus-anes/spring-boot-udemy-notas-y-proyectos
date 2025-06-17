package com.bolsadeideas.springboot.app.models.dao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.app.models.dao.IClienteDao;
import com.bolsadeideas.springboot.app.models.dao.IFacturaDao;
import com.bolsadeideas.springboot.app.models.dao.IProductoDao;
import com.bolsadeideas.springboot.app.models.entity.Cliente;
import com.bolsadeideas.springboot.app.models.entity.Factura;
import com.bolsadeideas.springboot.app.models.entity.Producto;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteDao clienteDao;

	@Autowired
	private IProductoDao productoDao;

	@Autowired
	private IFacturaDao facturaDao;

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {

		// Sin la extensión CrudRepository
		// return clienteDao.findAll();

		// Con la extensión CrudRepository
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		// No importa la extensión
		clienteDao.save(cliente);
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findOne(Long id) {
		// Sin la extensión CrudRepository
		// return clienteDao.findOne(id);

		// Con la extensión CrudRepository
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// Sin la extensión CrudRepository
		// clienteDao.delete(id);

		// Con la extensión CrudRepository
		clienteDao.deleteById(id);
	}

	// Método que permite la paginación
	@Override
	@Transactional(readOnly = true)
	public Page<Cliente> findAll(Pageable pageable) {

		return clienteDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findByNombre(String term) {

		// return productoDao.findByNombre(term);
		return productoDao.findByNombreLikeIgnoreCase("%" + term + "%");
	}

	@Override
	@Transactional
	public void saveFactura(Factura factura) {
		facturaDao.save(factura);
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findProductoById(Long id) {
		return productoDao.findById(id).orElse(null);
	}

}
