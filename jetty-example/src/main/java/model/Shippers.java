package model;

public class Shippers {
    public int shipperID;
    public String shipperName;
    public String phone;

    public Shippers(int shipperID, String shipperName, String phone) {
        this.shipperID = shipperID;
        this.shipperName = shipperName;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Shippers{" +
                "shipperID=" + shipperID +
                ", shipperName='" + shipperName + '\'' +
                ", phone=" + phone +
                '}';
    }
}
