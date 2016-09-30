/**
 * 
 */
package com.globomart.productcatalogue.services.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import com.globomart.productcatalogue.products.ProductRepository;
import com.globomart.productcatalogue.products.ProductsConfiguration;

/**
 * @author Rasool.Shaik
 *
 */
@EnableAutoConfiguration
@EnableDiscoveryClient
@Import(ProductsConfiguration.class)
public class ProductsServer {

	@Autowired
	protected ProductRepository productRepository;

	public static void main(String[] args) {
		// Tell server to look for products-server.properties or
		// products-server.yml
		System.setProperty("spring.config.name", "products-server");

		SpringApplication.run(ProductsServer.class, args);
	}
}
