package com.example.recapitulationrecview;


import android.provider.ContactsContract;

import androidx.annotation.RequiresPermission;

import java.util.ArrayList;

public class DataBase {

    private static DataBase instance;

    public static DataBase getInstance() {
        if (instance != null) {

            return instance;

        } else {
            instance = new DataBase();
            return instance;
        }
    }


    private DataBase() {
        if (AllBooks == null) {
            AllBooks = new ArrayList<Book>();
            AllBooks.add(new Book(1, "Hammer has Fallen", "HammerFall", 120, "https://balkanrock.com/wp-content/uploads/2022/04/HFcover.jpg"));
            AllBooks.add(new Book(2, "Hammer Green", "HammerFall", 140, "https://i.pinimg.com/originals/43/f6/49/43f6494dd6320139e12135f5f5d0ffc8.jpg"));
            AllBooks.add(new Book(3, "Hammer 2", "HammerFall", 120, "https://images3.alphacoders.com/185/thumb-1920-185139.jpg"));
            AllBooks.add(new Book(4, "Hammer 3", "HammerFall", 120, "https://balkanrock.com/wp-content/uploads/2022/04/HFcover.jpg"));
            AllBooks.add(new Book(5, "Hammer 4", "HammerFall", 120, "https://www.nordicmetal.net/wp-content/uploads/2018/01/No-Sacrifice-No-Victory-300x300.jpg"));
        }

        if (ReadBooks == null) {
            ReadBooks = new ArrayList<Book>();
        }
        if (NotReadBooks == null) {
            NotReadBooks = new ArrayList<Book>();
        }
    }

    private static ArrayList <Book> AllBooks;
    private static ArrayList<Book> ReadBooks;
    private static ArrayList<Book> NotReadBooks;

    public static ArrayList<Book> getAllBooks() {
        return AllBooks;
    }

    public void setAllBooks(ArrayList<Book> allBooks) {
        AllBooks = allBooks;
    }

    public ArrayList<Book> getReadBooks() {
        return ReadBooks;
    }

    public void setReadBooks(ArrayList<Book> readBooks) {
        ReadBooks = readBooks;
    }

    public ArrayList<Book> getNotReadBooks() {
        return NotReadBooks;
    }

    public void setNotReadBooks(ArrayList<Book> notReadBooks) {
        NotReadBooks = notReadBooks;
    }

    public Book getBookById(int ID){
        for(Book b:AllBooks)
        {
            if(b.getID() == ID)
            {
                return b;
            }
        }
        return null;
    }
    public boolean removeFromReadList(Book b){
            for(Book b1:ReadBooks){
                if(b1.getID() == b.getID())
                {
                  return   ReadBooks.remove(b);
                }

            } return false;

        }
        public boolean removeFromNotReadList(Book b){
            for(Book b1:NotReadBooks){
                if(b1.getID() == b.getID())
                {
                  return  NotReadBooks.remove(b);
                }

            }
            return false;
        }

    }

