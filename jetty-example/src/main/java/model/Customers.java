package model;

import org.rythmengine.utils.S;

public class Customers {
    public String customerID;
    public String customerName;
    public String contactName;
    public String address;
    public String city;
    public String postalCode;
    public String country;

    public Customers(String customerID, String customerName, String contactName, String address, String city, String postalCode, String country) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.contactName = contactName;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "customerID='" + customerID + '\'' +
                ", customerName='" + customerName + '\'' +
                ", contactName='" + contactName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
