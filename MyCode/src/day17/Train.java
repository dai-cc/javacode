package day17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

/*
* 火车进站问题：
*   给定一个正整数N代表火车数量，0<N<10,接下来输入火车入站的序列
*   一共N辆火车，每辆火车以数字1-9编号，要求以字典序排序输出火车出站的序列号
*
*   输入：第一行输入一个正整数N，第二行输入N个正整数
*   输出：输出以字典序从小到大排序的火车出战序列号，每个编号以空格隔开
*           ，每个输出序列换行
*
*
* 其实就是求N个数字的栈输出序列
* */
public class Train {
    //注意，因为题目要求要按照字典序输出，所以存储结果集的数据结构需要能够排序
    //ArrayList继承的Collections接口中提供了sort方法，所以用ArrayList存储
    private static  ArrayList<String> res = new ArrayList<>();//用来存储最终出栈的结果集
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int N = sc.nextInt();
            int[] arr = new int[N];//存放火车进站序列
            //注意由于在oj中是循环测试用例，所以每次都要先将res中的结果清空重新开始
            res.clear();
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            trainOut(arr,0,stack,"",0);
            Collections.sort(res);
            for (String str:res) {
                System.out.println(str);
            }
        }
    }
    //利用递归的方式求出栈序列
    public static void trainOut(int[] arr, int i, Stack<Integer> s,String str,int n){
        //如果出栈次数==arr.length，说明所有火车都已经出栈
        //保存当前结果
        if(n == arr.length){
            res.add(str);
        }
        //栈非空（还有火车没有出站）时出栈
        if(!s.empty()){
            int temp = s.pop();
            trainOut(arr,i,s,str+temp+" ",n+1);
            //回复现场
            s.push(temp);
        }
        //有火车都没有入栈则将火车入栈
        if(i<arr.length){
            s.push(arr[i]);
            trainOut(arr,i+1,s,str,n);
            //恢复现场
            s.pop();
        }
    }
}
