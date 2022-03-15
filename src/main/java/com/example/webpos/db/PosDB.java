package com.example.webpos.db;

import com.example.webpos.model.Cart;
import com.example.webpos.model.Product;

import java.util.List;

public interface PosDB {

    List<Product> getProducts();

    Cart saveCart(Cart cart);

    Cart getCart();

    Product getProduct(String productId);

}
