package com.example.webpos.biz;

import com.example.webpos.model.Cart;
import com.example.webpos.model.Product;

import java.util.List;

public interface PosService {
    Cart getCart();

    Cart newCart();

    String checkout();

    double total(Cart cart);

    boolean add(Product product, int amount);

    boolean add(String productId, int amount);

    boolean remove(String productId, int amount);

    boolean clear();

    double getTaxRate();

    double getDiscountRate();

    List<Product> products();
}
