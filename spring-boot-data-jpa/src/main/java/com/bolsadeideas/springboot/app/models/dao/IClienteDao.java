package com.bolsadeideas.springboot.app.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.bolsadeideas.springboot.app.models.entity.Cliente;

//import java.util.List;

//import com.bolsadeideas.springboot.app.models.entity.Cliente;

//public interface IClienteDao extends CrudRepository<Cliente, Long> {

// Ya no usamos estos métodos porque vamos a usar el CrudRepository
//	public List<Cliente> findAll();
//
//	public void save(Cliente cliente);
//
//	public Cliente findOne(Long id);
//
//	public void delete(Long id);

//Ahora vamos a usar paginacion
public interface IClienteDao extends PagingAndSortingRepository<Cliente, Long>, CrudRepository<Cliente, Long> {

	// sin "left", requiere que haya datos en ambas tablas, sino retorna un null
	@Query("select c from Cliente c left join fetch c.facturas f where c.id =?1")
	public Cliente fetchByIdWithFactura(Long id);

}
