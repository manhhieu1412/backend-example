package model;

public class Categories {
    public String categoryID;
    public String categoryName;
    public String description;

    public Categories(String categoryID, String categoryName, String description) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.description = description;
    }

    @Override
    public String toString() {
        return "categories{" +
                "categoryID='" + categoryID + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
