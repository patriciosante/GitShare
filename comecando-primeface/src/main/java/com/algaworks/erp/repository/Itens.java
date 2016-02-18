package com.algaworks.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.erp.model.Item;

public class Itens  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	@Inject
	private EntityManager manager;
	
	public Item porID(Long id)
	{
	   return	 manager.find(Item.class, id);
	}
	
	public List<Item> todas() {	
		return manager.createQuery("From Item",Item.class).getResultList();
	}
	
	public void quardar(Item obj)
	{
		manager.merge(obj);
	}
	
	public void remover(Item obj)
	{
	     Item aux = porID(obj.getId());
	     
	     manager.remove(aux);
	}
	
	
	
	
	

}
