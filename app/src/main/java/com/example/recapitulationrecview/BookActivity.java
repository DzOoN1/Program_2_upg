package com.example.recapitulationrecview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {

    ImageView image;
    Button btnAddToReadBooks, btnAddToNotReadBooks;
    TextView txtBookName, txtAuthor, txtPages;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        image = (ImageView) findViewById(R.id.image);
        btnAddToReadBooks = (Button) findViewById(R.id.btnAddToReadBooks);
        btnAddToNotReadBooks = (Button) findViewById(R.id.btnAddToNotReadBooks);
        txtBookName = (TextView) findViewById(R.id.txtBookName);
        txtAuthor = (TextView) findViewById(R.id.txtAuthor);
        txtPages = (TextView) findViewById(R.id.txtPages);



        Intent intent = getIntent();
        if (intent != null) {
            int ID = intent.getIntExtra("ID", -1);
            if(ID != -1){
                Book incomingBook = DataBase.getInstance().getBookById(ID);
                if(incomingBook != null){
                    initValues(incomingBook);
                    handleAddToReadBooks(incomingBook);
                    handeleAddToNotReadBooks(incomingBook);
                }
            }
        }
    }

    private void handleAddToReadBooks(Book book) {

        ArrayList<Book> books = DataBase.getInstance().getReadBooks();
        for(Book b:books){
            if(b.getID() == book.getID()){
                btnAddToReadBooks.setEnabled(false);
            }
        }
        btnAddToReadBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                books.add(book);
                DataBase.getInstance().setReadBooks(books);
                Intent intent = new Intent(BookActivity.this,ReadBooksActivity.class);
                BookActivity.this.startActivity(intent);
            }
        });

    }

    private void handeleAddToNotReadBooks(Book book) {

        ArrayList<Book> books = DataBase.getInstance().getNotReadBooks();
        for(Book b:books){
            if(b.getID() == book.getID()){
                btnAddToNotReadBooks.setEnabled(false);
            }
        }
        btnAddToNotReadBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                books.add(book);
                DataBase.getInstance().setNotReadBooks(books);
                Intent intent = new Intent(BookActivity.this,NotReadBooksActivity.class);
                BookActivity.this.startActivity(intent);
            }
        });

    }

    private void initValues(Book book) {

        Glide.with(this).asBitmap().load(book.getImageURL()).into(image);
        txtBookName.setText(book.getBookname());
        txtAuthor.setText(book.getAuthor());
        txtPages.setText(String.valueOf(book.getPages()));
    }
}