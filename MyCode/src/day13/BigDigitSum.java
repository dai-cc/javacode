package day13;

import java.util.Scanner;

/*
* 实现两个超长正整数的加法
* 加数和被加数都是字符串类型*/
public class BigDigitSum {
    public static String AddLongInteger(String addend,String augend){
        int flag = 0;//进位标志位
        //先进行字符串判空
        if(addend == null){
            return augend;
        }
        if(augend == null){
            return addend;
        }
        //将字符串逆置后遍历
        //String中没有逆置函数，所以接用SB中的逆置函数将他们逆置
        StringBuffer a = new StringBuffer(addend).reverse();
        StringBuffer b = new StringBuffer(augend).reverse();
        StringBuffer c = new StringBuffer();
        //让a为长一点的字符串
        if(a.length()<=b.length()){
            StringBuffer temp = a;
            a = b;
            b = temp;
        }
        //获取到字符之后用该字符-‘0’得到他的原本数
        for (int i = 0; i < b.length(); i++) {
            int sum = a.charAt(i)+b.charAt(i)-'0'-'0'+flag;

            if(sum > 9){
                flag = 1;
                sum -= 10;
            }else{
                flag = 0;
            }
            c.append(sum);

        }
        //如果有一个数组先遍历完，查看有无进位，如果有，则将没加完的字符串加进位
        //无进位则直接将剩余的元素移到新数组中
        for (int i = b.length(); i < a.length(); i++) {
            int sum = a.charAt(i) - '0' + flag;
            if(sum > 9){
                flag = 1;
                sum -= 10;
            }else{
                flag = 0;
            }
            c.append(sum);
        }
        if(flag == 1){
            c.append(1);
        }
        return c.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String addend = sc.next();
            String augend = sc.next();
            String sum = AddLongInteger(addend,augend);
            System.out.println(sum);
        }
    }
}
