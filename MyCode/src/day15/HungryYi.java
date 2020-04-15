package day15;

import java.util.Scanner;

/*
* 小易的初始位置：x-0，初始x由用户输入，范围在1-1000000006
* 对于小易当前所处的位置x只能移动到 4*x+3 或 8*x+7
* 不过最多只能移动100 000次
* 贝壳总生长在能被1000000007整除的位置
* 计算小易需要移动多少次能吃到贝壳
* 如果移动完还未找到则输出-1*/
public class HungryYi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x0 = in.nextInt();
        in.close();
        int count = 0;
        //4x+3是2个2x+1   (2(2x+1)+1)
        //8x+7是3个2x+1   (2(2(2x+1)+1)+1)
        //count<=300000是因为假设全部走的是8x+7步，那么最大count就为300000
        while (x0 != 0 && count <= 300000) {
            x0 = ((x0 << 1) + 1) % 1000000007;
            count++;
        }
        int res = 0;
        //如果count%3为0结果就是count/3，count%3为1和2就是count/3+1
        if(count % 3==0){
            res = count/3;
        }else{
            res = count/3+1;
        }
        System.out.println(res > 100000 ? -1 : res);
    }
}
