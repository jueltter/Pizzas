/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterpriseapplication.dtos;

import java.util.ArrayList;

/**
 *
 * @author Stalin
 */
public class PizzaDTO {
    
    private int order;
    private String name;
    private String address;
    private String phone;
    private String pizza;
    private Double price;
    private ArrayList<IngredienteDTO> ingredientes;

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

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

    public String getPizza() {
        return pizza;
    }

    public void setPizza(String pizza) {
        this.pizza = pizza;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ArrayList<IngredienteDTO> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<IngredienteDTO> ingredientes) {
        this.ingredientes = ingredientes;
    }
    
    
    
}
