package pt.ipca.androidbookdwm;

import android.app.Application;
import java.util.ArrayList;
import java.util.List;

public class ProductManagerApp extends Application {


    List<Product> lstProduct = new ArrayList<>();
    @Override
    public void onCreate(){
        super.onCreate();

        Category cat1 = new Category("Peixaria","Onde se vende peixe","azul");
        Product prod1 = new Product("peixinho","peixinho do mar",1, 123,"un",cat1);
        Product prod2 = new Product("Carpa ","peixinho do mar",1, 50,"un",cat1);
        Product prod3 = new Product("Douradinhos","peixinho do mar",1, 123,"un",cat1);


        addProduct(prod1);
        addProduct(prod2);
        addProduct(prod3);

    }

    @Override
    public void onTerminate(){
        super.onTerminate();
    }


    public void addProduct(Product product)
    {
        lstProduct.add(product);

    }

    public void removeProduct(int position)
    {
        lstProduct.remove(position);
    }


    //Get /set
    public List<Product> getLstProduct() {
        return lstProduct;
    }
}
