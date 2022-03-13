package JUnit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import shop.Cart;
import shop.RealItem;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    @Tag("CartTest")
    @Test
    void cartNameAndPriceTest() {
        String expectedName = "test-cart";
        Cart testCart = new Cart(expectedName);

        assertAll("Cart name and price after cart creation",
                () -> assertEquals(expectedName, testCart.getCartName()),
                () -> assertEquals(0, testCart.getTotalPrice())
        );
    }

    @Tag("CartTest")
    @Test
    void calculateTotalTest() {
        String expectedName = "test-cart";
        double itemPrice = 5;
        double TAX = 0.2;

        Cart testCart = new Cart(expectedName);
        RealItem realItem = new RealItem();
        realItem.setPrice(itemPrice);
        testCart.addRealItem(realItem);

        double expectedTotal = itemPrice + itemPrice*TAX;
        double actualTotal = testCart.getTotalPrice();

        assertEquals( expectedTotal, actualTotal, 0);
    }
}