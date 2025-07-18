//package com.bolsadeideas.springboot.app.models.dao;
//
//import java.util.List;
//
//import org.springframework.stereotype.Repository;
////import org.springframework.transaction.annotation.Transactional;
//
//import com.bolsadeideas.springboot.app.models.entity.Cliente;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//
////Para marcar la clase como acceso a datos(repositorio)
////Y le asignamos un nombre
//@Repository("clienteDaoImplJPA")
//public class ClienteDaoImpl implements IClienteDao {
//
//	@PersistenceContext
//	private EntityManager em;
//
//	// Devuelve un listado de usuarios
//	@SuppressWarnings("unchecked")
//	// ya no es necesario, porque adornamos estos métodos con @Transactional en la
//	// clase ClienteServiceImpl
//	// @Transactional(readOnly = true)
//	@Override
//	public List<Cliente> findAll() {
//
//		return em.createQuery("from Cliente").getResultList();
//	}
//
//	@Override
//	// @Transactional(readOnly = true)
//	public Cliente findOne(Long id) {
//
//		return em.find(Cliente.class, id);
//	}
//
//	// Guardamos un usuario
//	@Override
//	// @Transactional
//	public void save(Cliente cliente) {
//
//		// En este método entra cuando actualizamos el cliente
//		if (cliente.getId() != null && cliente.getId() > 0) {
//			em.merge(cliente);
//		} else {
//			// Sino crea un nuevo registro en la base de datos
//			em.persist(cliente);
//		}
//	}
//
//	@Override
//	// @Transactional
//	public void delete(Long id) {
//		Cliente cliente = findOne(id);
//
//		em.remove(cliente);
//
//	}
//
//}
