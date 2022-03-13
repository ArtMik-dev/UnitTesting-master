package JUnit;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import shop.RealItem;

import static org.junit.jupiter.api.Assertions.*;

class RealItemTest {

    RealItem realItem = new RealItem();

    @Tag("RealItem")
    @Test
    void weightTest() {
        double expectedWeight = 2;

        realItem.setWeight(expectedWeight);

        double actualWeight = realItem.getWeight();

        assertEquals(actualWeight, expectedWeight, 0);
    }
}