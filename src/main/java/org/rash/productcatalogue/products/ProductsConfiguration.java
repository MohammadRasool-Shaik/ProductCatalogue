/**
 * 
 */
package org.rash.productcatalogue.products;

import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

/**
 * @author Rasool.Shaik
 *
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan("org.rash.productcatalogue.products")
@EnableJpaRepositories("org.rash.productcatalogue.products")
@PropertySource("classpath:db-config.properties")
public class ProductsConfiguration {

	protected Logger logger;

	public ProductsConfiguration() {
		logger = Logger.getLogger(getClass().getName());
	}

	@Bean
	public DataSource dataSource() {

		DataSource dataSource = (new EmbeddedDatabaseBuilder()).addScript("classpath:schema.sql").addScript("classpath:data.sql").build();

		return dataSource;
	}

}
