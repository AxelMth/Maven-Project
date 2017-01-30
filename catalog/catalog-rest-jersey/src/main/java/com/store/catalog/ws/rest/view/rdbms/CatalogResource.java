package com.store.catalog.ws.rest.view.rdbms;

import com.store.catalog.model.ProductDTO;
import com.store.catalog.service.catalog.CatalogService;
import com.store.catalog.model.CategoryDTO;
import com.store.catalog.model.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by ZCadi on 26/10/2015.
 */

@Path("/catalog")
public class CatalogResource {

    @Autowired 
    CatalogService catalogServiceImpl;

    public CatalogService getCatalogServiceImpl() {
        return catalogServiceImpl;
    }

    public void setCatalogServiceImpl(CatalogService catalogServiceImpl) {
        this.catalogServiceImpl = catalogServiceImpl;
    }
    
    @Path("/categories")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCategories() throws Exception {
    	
    	List<CategoryDTO> list = catalogServiceImpl.findCategories();
    	
    	//if (list.isEmpty())
    	//	return Response.serverError().entity("There is no category inside the catalog").build();
    	
    	String json = "";
    	
    	for (CategoryDTO cat : list){
    		json = json.concat(cat.getId().toString());
    		json = json.concat(cat.getName());
    		json = json.concat(cat.getDescription());
    	}
    	
    	return Response.ok(json).build();
    }

    @Path("/category/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCategory(@PathParam("id") Long id) throws Exception {
    	
    	if(id == null)
            return Response.serverError().entity("ID cannot be blank").build();
        
    	CategoryDTO cat = catalogServiceImpl.findCategory(id);
    	
    	if (cat == null)
    		return Response.status(Response.Status.NOT_FOUND).entity("Category not found for ID: " + id).build();
    	
    	String json = "{";
    	
    	json = json.concat("id : " + cat.getId().toString() + ", ");
		json = json.concat("name : " + cat.getName() + ", ");
		json = json.concat("description : " + cat.getDescription());
    	
		json = json.concat("}");
		
    	return Response.ok(json).build();
    }

    @Path("/category/create")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCategory(CategoryDTO categoryDTO) throws Exception {
    	catalogServiceImpl.createCategory(categoryDTO);
    	return Response.ok("Category Created").build();
    }

    @Path("/category/update")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCategory(CategoryDTO categoryDTO) throws Exception {
    	catalogServiceImpl.updateCategory(categoryDTO);
    	return Response.ok("Category Updated").build();
    }

    @Path("/category/delete/{id}")
    @DELETE
    public Response deleteCategory(@PathParam("id") Long id) throws Exception {
    	catalogServiceImpl.deleteCategory(id);
    	return Response.ok("Category with id : " + id + " deleted").build();
    }


    public Response getProducts() throws Exception {

    	return null;
    }

    @Path("/product/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProduct(@PathParam("id") Long id) throws Exception {

    	if(id == null)
            return Response.serverError().entity("ID cannot be blank").build();
        
    	ProductDTO prod = catalogServiceImpl.findProduct(id);
    	
    	if (prod == null)
    		return Response.status(Response.Status.NOT_FOUND).entity("Product not found for ID: " + id).build();
    	
    	String json = "{";

    	json = json.concat("id : " + prod.getId().toString() + ", ");
    	json = json.concat("category : " + prod.getCategory().getName() + ", ");
		json = json.concat("name : " + prod.getName() + ", ");
		json = json.concat("description : " + prod.getDescription());
    	
		json = json.concat("}");
		
    	return Response.ok(json).build();
    }

    @Path("/product/create")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createProduct(ProductDTO productDTO) throws Exception {
    	catalogServiceImpl.createProduct(productDTO);
    	return Response.ok("Product Created").build();
    }

    @Path("/product/update")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateProduct(ProductDTO productDTO) throws Exception {
    	catalogServiceImpl.updateProduct(productDTO);
    	return Response.ok("Product Updated").build();
    }

    @Path("/product/delete/{id}")
    @DELETE
    public Response deleteProduct(@PathParam("id") Long id) throws Exception {
    	catalogServiceImpl.deleteProduct(id);
    	return Response.ok("Product with id : " + id + " deleted").build();
    }

    public Response getItems() throws Exception {

    	return null;
    }


    public Response getItem(@PathParam("id") Long id) throws Exception {

    	return null;
    }


    public Response createItem(ItemDTO itemDTO) throws Exception {

    	return null;

    }


    public Response updateItem(ItemDTO itemDTO) throws Exception {

    	return null;

    }


    public Response deleteItem(@PathParam("id") Long id) throws Exception {

    	return null;

    }


    public Response getItemsByName(@PathParam("name") String name) throws Exception {

    	return null;
    }

}
