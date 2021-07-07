package model;

public class Order_details {
    public int orderDetailID;
    public int orderID;
    public int productID;
    public int quantity;

    public Order_details(int orderDetailID, int orderID, int productID, int quantity) {
        this.orderDetailID = orderDetailID;
        this.orderID = orderID;
        this.productID = productID;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order_details{" +
                "orderDetailID=" + orderDetailID +
                ", orderID=" + orderID +
                ", productID=" + productID +
                ", quantity=" + quantity +
                '}';
    }
}
