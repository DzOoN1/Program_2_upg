package com.example.recapitulationrecview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView image;
    Button btnAllBooks, btnReadBooks, btnNotReadBooks, btnAbout;
    Button btn1,btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnAllBooks = (Button) findViewById(R.id.btnAllBooks);
        btnReadBooks = (Button) findViewById(R.id.btnReadBooks);
        btnNotReadBooks = (Button) findViewById(R.id.btnNotReadBooks);
        btnAbout = (Button) findViewById(R.id.btnAbout);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction FT = fragmentManager.beginTransaction().setReorderingAllowed(true);
                FT.replace(R.id.image, Fragment_1.class,null);
                FT.commit();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction FT = fragmentManager.beginTransaction().setReorderingAllowed(true);
                FT.replace(R.id.image,Fragment_2.class,null);
                FT.commit();
            }
        });
        DataBase.getInstance();


        btnAllBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AllBooksActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        btnReadBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ReadBooksActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
        btnNotReadBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,NotReadBooksActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("This program is developed by j3T decelopers team");
                builder.setPositiveButton("Visit google", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                        MainActivity.this.startActivity(intent);

                    }
                });
                builder.setNegativeButton("Dissmiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                builder.create().show();
            }
        });


    }
}