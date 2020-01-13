package pt.ipca.androidbookdwm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import pt.ipca.androidbookdwm.ProductManagerApp;
import pt.ipca.androidbookdwm.R;
import pt.ipca.androidbookdwm.adapters.ProductAdapter;
import pt.ipca.androidbookdwm.interfaces.OnItemResult;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recyclerView;

    private ProductManagerApp pmApp;
    private ProductAdapter pdAdapter;
    //OASDOAOSDOASOO

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setUpToolbar();

        pmApp = ((ProductManagerApp) getApplication());
        recyclerView = findViewById(R.id.books_recycler_view);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());



        recyclerView.setLayoutManager(layoutManager);
        pdAdapter = new ProductAdapter(pmApp.getLstProduct(), new OnItemResult() {
            @Override
            public void onItemSelected(int position)
            {

            }

            @Override
            public void onItemDeleted(int position) {
                pmApp.removeProduct(position);
                pdAdapter.notifyItemRemoved(position);
                /*bkAdapter.notifyDataSetChanged();*/
            }
        });
                recyclerView.setAdapter(pdAdapter);

        //Criar um novo produto
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getApplicationContext(), CreateProductActivity.class);
                startActivity(intent);

            }
        });

    }

    void setUpToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Product Manager");
    }

}
