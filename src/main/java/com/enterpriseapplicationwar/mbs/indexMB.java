/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterpriseapplicationwar.mbs;

import com.enterpriseapplication.dtos.IngredienteDTO;
import com.enterpriseapplication.dtos.PizzaDTO;
import com.enterpriseapplication.services.ServicioPizza;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Stalin
 */
@Named(value = "indexMB")
@SessionScoped
public class indexMB implements Serializable {

    private String name;
    private String address;
    private String phone;
    
    private String selectedSize;
    private String[] selectedIngredients;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSelectedSize() {
        return selectedSize;
    }

    public void setSelectedSize(String selectedSize) {
        this.selectedSize = selectedSize;
    }

    public String[] getSelectedIngredients() {
        return selectedIngredients;
    }

    public void setSelectedIngredients(String[] selectedIngredients) {
        this.selectedIngredients = selectedIngredients;
    }    
    
    
    /**
     * Creates a new instance of indexMB
     */
    public indexMB() {
    }
    
    
    public String order(){
    
        PizzaDTO pizzaDTO = new PizzaDTO();
        pizzaDTO.setName(name);
        pizzaDTO.setAddress(address);
        pizzaDTO.setPhone(phone);
        pizzaDTO.setPizza(selectedSize);
        pizzaDTO.setPrice(0.0);
        
         ArrayList<IngredienteDTO> ingredientes = new ArrayList<>();
         IngredienteDTO ingredienteDTO;
         
         for (int i=0; i<selectedIngredients.length; i++){
             ingredienteDTO = new IngredienteDTO();
             
             System.out.println(selectedIngredients[i]);
             
             ingredienteDTO.setIngredinte(selectedIngredients[i]);
             ingredientes.add(ingredienteDTO);
         }
         
         pizzaDTO.setIngredientes(ingredientes);
        
        ServicioPizza s = new ServicioPizza();
        s.crear(pizzaDTO);
        
        return "index";
    
    }
    
}
