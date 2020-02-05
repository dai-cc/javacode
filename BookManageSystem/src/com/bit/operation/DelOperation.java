package com.bit.operation;

import com.bit.book.BookList;

public class DelOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("请输入需要删除书籍的名称");
        String name = scanner.next();
        //1、找这本书 是否存在
        for (int i = 0; i < bookList.getSize(); i++) {
            if(bookList.getBook(i).name.equals(name)){
                //找到了这本书 进行删除
                for(int j=i;j<bookList.getSize()-1;j++) {
                    bookList.books[i] = bookList.books[i + 1];
                }
                bookList.setSize(bookList.getSize()-1);
                System.out.println("删除成功");
                return;
            }
        }
        //没找到
        System.out.println("憨批没有此书");
        return;
    }
}
