package com.store.catalog.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.store.catalog.model.Category;
import com.store.catalog.model.Product;
import com.store.catalog.utils.ConstantUtils;

import static com.store.catalog.utils.ConstantUtils.*;

public class ProductDaoTest extends AbstractBaseDaoTestCase {

    
    @Autowired
    private ProductDao productDao ;
    
    @Autowired
    private CategoryDao categoryDao ;    
    
    private Product product = null;
    
    
    @Before
    public void setUp(){
    	loadProduct();
    }
    
    @After
    public void tearDown(){
    	categoryDao = null;
    	productDao = null;
    }

    @Test
    public void testCreateProduct() throws Exception {
    	productDao.save(product);
    	assertTrue("primary key assigned",product.getId() != null);
    }    
   
    @Test
    public void testUpdateProduct() throws Exception {
    	productDao.save(product);
    	
    	product.setName(ConstantUtils.PRODUCT_NAME + "MDF");
    	product.setDescription(ConstantUtils.PRODUCT_DESCRIPTION + "MDF");
    	
    	productDao.save(product);
    	
    	Product prodMdf = productDao.findOne(product.getId());
    	assertEquals(product,prodMdf);
    }    
    
    
    @Test
    public void testGetProduct() throws Exception {

    	productDao.save(product);
    	
    	Product cat = productDao.findOne(product.getId());
    	
    	assertNotNull(cat.getId());
    	assertEquals(product,cat);

    }   

    
    @Test
    public void testRemoveProduct() throws Exception {
     	
    	productDao.save(product);
    	
    	Product cat = productDao.findOne(product.getId());
    	
    	assertNotNull(cat.getId());
    	assertEquals(product,cat);
    	
    	productDao.delete(product.getId());
    	
    	assertTrue(getIterableSize(productDao.findAll()) == 0);
    	
    }

    
    
    @Test
    public void testGetProducts() throws Exception {
    	productDao.save(product);
    	
    	Iterable<Product> lst = productDao.findAll();
    	
    	assertTrue(getIterableSize(lst) == 1);
    	
    	Product prod2 = new Product();
    	prod2.setId(new Random().nextLong());
    	prod2.setName(ConstantUtils.PRODUCT_NAME + "2");
    	prod2.setDescription(ConstantUtils.PRODUCT_DESCRIPTION + "2");
    	prod2.setCategory(getCategory());
    	
    	productDao.save(prod2);
    	
    	assertTrue(getIterableSize(productDao.findAll()) == 2);
    	
    }    
    

    @Test
    public void testGetProductsWithCategoryId() throws Exception {
    	
    	productDao.save(product);
    	
    	Iterable<Product> lst = productDao.findByCategoryId(product.getCategory().getId());
    	
    	assertTrue(getIterableSize(lst) == 1);
    }    

    
    @Test
    public void testGetProductsByCategoryName() throws Exception {
    	
    	productDao.save(product);
    	
    	//Iterable<Product> lst = productDao.findByNameContaining(product.getName());
    	
    	assertTrue(getIterableSize(productDao.findByCategoryName(product.getCategory().getName())) == 1);
    	
    	Product prod2 = new Product();
    	prod2.setId(new Random().nextLong());
    	prod2.setName(ConstantUtils.PRODUCT_NAME);
    	prod2.setDescription(ConstantUtils.PRODUCT_DESCRIPTION + "2");
    	prod2.setCategory(getCategory());
    	
    	productDao.save(prod2);
    	
    	assertTrue(getIterableSize(productDao.findByCategoryName(product.getCategory().getName())) == 2);
    }        
	
	
	private Category getCategory() {
		Category category = new Category();
        category.setId(new Random().nextLong());
        category.setName(CATEGOY_NAME);
        category.setDescription(CATEGORY_DESCRIPTION);

        categoryDao.save(category);
		return category;
	}    
	
	/*private Category getCategory2() {
		Category category = new Category();
        category.setId(new Random().nextLong());
        category.setName("catName2");
        category.setDescription("description2");

        categoryDao.save(category);
		return category;
	}    */
    
	
    /**
     * 
     * create an instanciated object. The one declared as private field in the test class
     */	
	private void loadProduct() {
    	product = new Product();
        product.setId(new Random().nextLong());
    	product.setName(PRODUCT_NAME);
    	product.setDescription(PRODUCT_DESCRIPTION);
    	product.setCategory(getCategory());
	}
	
}
