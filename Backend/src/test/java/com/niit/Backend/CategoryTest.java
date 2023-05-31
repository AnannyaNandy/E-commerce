package com.niit.Backend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Backend.DAO.CategoryDAO;
import com.niit.Backend.modal.Category;

public class CategoryTest 
{
	private static AnnotationConfigApplicationContext context;
	static Category category;
	static CategoryDAO categoryDAO;	
	
	@BeforeClass
	public static void init() 
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.Backend");
		context.refresh();
		
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
	}
	
	//@Test
	public void testInsert()
	{
		category = new Category();
		//category.setId(7);
		category.setCategoryName("SmartPhone");
		category.setDescription("Sample category for SmartPhone");
		category.setActive(true);
		
		assertEquals("Error adding Category" , true, categoryDAO.insert(category));
	}
	
	//@Test
	public void testDelete()
	{
		category = categoryDAO.getCategory(3);
		
		assertEquals("Error deleting Category" , true, categoryDAO.delete(category));
	}
	
	//@Test
	public void testUpdate()
	{
		category = categoryDAO.getCategory(2);
		category.setCategoryName("Television");
		
		assertEquals("Error updating Category" , true, categoryDAO.update(category));
	}
	
	//@Test
	public void testCategoryList()
	{
		assertEquals("Error updating Category" , 3, categoryDAO.categoryList().size());
	}

}