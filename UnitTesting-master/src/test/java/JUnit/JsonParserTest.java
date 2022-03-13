package JUnit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import parser.JsonParser;
import parser.NoSuchFileException;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class JsonParserTest {

    private final JsonParser jsonParser = new JsonParser();

    private final String fileName = "test-cart";
    private final String filePath = "./src/main/resources/%s.json";


    @Disabled("Disabled test")
    @Tag("JSTest")
    @Test
    public void writeEmptyCartTest() {
        Cart testCart = new Cart(fileName);

        String expected = "{\"cartName\":\"test-cart\",\"realItems\":[],\"virtualItems\":[],\"total\":0.0}";

        jsonParser.writeToFile(testCart);

        try {
            String path = String.format(filePath, fileName);
            assertEquals(expected, readFileAsString(path));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Tag("JSTest")
    @Test
    public void readValidTest() {
        Cart testCart = createCart();
        File file = new File(String.format(filePath, fileName));

        jsonParser.writeToFile(testCart);

        assertEquals(testCart.getCartName(), jsonParser.readFromFile(file).getCartName());
        assertEquals(testCart.getTotalPrice(), jsonParser.readFromFile(file).getTotalPrice());
    }

    @Tag("JSTest")
    @ParameterizedTest
    @ValueSource(strings = {"a", "0", "22", ".=&$", "G43 "})
    public void readInvalidTest(String fileName) {
        File file = new File(String.format(filePath, fileName));

        assertThrows(NoSuchFileException.class,() -> jsonParser.readFromFile(file));
    }

    @AfterEach
    public void cleanUpEach() throws IOException {

        Path path = FileSystems.getDefault().getPath(String.format(filePath, fileName));

        if (Files.exists(path)) {
            Files.delete(path);
        }
    }

    private Cart createCart(){
        Cart testCart = new Cart(fileName);

        RealItem car = new RealItem();
        car.setName("Audi");
        car.setPrice(32026.9);
        car.setWeight(1560);

        VirtualItem disk = new VirtualItem();
        disk.setName("Windows");
        disk.setPrice(11);
        disk.setSizeOnDisk(20000);

        testCart.addRealItem(car);
        testCart.addVirtualItem(disk);

        return testCart;
    }

    private String readFileAsString(String file)throws Exception
    {
        return new String(Files.readAllBytes(Paths.get(file)));
    }
}