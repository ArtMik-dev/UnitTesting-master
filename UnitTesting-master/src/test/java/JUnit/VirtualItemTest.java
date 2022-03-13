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


    @Test
    void stringRepresentationTest() {
        String expectedName = "name";
        double expectedSize = 200;

        virtualItem.setName(expectedName);
        virtualItem.setSizeOnDisk(expectedSize);

        String expectedString = String.format("Class: class shop.VirtualItem; Name: %s; Price: %s; Size on disk: %s", expectedName, 0.0, expectedSize);
        assertEquals(expectedString, virtualItem.toString());
    }
}