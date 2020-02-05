package com.bit.operation;

import com.bit.book.BookList;

public class ReturnOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("请输入需要归还的书籍名称：");
        String name = scanner.next();
        //1、找这本书 是否存在
        for (int i = 0; i < bookList.getSize(); i++) {
            if(bookList.getBook(i).name.equals(name)){
                //说明找到了这本书，将书籍借阅状态改变
                if(bookList.getBook(i).isBorrowed){
                    //已被借阅
                    System.out.println("归还成功！");
                    bookList.getBook(i).isBorrowed=false;
                    return;
                }
            }
        }
        //没找到
        System.out.println("没有此书");
        return;
    }
}
