package org.skypro.skyshop.model.basket;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.*;

@Component
@SessionScope
public class ProductBasket {
    private final Map<UUID, Integer> products;

    public ProductBasket() {
        this.products = new HashMap<>();
    }

    public void addProduct(UUID id) {
        products.merge(id, 1, Integer::sum);
        System.out.println("Продукт с id" + id + "успешно добавлен в корзину");
    }

    public Map<UUID, Integer> getProductsList() {
        return Collections.unmodifiableMap(products);
    }
}
