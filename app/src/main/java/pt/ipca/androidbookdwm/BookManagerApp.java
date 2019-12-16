package pt.ipca.androidbookdwm;

import android.app.Application;
import java.util.ArrayList;
import java.util.List;

import pt.ipca.androidbookdwm.models.Book;

public class BookManagerApp extends Application {


    List<Book> lstBooks = new ArrayList<>();
    @Override
    public void onCreate(){
        super.onCreate();
        Book book1 = new Book("Book 1","author 1",2,R.drawable.book_open_page_variant);
        Book book2 = new Book("Book 2","author 2",2,R.drawable.book_open);
        Book book3 = new Book("Book 3","author 3",2,R.drawable.notebook);

        addBook(book1);
        addBook(book2);
        addBook(book3);
    }

    @Override
    public void onTerminate(){
        super.onTerminate();
    }


    public void addBook(Book book)
    {
        lstBooks.add(book);

    }

    public void removeBook(int position)
    {
        lstBooks.remove(position);
    }


    //Get /set
    public List<Book> getLstBooks() {
        return lstBooks;
    }
}
