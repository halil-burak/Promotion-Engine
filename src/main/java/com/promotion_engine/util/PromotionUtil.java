package com.promotion_engine.util;

import com.promotion_engine.promotion.BundlePromotion;
import com.promotion_engine.promotion.Promotion;
import com.promotion_engine.promotion.SingleProductGroupPromotion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PromotionUtil {
    public static List<Promotion> setupPromotions() {
        List<Promotion> promotions = new ArrayList<>();
        BundlePromotion bundlePromotion = new BundlePromotion(Arrays.asList("C", "D"), 30.0);
        SingleProductGroupPromotion singleProductGroupPromotionA = new SingleProductGroupPromotion("A", 3, 130.0);
        SingleProductGroupPromotion singleProductGroupPromotionB = new SingleProductGroupPromotion("B",2, 45.0);
        promotions.add(bundlePromotion);
        promotions.add(singleProductGroupPromotionA);
        promotions.add(singleProductGroupPromotionB);
        return promotions;
    }
}
