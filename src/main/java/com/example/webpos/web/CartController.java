package com.example.webpos.web;

import com.example.webpos.biz.PosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {

    private PosService posService;

    @Autowired
    public void setPosService(PosService posService) {
        this.posService = posService;
    }

    @PutMapping("/cart/{id}")
    public String addToCart(@PathVariable("id") String id, @RequestParam(value = "quantity", defaultValue = "1") int quantity) {
        System.out.println("addToCart: " + id + " " + quantity);
        var ret = posService.add(id, quantity);
        return ret ? "OK" : "FAIL";
    }

    @DeleteMapping("/cart/{id}")
    public String removeFromCart(@PathVariable("id") String id, @RequestParam(value = "quantity", defaultValue = "1") int quantity) {
        System.out.println("removeFromCart: " + id + " " + quantity);
        var ret = posService.remove(id, quantity);
        return ret ? "OK" : "FAIL";
    }

    @PutMapping("/cart")
    public String newCart() {
        posService.newCart();
        return "OK";
    }

    @PostMapping("/cart")
    public String checkout() {
        if (posService.getCart().subTotal() == 0) {
            return "FAIL";
        }
        posService.checkout();
        posService.newCart();
        return "OK";
    }
}
