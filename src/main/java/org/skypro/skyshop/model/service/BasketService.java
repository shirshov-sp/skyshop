package org.skypro.skyshop.model.service;

import org.skypro.skyshop.model.basket.BasketItem;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BasketService {
    private final ProductBasket productBasket;
    private final StorageService storageService;

    public BasketService(ProductBasket productBasket, StorageService storageService) {
        this.productBasket = productBasket;
        this.storageService = storageService;
    }

    public void addProductInProductBasket(UUID id) {
        if (storageService.getProductById(id).isEmpty()) {
            throw new IllegalArgumentException("Ошибка! Такого продукта нет!");
        }
        productBasket.addProduct(id);
    }

    public UserBasket getUserBasket() {
        UserBasket userBasket = new UserBasket(productBasket.getProductsList().entrySet().stream()
                .flatMap(entry ->
                        storageService.getProductById(entry.getKey())
                                .map(product -> new BasketItem(product, entry.getValue()))
                                .stream()
                )
                .collect(Collectors.toList()));
        return userBasket;
    }
}
