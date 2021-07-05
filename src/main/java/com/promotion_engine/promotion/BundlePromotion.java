package com.promotion_engine.promotion;

import com.promotion_engine.model.Cart;
import com.promotion_engine.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BundlePromotion implements Promotion {
    private List<String> appliedItems = new ArrayList<>();
    private Double promotedPrice;
    private Map<String, Boolean> availabilityCheckMap = new HashMap<>();

    public BundlePromotion(List<String> items, Double promotedPrice) {
        this.appliedItems.addAll(items);
        this.promotedPrice = promotedPrice;
    }

    @Override
    public Cart applyPromotion(Cart cart) {
        return null;
    }

    /*
    * Returns true if the bundle promotion is applicable to the current cart contents
    * */
    @Override
    public Boolean isAvailable(Cart cart) {
        appliedItems.forEach(i -> availabilityCheckMap.put(i, false));

        for (Map.Entry<Product, Integer> kv: cart.getContents().entrySet()) {
            if (appliedItems.contains(kv.getKey().getName())) {
                availabilityCheckMap.put(kv.getKey().getName(), true);
            }
        }
        return availabilityCheckMap.containsValue(true);
    }

    @Override
    public Double getDiscountedPrice() {
        return null;
    }
}
