package com.niit;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.autoback.dao.CartDao;
import com.niit.autoback.model.CartItems;

public class CartItemsTestCase {

	static CartDao cartDao;

	@BeforeClass
	public  static void initialize()
	{
		AnnotationConfigApplicationContext context =new AnnotationConfigApplicationContext("com");
		cartDao=(CartDao)context.getBean("cartDao");
	}
	@Ignore
	@Test
	public void addcart() {
		CartItems cart =new CartItems();
		//cart.setCartitemid(0);
		cart.setOrderid(2);
		cart.setPrice(600);
		cart.setProductid(1);
		cart.setProductname("name");
		cart.setQuantity(2);
		cart.setUsername("santhosh");
		cart.setStatus("P");
		assertEquals("New Cart Cannot be created",true,cartDao.addCartitem(cart));
	}
	/*@Ignore*/
	@Test
	public void listCartItemsTest()
	{
	List<CartItems> listCart=cartDao.listcartItems("santhosh");
	System.out.println(listCart.size());
	assertTrue("Problem in Listing CartItems From Database",listCart.size()>0);
	for(CartItems cart:listCart)
	{
		System.out.println(cart.getProductname()+ "  ");
		System.out.println(cart.getUsername() + " ");
		System.out.println(cart.getStatus()+ " "+cart.getOrderid());
	}
	}
}
