package com.damon.literarium.data.repository;

import com.damon.literarium.data.Book;

import java.util.ArrayList;

public class LibrarySeedData {

    public static ArrayList<Book> getIssuedBooks()
    {
        ArrayList<Book> books = new ArrayList<>();
        books.add(
                new Book(
                        "Time Travelers",
                        4,
                        "Novel",
                        80
                )
        );
        books.add(
                new Book(
                        "1984",
                        3,
                        "Fiction",
                        20
                )
        );
        books.add(
                new Book(
                        "The Handmaid",
                        5,
                        "Fiction",
                        37
                )
        );
        books.add(
                new Book(
                        "The Testaments",
                        1,
                        "Fiction",
                        70
                )
        );
        return books;
    }

    public static ArrayList<Book> getLibraryBooks()
    {
        ArrayList<Book> books = new ArrayList<>();
        books.add(
                new Book(
                        "The Women in White",
                        2,
                        "Mystery",
                        10
                )
        );
        books.add(
                new Book(
                        "Rebecca",
                        3,
                        "Mystery",
                        34
                )
        );
        books.add(
                new Book(
                        "Gone Girl",
                        4,
                        "Thriller",
                        50
                )
        );
        books.add(
                new Book(
                        "Prison",
                        3,
                        "Fiction/Thriller",
                        6
                )
        );
        books.add(
                new Book(
                        "Nightcrawler",
                        2,
                        "Thriller",
                        2
                )
        );
        return books;
    }

    public static ArrayList<Book> getMainSubjectBooks()
    {
        ArrayList<Book> books = new ArrayList<>();
        books.add(
                new Book(
                        "Maths NCERT",
                        5,
                        "Textbook",
                        90
                )
        );
        books.add(
                new Book(
                        "Science NCERT",
                        4,
                        "Textbook",
                        89
                )
        );

        books.add(
                new Book(
                        "History NCERT",
                        1,
                        "Textbook",
                        98
                )
        );
        books.add(
                new Book(
                        "Pol.Science NCERT",
                        4,
                        "Textbook",
                        92
                )
        );
        books.add(
                new Book(
                        "English NCERT",
                        3,
                        "Textbook",
                        100
                )
        );
        books.add(
                new Book(
                        "Japanese Textbook",
                        3,
                        "Textbook",
                        100
                )
        );
        return books;
    }

    public static ArrayList<Book> getSecondarySubjectBooks()
    {
        ArrayList<Book> books = new ArrayList<>();
        books.add(
                new Book(
                        "Maths U-like",
                        2,
                        "Textbook",
                        50
                )
        );
        books.add(
                new Book(
                        "Science U-like",
                        5,
                        "Textbook",
                        34
                )
        );

        books.add(
                new Book(
                        "Histor U-like",
                        1,
                        "Textbook",
                        28
                )
        );
        books.add(
                new Book(
                        "Pol.Science U-like",
                        2,
                        "Textbook",
                        62
                )
        );
        books.add(
                new Book(
                        "English U-like",
                        3,
                        "Textbook",
                        15
                )
        );
        books.add(
                new Book(
                        "Japanese U-like",
                        5,
                        "Textbook",
                        100
                )
        );
        return books;
    }

}
