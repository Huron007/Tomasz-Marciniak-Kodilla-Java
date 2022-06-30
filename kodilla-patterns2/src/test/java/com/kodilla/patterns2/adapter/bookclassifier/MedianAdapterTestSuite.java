package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class MedianAdapterTestSuite {

    @Test
    public void publicationYearMedianTest(){
        //Given
        Book book1 = new Book("Author1", "Title1", 1990, "A");
        Book book2 = new Book("Author2", "Title2", 1992, "B");
        Book book3 = new Book("Author3", "Title3", 1994, "C");
        Book book4 = new Book("Author4", "Title4", 1995, "D");
        Book book5 = new Book("Author5", "Title5", 1998, "E");
        Book book6 = new Book("Author6", "Title6", 2000, "F");
        Set<Book> books = new HashSet<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        books.add(book6);
        MedianAdapter medianAdapter = new MedianAdapter();
        //When
        int median = medianAdapter.publicationYearMedian(books);
        //Then
        assertEquals(1995, median);
    }
}
