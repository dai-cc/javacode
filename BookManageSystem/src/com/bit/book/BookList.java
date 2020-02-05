package com.bit.book;

import java.util.Arrays;

public class BookList {
    public Book[] books = new Book[10];
    private int size;//有效数据个数

    public BookList(){
        books[0]=new Book("三国演义","罗贯中",13,"小说");
        books[1]=new Book("西游记","吴承恩",6,"小说");
        books[2]=new Book("水浒传","施耐庵",23,"小说");
        this.size=3;
    }

    public void setBooks(int pos,Book book) {
        this.books[pos] = book;
    }

    public Book getBook(int pos) {
        return books[pos];
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


}
