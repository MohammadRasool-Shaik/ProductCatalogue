/**
 * 
 */
package org.rash.productcatalogue.products;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.rash.productcatalogue.exceptions.ProductNotFoundException;

/**
 * @author Rasool.Shaik
 *
 */
@RestController
@RequestMapping(value = "/products", produces = { MediaType.APPLICATION_JSON_VALUE })
public class ProductController {
	protected Logger logger = Logger.getLogger(ProductController.class.getName());
	protected ProductRepository productRepository;

	@Autowired
	public ProductController(ProductRepository productRepository) {
		this.productRepository = productRepository;

		logger.info("ProductRepository says system has " + productRepository.countProducts() + " products");
	}

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Product> fetchAllProducts() {
		return productRepository.findAll();
	}

	@RequestMapping(value = "/{productId}", method = RequestMethod.GET)
	public @ResponseBody Product fetchByProductId(@PathVariable Integer productId) {
		Product product = productRepository.findByProductId(productId);
		if (product == null)
			throw new ProductNotFoundException(productId);
		else {
			return product;
		}
	}
	@RequestMapping(method = RequestMethod.GET, params = { "lowPrice", "highPrice" })
	public @ResponseBody List<Product> fetchByProductPrice(@RequestParam("lowPrice") Double lowPrice,

			@RequestParam("highPrice") Double highPrice) {
		return productRepository.findByProductPrice(lowPrice, highPrice);
	}

	@RequestMapping(method = RequestMethod.GET, params = "ptype")
	public @ResponseBody List<Product> fetchByProductType(@RequestParam("ptype") String ptype) {
		return productRepository.findByProductType(ptype);
	}

	@RequestMapping(method = RequestMethod.GET, params = "productName")
	public @ResponseBody List<Product> fetchByProductName(@RequestParam("productName") String productName) {
		return productRepository.findByProductNameIgnoreCase(productName);
	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Product createProduct(Product product) {
		return productRepository.save(product);
	}

	@RequestMapping(value = "/{productId}", method = RequestMethod.DELETE)
	public @ResponseBody Integer removeProduct(@PathVariable Integer productId) {
		return productRepository.removeByProductId(productId);
	}
}
