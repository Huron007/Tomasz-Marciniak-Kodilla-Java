package com.kodilla.patterns.prototype.library;

import com.kodilla.patterns.prototype.Prototype;
import com.kodilla.patterns.prototype.TasksList;

import java.util.HashSet;
import java.util.Set;

public final class Library extends Prototype<Library> {

    private String name;
    private Set<Book> books = new HashSet<>();

    public Library(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Library shallowCopy() throws CloneNotSupportedException {
        return super.clone();
    }

    public Library deepCopy() throws CloneNotSupportedException {
        Library clonedLibrary = super.clone();
        clonedLibrary.books = new HashSet<>();
        for(Book bookList : books){
            clonedLibrary.getBooks().add(new Book(bookList.getTitle(), bookList.getAuthor(), bookList.getPublicationDate()));
        }
        return clonedLibrary;
    }

    @Override
    public String toString() {
        String s = "Library [" + name + "]\n";
        for (Book bookList : books) {
            s = s + bookList.toString() + "\n";
        }
        return s;
    }

}