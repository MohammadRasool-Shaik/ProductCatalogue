/**
 * 
 */
package org.rash.productcatalogue.products;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author Rasool.Shaik
 *
 */
@Transactional
public interface ProductRepository extends CrudRepository<Product, Integer> {

	List<Product> findAll();

	Product findByProductId(Integer pid);

	@SuppressWarnings("unchecked")
	Product save(Product product);

	Product findOne(Integer id);

	int removeByProductId(Integer pid);

	void delete(Integer id);

	List<Product> findByProductType(String ptype);

	List<Product> findByProductNameIgnoreCase(String name);

	@Query("FROM Product p WHERE p.productPrice BETWEEN :lowPrice AND :highPrice")
	List<Product> findByProductPrice(@Param("lowPrice") Double lowPrice, @Param("highPrice") Double highPrice);

	@Query("SELECT count(*) from Product")
	public int countProducts();
}
