package org.skypro.skyshop.model.basket;

import java.util.List;

public class UserBasket {
    private final List<BasketItem> basketItems;
    private final int total;


    public UserBasket(List<BasketItem> basketItems) {
        this.basketItems = basketItems;
        this.total = sumPrices();
    }

    private int sumPrices() {
        int total = 0;
        total += basketItems.stream()
                .mapToInt(basketItem -> basketItem.getProduct().getPrice() * basketItem.getNumber())
                .sum();
        return total;
    }

    public List<BasketItem> getBasketItems() {
        return basketItems;
    }

    public int getTotal() {
        return total;
    }
}
