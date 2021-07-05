package com.promotion_engine.service;

import com.promotion_engine.model.Cart;
import com.promotion_engine.promotion.Promotion;

import java.util.List;

/**
 * Promotion Service Interface
 */
public interface PromotionService {
    /**
     * Returns the checkout total before applying the promotions.
     * @param cart
     * @return
     */
    public Double getRawPrice(Cart cart);

    /**
     * Returns the price after promotions are applied.
     * @param cart
     * @param promotions
     * @return
     */
    public Double getPromotedPrice(Cart cart, List<Promotion> promotions);
}
