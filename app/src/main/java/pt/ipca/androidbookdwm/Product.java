package pt.ipca.androidbookdwm;

public class Product {

    //Variaveis
    private String name, description, category, unityType;
    private int picture;
    private int price;
    private Category cat1;

    //Construtor
    public Product(String name, String description, int picture, int price, String unityType, Category cat1) {
        this.name = name;
        this.description = description;
        this.picture = picture;
        this.price = price;
        this.unityType = unityType;
        this.cat1 = cat1;
    }

    //Métodos
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPicture() {
        return picture;
    }

    public String getCategory() {
        return category;
    }

    public String getCategoryName() {
        return cat1.getName();
    }

    public String getCategoryColor() {
        return cat1.getColor();
    }

    public int getPrice() {
        return price;
    }

    public String getUnityType() {
        return unityType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setUnityType(String unityType) {
        this.unityType = unityType;
    }
}