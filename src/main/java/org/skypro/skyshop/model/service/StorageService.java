package org.skypro.skyshop.model.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StorageService {
    private final Map<UUID, Product> productStorage;
    private final Map<UUID, Article> articleStorage;

    public StorageService() {
        this.productStorage = new HashMap<>();
        this.articleStorage = new HashMap<>();
        this.fillStorageService();
    }

    public Map<UUID, Product> getProductStorage() {
        return productStorage;
    }

    public Map<UUID, Article> getArticleStorage() {
        return articleStorage;
    }

    private void fillStorageService() {
        Product[] products = {new FixPriceProduct("Молоко", UUID.randomUUID()),
                new FixPriceProduct("Хлеб", UUID.randomUUID()),
                new SimpleProduct("Масло", 150, UUID.randomUUID()),
                new DiscountedProduct("Шоколад", 80, 10, UUID.randomUUID()),
                new DiscountedProduct("Мороженное", 130, 20, UUID.randomUUID()),
                new SimpleProduct("Колбаса", 400, UUID.randomUUID()),
                new SimpleProduct("Сок", 150, UUID.randomUUID())};

        Article[] articles = {new Article("О молоке.", "Молоко полезно для ребенка!", UUID.randomUUID()),
                new Article("Про коньяк.", "Алкоголь вреден беременным.", UUID.randomUUID()),
                new Article("Про масло.", "Кашу маслом не испортишь!", UUID.randomUUID()),
                new Article("Хлеб.", "Хлеб - всему голова!", UUID.randomUUID())};

        for (Product product : products) {
            productStorage.put(product.getId(), product);
        }

        for (Article article : articles) {
            articleStorage.put(article.getId(), article);
        }
    }

    public Set<Searchable> createSearchableCollection() {
        Set<Searchable> searchable = new HashSet<>();
        searchable.addAll(productStorage.values());
        searchable.addAll(articleStorage.values());
        return searchable;
    }
}
