package day17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Train2{
    private static ArrayList<String> list = new ArrayList<>();
    //进站次数in,出站次数 out,进站序列arr,栈stack,出栈序列str
    private static void trainOut(int in, int out, int[] arr, Stack<Integer> stack, String str){
        //如果所有火车都已经出站，那么将结果保存入list
        if(out == arr.length){
            list.add(str);
        }
        //如果还有火车没有出站,即栈中还保存着数据
        if(!stack.empty()){
            int temp = stack.pop();
            trainOut(in,out+1,arr,stack,str+temp+" ");
            stack.push(temp);
        }
        //如果还有火车没有进站
        if(in < arr.length){
            stack.push(arr[in]);
            trainOut(in+1,out,arr,stack,str);
            stack.pop();
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int N = sc.nextInt();
            int[] arr = new int[N];
            list.clear();
            for(int i = 0; i < N; i++){
                arr[i] = sc.nextInt();
            }
            Stack<Integer> stack = new Stack<>();
            trainOut(0,0,arr,stack,"");
            Collections.sort(list);
            for(String str:list){
                System.out.println(str);
            }
        }
    }
}
