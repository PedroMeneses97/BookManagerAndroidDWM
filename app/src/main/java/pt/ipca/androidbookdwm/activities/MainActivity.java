package pt.ipca.androidbookdwm.activities;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import pt.ipca.androidbookdwm.BookManagerApp;
import pt.ipca.androidbookdwm.R;
import pt.ipca.androidbookdwm.adapters.BookAdapter;
import pt.ipca.androidbookdwm.interfaces.OnItemResult;
import pt.ipca.androidbookdwm.models.Book;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private BookManagerApp bmApp;
    private BookAdapter bkAdapter;
    //OASDOAOSDOASOO

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setUpToolbar();

        bmApp = ((BookManagerApp) getApplication());
        recyclerView = findViewById(R.id.books_recycler_view);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());



        recyclerView.setLayoutManager(layoutManager);
        bkAdapter = new BookAdapter(bmApp.getLstBooks(), new OnItemResult() {
            @Override
            public void onItemSelected(int position)
            {

            }

            @Override
            public void onItemDeleted(int position) {
                bmApp.removeBook(position);
                bkAdapter.notifyItemRemoved(position);
                /*bkAdapter.notifyDataSetChanged();*/
            }
        });
                recyclerView.setAdapter(bkAdapter);

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
        getSupportActionBar().setTitle("Book Manager");
    }

}
