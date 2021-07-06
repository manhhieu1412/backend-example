package model;

public class Product {
    public String productID;
    public String productName;
    public String supplierID;
    public String categoryID;
    public String unit;
    public String price;

    public Product(String productID, String productName, String supplierID, String categoryID, String unit, String price) {
        this.productID = productID;
        this.productName = productName;
        this.supplierID = supplierID;
        this.categoryID = categoryID;
        this.unit = unit;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID='" + productID + '\'' +
                ", productName='" + productName + '\'' +
                ", supplierID='" + supplierID + '\'' +
                ", categoryID='" + categoryID + '\'' +
                ", unit='" + unit + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
