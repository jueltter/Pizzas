/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterpriseapplication.dtos;

/**
 *
 * @author Stalin
 */
public class IngredienteDTO {
    
    private int id;
    private int order;
    private String ingredinte;

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getIngredinte() {
        return ingredinte;
    }

    public void setIngredinte(String ingredinte) {
        this.ingredinte = ingredinte;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    
}
