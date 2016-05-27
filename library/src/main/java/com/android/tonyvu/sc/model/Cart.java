package com.android.tonyvu.sc.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.android.tonyvu.sc.exception.ProductNotFoundException;
import com.android.tonyvu.sc.exception.QuantityOutOfRangeException;

//Een shopping cart heeft een mapje van saleable producten en de bijbehorende kwantiteiten (zie tutorial shopping cart india dude)

public class Cart implements Serializable {
    private static final long serialVersionUID = 42L;

    private Map<Saleable, Integer> cartItemMap = new HashMap<Saleable, Integer>();
    private BigDecimal totalPrice = BigDecimal.ZERO;
    private int totalQuantity = 0;

    //Voeg een kwantiteit van een saleable product aan de winkelwagen toe, bij sellable wordt het product toegevoegd aan de shopping cart en quantity wordt het aantal toegevoegd

    public void add(final Saleable sellable, int quantity) {
        if (cartItemMap.containsKey(sellable)) {
            cartItemMap.put(sellable, cartItemMap.get(sellable) + quantity);
        } else {
            cartItemMap.put(sellable, quantity);
        }

        totalPrice = totalPrice.add(sellable.getPrice().multiply(BigDecimal.valueOf(quantity)));
        totalQuantity += quantity;
    }

    // Stel een nieuwe kwantiteit in, productnotfoundexception throwt als het product niet in de shoppingcart wordt gevonden & quantityoutofrangeexception throwt als de kwantiteit negatief is

    public void update(final Saleable sellable, int quantity) throws ProductNotFoundException, QuantityOutOfRangeException {
        if (!cartItemMap.containsKey(sellable)) throw new ProductNotFoundException();
        if (quantity < 0)
            throw new QuantityOutOfRangeException(quantity + " is geen geldig aantal. Het aantal dient 1 of hoger te zijn");

        int productQuantity = cartItemMap.get(sellable);
        BigDecimal productPrice = sellable.getPrice().multiply(BigDecimal.valueOf(productQuantity));

        cartItemMap.put(sellable, quantity);

        totalQuantity = totalQuantity - productQuantity + quantity;
        totalPrice = totalPrice.subtract(productPrice).add(sellable.getPrice().multiply(BigDecimal.valueOf(quantity)));
    }

    //Verwijder producten uit de shopping cart, sellable is hetgeen verwijderd wordt, quantity het aantal

    public void remove(final Saleable sellable, int quantity) throws ProductNotFoundException, QuantityOutOfRangeException {
        if (!cartItemMap.containsKey(sellable)) throw new ProductNotFoundException();

        int productQuantity = cartItemMap.get(sellable);

        if (quantity < 0 || quantity > productQuantity)
            throw new QuantityOutOfRangeException(quantity + " is geen geldig aantal. Aantal dient minder te zijn dan het aantal dat in de winkelwagen zit");

        if (productQuantity == quantity) {
            cartItemMap.remove(sellable);
        } else {
            cartItemMap.put(sellable, productQuantity - quantity);
        }

        totalPrice = totalPrice.subtract(sellable.getPrice().multiply(BigDecimal.valueOf(quantity)));
        totalQuantity -= quantity;
    }

    // Verwijder een saleable product volledig uit de winkelwagen, sellabe is het product dat verwijderd wordt

    public void remove(final Saleable sellable) throws ProductNotFoundException {
        if (!cartItemMap.containsKey(sellable)) throw new ProductNotFoundException();

        int quantity = cartItemMap.get(sellable);
        cartItemMap.remove(sellable);
        totalPrice = totalPrice.subtract(sellable.getPrice().multiply(BigDecimal.valueOf(quantity)));
        totalQuantity -= quantity;
    }

    // Verwijder alles uit de winkelwagen

    public void clear() {
        cartItemMap.clear();
        totalPrice = BigDecimal.ZERO;
        totalQuantity = 0;
    }

    public int getQuantity(final Saleable sellable) throws ProductNotFoundException {
        if (!cartItemMap.containsKey(sellable)) throw new ProductNotFoundException();
        return cartItemMap.get(sellable);
    }

    // Haal totale kosten van een product (saleable) op in de winkelwagen

    public BigDecimal getCost(final Saleable sellable) throws ProductNotFoundException {
        if (!cartItemMap.containsKey(sellable)) throw new ProductNotFoundException();
        return sellable.getPrice().multiply(BigDecimal.valueOf(cartItemMap.get(sellable)));
    }

    // Haal cumulatieve prijs van alle producten op (maak nog onderscheid liquids Millers Juice en de hardware / groothandel (vragen Koen)

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    // Totale kwantiteit van alle producten

    public int getTotalQuantity() {
        return totalQuantity;
    }

    // Haal set producten op

    public Set<Saleable> getProducts() {
        return cartItemMap.keySet();
    }

    // Mapje producten en haar kwantiteit

    public Map<Saleable, Integer> getItemWithQuantity() {
        Map<Saleable, Integer> cartItemMap = new HashMap<Saleable, Integer>();
        cartItemMap.putAll(this.cartItemMap);
        return cartItemMap;
    }

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();
        for (Entry<Saleable, Integer> entry : cartItemMap.entrySet()) {
            strBuilder.append(String.format("Product: %s, Unit Price: %f, Quantity: %d%n", entry.getKey().getName(), entry.getKey().getPrice(), entry.getValue()));
        }
        strBuilder.append(String.format("Total Quantity: %d, Total Price: %f", totalQuantity, totalPrice));

        return strBuilder.toString();
    }
}
