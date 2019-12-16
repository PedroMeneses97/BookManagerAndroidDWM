package pt.ipca.androidbookdwm.models;

import androidx.annotation.IdRes;

public class Book {

    //Variáveis
    private String title,author;

    private int pages;

    @IdRes
    private int image;


    // Construtor
    public Book() {
    }

    public Book(String title, String author, int pages, int image) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.image = image;
    }

    //Metodos
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
