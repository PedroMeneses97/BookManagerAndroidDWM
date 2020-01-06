package pt.ipca.androidbookdwm;

import java.util.ArrayList;
import java.util.List;


public class ShoppingList {

    //Variaveis
    private String name, user; // Name : nome da Lista - User : Quem criou a lista

    private List<User> userList = new ArrayList<>(); // Lista de pessoas com quem a lista foi partilhada
    private List<Product> productList1 = new ArrayList<>(); // Lista de produtos que ainda nao estao no carrinho
    private List<Product> productList2 = new ArrayList<>(); // Lista de produtos já no carrinho


    //Construtor
    public ShoppingList (String name, String user, List<User> userList, List<Product> productList1, List<Product> productList2) {
        this.name = name;
        this.user = user;
        this.userList = userList;
        this.productList1 = productList1;
        this.productList2 = productList2;
    }

    //Metodos


    public String getUserName() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getListName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Product> getProductList1() {
        return productList1;
    }

    public void setProductList1(List<Product> productList1) {
        this.productList1 = productList1;
    }

    public List<Product> getProductList2() {
        return productList2;
    }

    public void setProductList2(List<Product> productList2) {
        this.productList2 = productList2;
    }

    // Total de Produtos dentro e fora do carrinho

    private int contador1;
    private int contador2;

    public int getTotalOfProducts() {
        for (int i = 0; i<= productList1.size(); i++){
            contador1 = i;
        }
        return contador1;
    }

    public int getTotalOfProductsOnShoppingCart() {
        for (int i = 0; i<= productList2.size(); i++){
            contador2 = i;
        }
        return contador2;
    }

    // Valor Total de Produtos dentro e fora do carrinho

    private Float totalPrice1 = new Float(0.0);
    private Float totalPrice2 = new Float(0.0);

    public Float getTotalPrice() {
        for (int i = 0; i< productList1.size(); i++){
            totalPrice1 = Float.sum(totalPrice1 , productList1.get(i).getPrice());
        }
        return totalPrice1;
    }

    public Float getTotalPriceOnCart() {
        for (int i = 0; i< productList2.size(); i++){
            totalPrice2 = Float.sum(totalPrice2 , productList2.get(i).getPrice());
        }
        return totalPrice2;
    }

    // Percentagem de conclusão da compra

    private int contador3;
    private float resultado;
    public float getPercentageCompleted() {
        for (int i = 0; i<=(productList1.size()+ productList2.size()); i++){
            contador3 = i;
        }
        resultado = 100 - (((float) productList1.size() / (float)contador3) * 100);
        return Math.round(resultado);
    }

    // Adicionar Produto

    public void addProduct(Product product) {
        productList1.add(product);
    }

    // Adicionar Produto ao carrinho

    public void addProductToShoppingCart(Product product) {
        productList2.add(product);
    }

    // Remover Produto

    public void removeProduct(Product product) {
        productList1.remove(product);
    }

    // Remover Produto do carrinho

    public void removeProductFromShoppingCart(Product product) {
        productList2.remove(product);
    }







}