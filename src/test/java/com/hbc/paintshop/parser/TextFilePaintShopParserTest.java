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
        assertEquals(3, paintShop.getCustomerOrders().size());
        assertEquals("1 M 3 G 5 G", paintShop.getCustomerOrders().get(0));
        assertEquals("2 G 3 M 4 G", paintShop.getCustomerOrders().get(1));
        assertEquals("5 M", paintShop.getCustomerOrders().get(2));
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