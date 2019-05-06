package com.niit.autoback.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.autoback.model.CartItems;
@Repository("cartDao")
@Transactional
public class CartDaoImpl implements CartDao {

	@Autowired
	SessionFactory sessionFactory;
	public boolean addCartitem(CartItems cartItem) {
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.save(cartItem);
			return true;
		}
		catch(Exception e )
		{
			return false;
		}
	}

	@Override
	public boolean deleteCartItem(CartItems carItem) {
		try {
			Session session=sessionFactory.getCurrentSession();
			session.delete(carItem);
			return true;
		}
		catch(Exception e )
		{
			return false;
		}
	}

	public CartItems getCartItem(int cartItemId) {
		try {
			Session session=sessionFactory.openSession();
			CartItems cart=(CartItems) session.get(CartItems.class, cartItemId);
			return cart;
		}
		catch(Exception e ) 
		{
			return null;
		}
	}

	@Override
	public List<CartItems> listcartItems(String userName) 
	{
		try {
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from CartItems  where username=:userName");
			query.setParameter("userName", userName);
			List<CartItems> listCartItems=(List<CartItems>) query.list();
			return listCartItems;

		}
		catch(Exception e)
		{
			return null;
		}
	}

	@Override
	public boolean updateCartItem(int cartitemId) {
		// TODO Auto-generated method stub
		return false;
	}

}
