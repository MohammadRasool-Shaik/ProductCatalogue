/**
 * 
 */
package com.globomart.productcatalogue.pricing;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * @author Rasool.Shaik
 *
 */
@JsonRootName("Product")
public class ProductDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7335576478725557679L;

	private Integer productId;

	private String productName;

	private String productType;

	private Double productPrice;

	/**
	 * 
	 */
	public ProductDTO() {
		super();
	}

	/**
	 * @param productName
	 * @param productType
	 * @param productPrice
	 */
	public ProductDTO(String productName, String productType, Double productPrice) {
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
