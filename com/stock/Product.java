package com.stock;

public class Product {
	int productId;
	String productName;
	float price;
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	Product(int a, String b, float c){
		this.productId= a;
		this.productName=b;
		this.price=c;
	}
}
