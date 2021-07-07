package model;

public class Orders {
    public int oderID;
    public int customerID;
    public int employeeID;
    public String orderDate;
    public int shipperID;

    public Orders(int oderID, int customerID, int employeeID, String orderDate, int shipperID) {
        this.oderID = oderID;
        this.customerID = customerID;
        this.employeeID = employeeID;
        this.orderDate = orderDate;
        this.shipperID = shipperID;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "oderID=" + oderID +
                ", customerID=" + customerID +
                ", employeeID=" + employeeID +
                ", orderDate='" + orderDate + '\'' +
                ", shipperID=" + shipperID +
                '}';
    }
}
