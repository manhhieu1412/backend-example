package model;

public class Left {
    public String CustomerName;
    public int OderID;

    public Left(String customerName, int oderID) {
        CustomerName = customerName;
        OderID = oderID;
    }

    @Override
    public String toString() {
        return "left{" +
                "CustomerName='" + CustomerName + '\'' +
                ", OderID=" + OderID +
                '}';
    }
}
