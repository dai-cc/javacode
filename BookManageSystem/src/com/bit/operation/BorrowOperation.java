package com.bit.operation;

import com.bit.book.BookList;

public class BorrowOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("请输入需要借阅书籍的名称");
        String name = scanner.next();
        //不会从bookList-》进行删除-》isBorrowed true
        //1、找这本书 是否存在
        for (int i = 0; i < bookList.getSize(); i++) {
            if(bookList.getBook(i).name.equals(name)){
                //说明找到了这本书，将书籍借阅状态改变
                if(bookList.getBook(i).isBorrowed){
                    //已被借阅
                    System.out.println("该书已被借阅");
                    return;
                }
                //2、他是否被借出   false  可以借
                bookList.getBook(i).isBorrowed=true;
                System.out.println("借阅成功！");
                return;
            }
        }
        //没找到
        System.out.println("没有此书");
        return;
    }
}
