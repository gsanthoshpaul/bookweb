package com.niit.autoback.dao;

import java.util.List;

import com.niit.autoback.model.CartItems;

public interface CartDao {
	public boolean addCartitem(CartItems cartItem);
	public boolean deleteCartItem(CartItems carItem);
	public boolean updateCartItem(int cartitemId);
	public CartItems getCartItem(int cartItemId);
	public List<CartItems> listcartItems(String username);

}
