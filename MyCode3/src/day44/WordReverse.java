package day44;

import java.util.Scanner;

/*
* 单词倒排
* 对字符串中所有单词进行倒排
* 注意非构成单词的字符均视为单词间隔符
* 如果原字符串中相邻单词间有多个单词间隔符，倒转后也只允许出现一个空格间隔符
* */
public class WordReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine();
            //^[a-zA-Z]是去匹配目标字符串中以中括号中的a—z或者A—Z开头的字符
            //[^a-zA-Z]是去匹配目标字符串中非a—z也非A—Z的字符
            String[] word = s.split("[^a-zA-Z]+");
            StringBuffer sb = new StringBuffer();
            for (int i = word.length-1; i >= 0; i--) {
                word[i] = word[i].trim();
                sb.append(word[i]);
                if(i != 0){
                    sb.append(" ");
                }
            }
            System.out.println(sb.toString());
        }
    }
}
