package JUnit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import shop.VirtualItem;

import static org.junit.jupiter.api.Assertions.*;

class VirtualItemTest {

    VirtualItem virtualItem = new VirtualItem();

    @Tag("VirtualItem")
    @Test
    void sizeOnDiskTest() {
        double expectedSizeOn= 20000;

        virtualItem.setSizeOnDisk(expectedSizeOn);

        double actualSizeOn = virtualItem.getSizeOnDisk();

        assertEquals(actualSizeOn, expectedSizeOn, 0);
    }
}