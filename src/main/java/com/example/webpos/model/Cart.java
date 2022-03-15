package com.example.webpos.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cart {

    private List<Item> items = new ArrayList<>();

    public boolean addItem(Item item) {
        boolean flag = true;
        for (var i : items) {
            if (i.getProduct().getId().equals(item.getProduct().getId())) {
                i.setQuantity(i.getQuantity() + item.getQuantity());
                flag = false;
            }
        }
        if (flag) {
            items.add(item);
        }
        return true;
    }

    public void clear() {
        items.clear();
    }

    public double subTotal() {
        double total = 0;
        for (var i : items) {
            total += i.getPrice();
        }
        return total;
    }

    public boolean removeItem(String productId, int amount) {
        for (var item : items) {
            if (item.getProduct().getId().equals(productId)) {
                if (item.getQuantity() - amount <= 0) {
                    return items.remove(item);
                } else {
                    item.setQuantity(item.getQuantity() - amount);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        if (items.size() == 0) {
            return "Empty Cart";
        }
        double total = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cart -----------------\n");

        for (Item item : items) {
            stringBuilder.append(item.toString()).append("\n");
            total += item.getQuantity() * item.getProduct().getPrice();
        }
        stringBuilder.append("----------------------\n");

        stringBuilder.append("Total...\t\t\t").append(total);

        return stringBuilder.toString();
    }
}
