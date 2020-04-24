package day21;

import java.util.Scanner;

/*
* 有一只兔子，从出生后三个月每个月都生一只兔子
* 小兔子长到三个月后每月又生一只
* 假设兔子不死，问每个月兔子总数？
*
* 输入int类型的数字表示mouth
* 输出兔子总数int*/
public class GetTotalRabitCount {
    public static int getTotalCount(int monthCount){
        if(monthCount == 0){
            return 0;
        }
        //一月二月只有1只兔子
        if(monthCount < 3 && monthCount > 0){
            return 1;
        }
        return getTotalCount(monthCount-1)+getTotalCount(monthCount-2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int month = sc.nextInt();
            System.out.println(getTotalCount(month));
        }
    }
}
