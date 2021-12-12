package com.n08.model;

import java.io.Serializable;

public class Product implements Serializable {
    private int productId;
    private String productName;
    private String productHangSanXuat;
    private double productPrice;
    private int productImage;

    public Product(int productId, String productName, String productHangSanXuat, double productPrice, int productImage) {
        this.productId = productId;
        this.productName = productName;
        this.productHangSanXuat = productHangSanXuat;
        this.productPrice = productPrice;
        this.productImage = productImage;
    }

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

    public String getProductHangSanXuat() {
        return productHangSanXuat;
    }

    public void setProductHangSanXuat(String productHangSanXuat) {
        this.productHangSanXuat = productHangSanXuat;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }
}
