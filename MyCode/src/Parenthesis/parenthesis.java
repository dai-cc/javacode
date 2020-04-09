package Parenthesis;
/*
* 设计一个算法，判断其是否为合法括号串
* 给定一个符号串A和他的长度n，请返回一个bool值代表它是否为合法括号串*/

import java.util.Stack;

public class parenthesis {
    public static boolean chkParenthesis(String A, int n) {
        //遍历字符串，左括号则入栈，
        // 不是左括号的话则判断和当前栈顶元素是不是一对
        //      不是就直接返回false
        //      是的话就继续判断下一个
        if(n == 0){
            //如果是空字符串，直接返回
            return true;
        }
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            if(A.charAt(i) != '(' && A.charAt(i) != ')'
                    && A.charAt(i) != '{' && A.charAt(i) != '}'
                    && A.charAt(i) != '[' && A.charAt(i) != ']'){
                //如果元素不是括号字符的话,直接返回false
                return false;
            }
            if(A.charAt(i) == '(' || A.charAt(i) =='{'
                    || A.charAt(i) =='[' ){
                //如果是左括号的话就将其入栈
                s.push(A.charAt(i));
            }
            if(A.charAt(i) == ')' || A.charAt(i) =='}'
                    || A.charAt(i) ==']'){
                if(s.isEmpty()){
                    return false;
                }
                //如果遇到右括号的话，判断当前的括号是否和栈顶的括号匹配
                if(A.charAt(i) == ')' && s.peek() == '('){
                    //匹配则将当前栈顶元素弹出，然后进行下一步遍历
                    s.pop();
                }else if(A.charAt(i) == '}' && s.peek() == '{'){
                    s.pop();
                }else if(A.charAt(i) == ']' && s.peek() == '['){
                    s.pop();
                }else{
                    //不匹配则返回false
                    return false;
                }
            }
        }
        //退出之后要注意一种左括号多右括号少的情况
        //此时判断栈中是否还有元素，如果还有的话说明没有匹配完，返回false
        if(!s.isEmpty()){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String str = ")))";
        int n = str.length();
        System.out.println(chkParenthesis(str,n));
    }
}
