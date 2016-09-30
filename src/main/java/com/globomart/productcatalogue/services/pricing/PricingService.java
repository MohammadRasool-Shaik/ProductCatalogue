/**
 * 
 */
package com.globomart.productcatalogue.services.pricing;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * @author Rasool.Shaik
 *
 */
@Service
public class PricingService {
	@Autowired
	@LoadBalanced
	protected RestTemplate restTemplate;

	protected String serviceUrl;

	protected Logger logger = Logger.getLogger(PricingService.class.getName());

	public PricingService(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl : "http://" + serviceUrl;
	}

	public Product findByProductId(String productId) {

		logger.info("findByProductId() invoked: for " + productId);
		return restTemplate.getForObject(serviceUrl + "/products/{productId}", Product.class, productId);
	}

	public List<Product> fetchByProductPrice(Double lowPrice, Double highPrice) {
		Product[] products = null;
		try {
			products = restTemplate.getForObject(serviceUrl + "/products?lowPrice={lowPrice}&highPrice={highPrice}", Product[].class, lowPrice, highPrice);
		} catch (HttpClientErrorException e) { // 404
			// Nothing found
		}
		if (products == null || products.length == 0)
			return null;
		else
			return Arrays.asList(products);
	}

}
