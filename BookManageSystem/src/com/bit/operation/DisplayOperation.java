package com.bit.operation;

import com.bit.book.Book;
import com.bit.book.BookList;

public class DisplayOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        for (int i = 0; i <bookList.getSize() ; i++) {
            Book book=bookList.books[i];
            System.out.println(book.toString());
        }
    }
}
