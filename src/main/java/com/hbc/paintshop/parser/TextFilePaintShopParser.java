package com.hbc.paintshop.parser;

import com.hbc.paintshop.model.PaintShop;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.IllegalFormatException;
import java.util.List;

@Component
public class TextFilePaintShopParser implements PaintShopParser {

    private String file;

    @Override
    public PaintShop parse() {
        try {
            List<String> lines = FileUtils.readLines(FileUtils.getFile(file), "UTF-8");
            if(lines != null && lines.size() >= 2){
                PaintShop paintShop = new PaintShop();
                paintShop.setNumberOfColors(Integer.valueOf(lines.get(0)));
                paintShop.setCustomerOrders(lines.subList(1, lines.size()));
                return paintShop;
            }
            throw new IllegalArgumentException("File has wrong format.");
        } catch (IOException e) {
            //TODO log error
            return null;
        }
    }

    @Value("${fileLocation:}")
    public void setFile(String file) {
        this.file = file;
    }

}
