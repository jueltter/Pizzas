package com.enterpriseapplication.servicesrest.service;


import com.enterpriseapplication.dtos.PizzaDTO;
import com.enterpriseapplication.services.ServicioPizza;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/ServicioPizza")
@Produces("application/json")
@Consumes("application/json")
public class ServicioPizzaRest {
	
        
        @GET
	@Path("/consultar")        
        public ArrayList<PizzaDTO> consultar(){
        
            ServicioPizza servicioPizza = new ServicioPizza(); 
            System.out.println(servicioPizza.consultar().size());
            return servicioPizza.consultar();
        }
        
        
        @POST
	@Path("/crear")        
        public String crear(PizzaDTO pizzaDTO){
        
            //System.out.println(pizzaDTO.getName());
            ServicioPizza servicioPizza = new ServicioPizza();
            servicioPizza.crear(pizzaDTO);
            
            return "OK";
        }
	
	
}
