package com.bit.operation;

import com.bit.book.BookList;

public class FindOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("请输入需要查询的书籍名称：");
        String name = scanner.next();
        //1、找这本书 是否存在
        for (int i = 0; i < bookList.getSize(); i++) {
            if(bookList.getBook(i).name.equals(name)){
                //说明找到了这本书
                System.out.println("找到该书");
                System.out.println(bookList.getBook(i).toString());
                return;
            }
        }
        //没找到
        System.out.println("没有此书");
        return;
    }
}
