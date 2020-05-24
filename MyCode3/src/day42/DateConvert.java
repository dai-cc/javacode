package day42;

import java.util.Scanner;

/*
* 计算日期到天数转换
* 根据输入的日期，计算是这一年的第几天*/
public class DateConvert {
    public static int getOutDay(int year,int month,int day){
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        // 首先要判断这一年是闰年还是平年
        if(year % 100 == 0){
            if(year % 4 == 0){
                days[1] = 29;
            }
        }else{
            if(year % 4 ==0){
                days[1] = 29;
            }
        }

        int date = 0;
        for (int i = 0; i < month-1; i++) {
            date += days[i];
        }
        date += day;
        return date;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int year = sc.nextInt();
            int month = sc.nextInt();
            int day = sc.nextInt();
            System.out.println(getOutDay(year,month,day));
        }
    }
}
