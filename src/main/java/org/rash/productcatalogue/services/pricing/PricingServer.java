/**
 * 
 */
package org.rash.productcatalogue.services.pricing;

import org.rash.productcatalogue.pricing.PricingController;
import org.rash.productcatalogue.pricing.PricingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

/**
 * @author Rasool.Shaik
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(useDefaultFilters = false) // Disable component scanner
public class PricingServer {

	public static final String PRODUCTS_SERVICE_URL = "http://PRODUCTS-SERVICE";

	public static void main(String[] args) {
		// Tell server to look for pricing-server.properties or pricing-server.yml
		System.setProperty("spring.config.name", "pricing-server");
		SpringApplication.run(PricingServer.class, args);
	}

	/**
	 * 
	 * @return
	 */
	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	/**
	 * The PricingService encapsulates the interaction with the micro-service.
	 * 
	 * @return A new service instance.
	 */
	@Bean
	public PricingService pricingService() {
		return new PricingService(PRODUCTS_SERVICE_URL);
	}
	
	/**
	 * Create the controller, passing it the {@link PricingService} to use.
	 * 
	 * @return
	 */
	@Bean
	public PricingController pricingController() {
		return new PricingController(pricingService());
	}

}
