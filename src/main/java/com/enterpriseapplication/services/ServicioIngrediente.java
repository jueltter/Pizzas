/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterpriseapplication.services;

import com.enterpriseapplication.dtos.IngredienteDTO;
import com.enterpriseapplication.entities.Ingrediente;
import com.enterpriseapplication.entities.Pizza;
import com.enterpriseapplication.utilities.Utilidades;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Stalin
 */
public class ServicioIngrediente {
    
    public void crear(IngredienteDTO ingredienteDTO){
    
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Utilidades.JPA_PERSIST_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        
        Pizza pizza = em.find(Pizza.class, ingredienteDTO.getOrder());
        
        
        
        
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setOrderid(pizza);
        ingrediente.setIngrediente(ingredienteDTO.getIngredinte());
        
        
        
        em.getTransaction().begin();
        em.persist(ingrediente);
        em.getTransaction().commit();
    
    }
    
}
