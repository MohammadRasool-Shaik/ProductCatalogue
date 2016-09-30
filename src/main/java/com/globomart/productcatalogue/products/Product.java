/**
 * 
 */
package com.globomart.productcatalogue.products;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Rasool.Shaik
 *
 */
@Entity
@Table(name = "product")
public class Product implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7335576478725557679L;

	@Id
	@GeneratedValue
	private Integer productId;

	@Column(name = "pname", nullable = false, length = 50)
	private String productName;

	@Column(nullable = false, length = 10)
	private String productType;

	@Column(nullable = false, scale = 2)
	private Double productPrice;

	/**
	 * 
	 */
	public Product() {
		super();
	}

	/**
	 * @param productName
	 * @param productType
	 * @param productPrice
	 */
	public Product(String productName, String productType, Double productPrice) {
		super();
		this.productName = productName;
		this.productType = productType;
		this.productPrice = productPrice;
	}

	/**
	 * @return the productId
	 */
	public Integer getProductId() {
		return productId;
	}

	/**
	 * @param productId
	 *            the productId to set
	 */
	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName
	 *            the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the productPrice
	 */
	public Double getProductPrice() {
		return productPrice;
	}

	/**
	 * @param productPrice
	 *            the productPrice to set
	 */
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	/**
	 * @return the productType
	 */
	public String getProductType() {
		return productType;
	}

	/**
	 * @param productType
	 *            the productType to set
	 */
	public void setProductType(String productType) {
		this.productType = productType;
	}

}
