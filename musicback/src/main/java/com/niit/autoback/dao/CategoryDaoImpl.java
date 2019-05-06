package com.niit.autoback.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.autoback.model.Category;

public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean insertCategory(Category category) {
		try {
			Session session=sessionFactory.getCurrentSession();
			session.save(category);
			System.out.println("New Category Added");
			return true;

		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());	

			return false;
		}
	}

	public boolean updateCategory(Category category) {
		try {
			Session session=sessionFactory.getCurrentSession();
			session.update(category);
			System.out.println("Category Updated Success");
			return true;
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}


	public boolean deleteCategory(Category category) {
		try {
			Session session=sessionFactory.getCurrentSession();
			session.delete(category);
			System.out.println("category deleted");
			return true;
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}


	public Category getCategory(int categoryid) {
		Session session=sessionFactory.openSession();
		Category category=(Category)session.get(Category.class, categoryid);
		session.close();
       return category;
	}

	@Override
	public List<Category> getCategories(Category category) {
		try {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("From Category");
		List<Category>List=query.list();
		session.close();
		return List;
		
	}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}

	}

}
