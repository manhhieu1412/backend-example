package model;

public class InnerTest {
    public int orderID;
    public String customerName;
    public String shipperID;

    public InnerTest(int orderID, String customerName, String shipperID) {
        this.orderID = orderID;
        this.customerName = customerName;
        this.shipperID = shipperID;
    }

    @Override
    public String toString() {
        return "InnerTest{" +
                "orderID=" + orderID +
                ", customerName='" + customerName + '\'' +
                ", shipperID='" + shipperID + '\'' +
                '}';
    }
}
