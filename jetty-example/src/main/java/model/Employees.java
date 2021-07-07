package model;

public class Employees {
    public String employeeID;
    public String lastName;
    public String firstName;
    public String birthdate;
    public String photo;
    public String notes;

    public Employees(String employeeID, String lastName, String firstName, String birthdate, String photo, String notes) {
        this.employeeID = employeeID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthdate = birthdate;
        this.photo = photo;
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "employeeID='" + employeeID + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", photo='" + photo + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
