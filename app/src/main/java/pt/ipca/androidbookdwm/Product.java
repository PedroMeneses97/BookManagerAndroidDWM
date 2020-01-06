package pt.ipca.androidbookdwm;

public class Product {

    //Variaveis
    private String name, description, picture, category, unityType;
    private Float price;
    private Category cat1;

    //Construtor
    public Product(String name, String description, String picture, Float price, String unityType, Category cat1) {
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

    public String getPicture() {
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

    public Float getPrice() {
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

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setUnityType(String unityType) {
        this.unityType = unityType;
    }
}