package day25;

import java.util.Scanner;

/*
* 人民币转换，输入一个double数
* 输出人民币格式贰叁肆伍陆柒捌玖拾佰仟万亿元角分零整
* 1.07   人民币一元七分
* 0.85   人民币八角五分*/
public class MoneyChange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String n = sc.next();
            String[] num = n.split("//.");
            String inte = num[0];
            String dec = num[1];
            String[] a = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
            String[] b = {"拾","佰","仟","万","亿"};
            String[] c = {"角","分"};
            StringBuffer sb = new StringBuffer("人民币");
            for (int i = 0; i < inte.length(); i++) {
                int x = inte.charAt(i) - '0';
                sb.append(a[x]);
            }
        }

    }
}
/*链接：https://www.nowcoder.com/questionTerminal/00ffd656b9604d1998e966d555005a4b?toCommentId=142686
来源：牛客网

public class Main{
    public static void main(String []args){
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
        String str=in.nextLine();
        String []sts=str.split("\\.");
        String s=sts[0];
        StringBuilder sb=new StringBuilder("人民币");
        for (int j=0,i=s.length()-1;i>=0;i--,j++){
            if (s.charAt(j)!='0') {
                if (j>=3 && i%4==0 &&s.charAt(j-1)=='0'&&s.charAt(j-2)=='0'){
                    sb.append("零");
                }
                if (s.charAt(j)=='1' && i%4-1==0) {
                }else {
                    sb.append(Num(s.charAt(j)));
                }
            }
            if (i!=0) {
                if (i % 8 == 0 && i >= 8) {
                    sb.append("亿");
                }
                if (i % 4 == 0 && i % 8 != 0) {
                    sb.append("万");
                }
                if (i % 4-3 == 0 && s.charAt(j)!='0') {
                    sb.append("仟");
                    if (s.charAt(j+1)=='0'&&s.charAt(j+2)!='0'){
                        sb.append("零");
                    }
                }
                if (i % 4-2 == 0 && s.charAt(j)!='0') {
                    sb.append("佰");
                    if (s.charAt(j+1)=='0'&& s.charAt(j+2)!='0'){
                        sb.append("零");
                    }
                }
                if (i % 4-1 == 0&& s.charAt(j)!='0') {
                    sb.append("拾");
                }
            }
        }
        if (s.charAt(0)!='0'){
            sb.append("元");
        }
        if (sts[1].equals("00")){
            sb.append("整");
        }else{
            if (sts[1].charAt(0)=='0'){
                sb.append(Num(sts[1].charAt(1)));
                sb.append("分");
            }
            if (sts[1].charAt(1)=='0'){
                sb.append(Num(sts[1].charAt(0)));
                sb.append("角");
            }
            if (sts[1].charAt(0)!='0'&&sts[1].charAt(1)!='0'){
                sb.append(Num(sts[1].charAt(0)));
                sb.append("角");
                sb.append(Num(sts[1].charAt(1)));
                sb.append("分");
            }
        }
        System.out.println(sb);
        }
    }
    public static String Num(char c){
        if (c=='1'){
            return "壹";
        }if (c=='2'){
            return "贰";
        }if (c=='3'){
            return "叁";
        }if (c=='4'){
            return "肆";
        }if (c=='5'){
            return "伍";
        }if (c=='6'){
            return "陆";
        }if (c=='7'){
            return "柒";
        }if (c=='8'){
            return "捌";
        }if (c=='9'){
            return "玖";
        }
        return null;
    }
}
 */