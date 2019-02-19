package com.hbc.paintshop.parser;

import com.hbc.paintshop.model.PaintShop;
import org.junit.Test;

import static org.junit.Assert.*;

public class TextFilePaintShopParserTest {

    @Test
    public void parse_file_successfully() {
        TextFilePaintShopParser parser = new TextFilePaintShopParser();
        parser.setFile("src/test/resources/input1.txt");
        PaintShop paintShop = parser.parse();
        assertEquals(5, paintShop.getNumberOfColors());
        assertEquals(3, paintShop.getCustomers().size());
        assertEquals("[1 M, 3 G, 5 G]", paintShop.getCustomers().get(0).getPreferences().toString());
        assertEquals("[2 G, 3 M, 4 G]", paintShop.getCustomers().get(1).getPreferences().toString());
        assertEquals("[5 M]", paintShop.getCustomers().get(2).getPreferences().toString());
    }

    @Test
    public void parse_customer_preferences_ordered() {
        TextFilePaintShopParser parser = new TextFilePaintShopParser();
        parser.setFile("src/test/resources/input2.txt");
        PaintShop paintShop = parser.parse();
        assertEquals(5, paintShop.getNumberOfColors());
        assertEquals(3, paintShop.getCustomers().size());
        assertEquals("[1 G, 3 G, 5 M]", paintShop.getCustomers().get(0).getPreferences().toString());
        assertEquals("[2 M, 3 G, 4 G]", paintShop.getCustomers().get(1).getPreferences().toString());
        assertEquals("[5 M]", paintShop.getCustomers().get(2).getPreferences().toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void parse_file_with_wrong_format() {
        TextFilePaintShopParser parser = new TextFilePaintShopParser();
        parser.setFile("src/test/resources/wrong-format.txt");
        parser.parse();
    }

    @Test
    public void fail_to_load_file() {
        TextFilePaintShopParser parser = new TextFilePaintShopParser();
        parser.setFile("src/test/resources/does-not-exist.txt");
        assertNull(parser.parse());
    }
}