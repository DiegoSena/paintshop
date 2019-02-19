package com.hbc.paintshop;

import com.hbc.paintshop.model.PaintShop;
import com.hbc.paintshop.parser.PaintShopParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class PaintshopApplication implements CommandLineRunner {

	@Autowired
	private PaintShopParser inputParser;

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(PaintshopApplication.class);
		app.run(args);

	}

	@Override
	public void run(String... args) throws Exception {
		PaintShop paintShop = inputParser.parse();
		System.out.println(paintShop.getNumberOfColors());
		System.out.println(paintShop.getCustomerOrders());
	}
}
