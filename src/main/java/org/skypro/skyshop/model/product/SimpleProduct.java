package org.skypro.skyshop.model.product;

import java.util.UUID;

public class SimpleProduct extends Product {
    private int price;

    public SimpleProduct(String name, int price, UUID id) {
        super(name, id);
        if (price < 1) {
            throw new IllegalArgumentException("Ошибка! Некорректная цена продукта!");
        }
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + " руб.";
    }
}
