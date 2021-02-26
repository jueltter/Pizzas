/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterpriseapplication.services;

import com.enterpriseapplication.dtos.IngredienteDTO;
import com.enterpriseapplication.dtos.PizzaDTO;
import com.enterpriseapplication.entities.Ingrediente;
import com.enterpriseapplication.entities.Pizza;
import com.enterpriseapplication.utilities.Utilidades;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Stalin
 */
public class ServicioPizza {

    public void crear(PizzaDTO pizzaDTO) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Utilidades.JPA_PERSIST_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        
        Pizza pizza = new Pizza();
        pizza.setName(pizzaDTO.getName());
        pizza.setAddress(pizzaDTO.getAddress());
        pizza.setPhone(pizzaDTO.getPhone());
        pizza.setSize(pizzaDTO.getPizza());
        pizza.setPrice(pizzaDTO.getPrice());
        
        em.getTransaction().begin();
        
         
        
        em.persist(pizza);
        em.getTransaction().commit();
        
         List<Pizza> pizzas = (List<Pizza>) em.createQuery("select p from Pizza p ORDER BY p.orderid DESC").getResultList();
         int order = pizzas.get(0).getOrderid();
                 
        
        
        ServicioIngrediente si = new ServicioIngrediente();
        
        for (IngredienteDTO ingredienteDTO: pizzaDTO.getIngredientes()){
        
            ingredienteDTO.setOrder(order);
            si.crear(ingredienteDTO);
        }
        
        

    }
    
    public ArrayList<PizzaDTO> consultar() {

        List<Pizza> pizzas;
        ArrayList<PizzaDTO> pizzasDTO;        
        PizzaDTO pizzaDTO;
        IngredienteDTO ingredienteDTO;
        
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Utilidades.JPA_PERSIST_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        
        
        
         pizzas = (List<Pizza>) em.createQuery("select p from Pizza p").getResultList();
         
         pizzasDTO = new ArrayList<>();
         
         for (Pizza pizza : pizzas ){
         
         
             pizzaDTO = new PizzaDTO();
             pizzaDTO.setOrder(pizza.getOrderid());
             pizzaDTO.setName(pizza.getName());
             pizzaDTO.setAddress(pizza.getAddress());
             pizzaDTO.setPhone(pizza.getPhone());
             pizzaDTO.setPizza(pizza.getSize());
             pizzaDTO.setPrice(pizza.getPrice());
             pizzaDTO.setIngredientes(new ArrayList<>());
             
             for (Ingrediente ingrediente : pizza.getIngredienteCollection()){
             
                 ingredienteDTO = new IngredienteDTO();
                 
                 ingredienteDTO.setId(ingrediente.getId());
                 ingredienteDTO.setOrder(pizza.getOrderid());
                 ingredienteDTO.setIngredinte(ingrediente.getIngrediente());
                 pizzaDTO.getIngredientes().add(ingredienteDTO);
                 
             }
             
             
             pizzasDTO.add(pizzaDTO);
         
         }
        
        
        
        return pizzasDTO;

    }
}
