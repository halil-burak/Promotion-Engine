import com.promotion_engine.model.Cart;
import com.promotion_engine.model.Product;
import com.promotion_engine.promotion.Promotion;
import com.promotion_engine.service.PromotionService;
import com.promotion_engine.service.PromotionServiceImpl;
import com.promotion_engine.util.PromotionUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PromotionServiceImplTest {
    private static PromotionService promotionService;
    private static List<Promotion> promotions;
    private static Cart cart;
    private static Product productA;
    private static Product productB;
    private static Product productC;
    private static Product productD;

    @BeforeAll
    public static void setup() {
        promotionService = new PromotionServiceImpl();
        promotions = PromotionUtil.setupPromotions();
        cart = new Cart();
        productA = new Product("A");
        productB = new Product("B");
        productC = new Product("C");
        productD = new Product("D");
    }

    @Test
    public void testBundlePromotionAppliedOnCart() {
        Map<Product, Integer> testContents = new HashMap<>();
        testContents.put(productA, 3);
        testContents.put(productB, 5);
        testContents.put(productC, 1);
        testContents.put(productD, 1);
        cart.setContents(testContents);
        Double checkoutPrice = promotionService.getPromotedPrice(cart, promotions);
        assertEquals(280.0, checkoutPrice);
    }

    @Test
    public void testCartWithNoAvailablePromotion() {
        Map<Product, Integer> testContents = new HashMap<>();
        testContents.put(productA, 1);
        testContents.put(productB, 1);
        testContents.put(productC, 1);
        cart.setContents(testContents);
        Double checkoutPrice = promotionService.getPromotedPrice(cart, promotions);
        assertEquals(100.0, checkoutPrice);
    }

    @Test
    public void testSingleProductGroupingPromotionAppliedOnCart() {
        Map<Product, Integer> testContents = new HashMap<>();
        testContents.put(productA, 5);
        testContents.put(productB, 5);
        testContents.put(productC, 1);
        cart.setContents(testContents);
        Double checkoutPrice = promotionService.getPromotedPrice(cart, promotions);
        assertEquals(370.0, checkoutPrice);
    }
}
