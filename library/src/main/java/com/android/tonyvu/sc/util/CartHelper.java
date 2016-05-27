package com.android.tonyvu.sc.util;

import com.android.tonyvu.sc.model.Cart;

// Winkelwagen ophalen helper class (zie India dude tutorial -> shopping cart

public class CartHelper {
    private static Cart cart = new Cart();

    public static Cart getCart() {
        if (cart == null) {
            cart = new Cart();
        }

        return cart;
    }
}
