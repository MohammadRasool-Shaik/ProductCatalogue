/**
 * 
 */
package com.globomart.productcatalogue.pricing;

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

/**
 * @author Rasool.Shaik
 *
 */
@RestController
@RequestMapping(value = "/pricing", produces = { MediaType.APPLICATION_JSON_VALUE })
public class PricingController {

	@Autowired
	private PricingService pricingService;

	protected Logger logger = Logger.getLogger(PricingController.class.getName());

	public PricingController(PricingService pricingService) {
		this.pricingService = pricingService;
	}

	@RequestMapping(value = "/{productId}", method = RequestMethod.GET)
	public @ResponseBody
	ProductDTO findByProductId(@PathVariable String productId) {

		logger.info("web-service findByProductId() invoked: " + productId);

		ProductDTO product = pricingService.findByProductId(productId);
		logger.info("web-service findByProductId() found: " + product);
		return product;
	}

	@RequestMapping(method = RequestMethod.GET, params = { "lowPrice", "highPrice" })
	public @ResponseBody List<ProductDTO> fetchByProductPrice(@RequestParam Double lowPrice, @RequestParam Double highPrice) {
		List<ProductDTO> products = pricingService.fetchByProductPrice(lowPrice, highPrice);
		return products;
	}

}
