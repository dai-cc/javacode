package day38;
/*
* 空格替换
* 将字符串中空格全部替换为%20
* 给定一个Sring iniString为原始的串，以及串长int len
* 返回替换后的String*/
public class ReplaceSpace {
    public static String replaceSpace(String iniString, int length) {
        // 如果字符串中被来就不含有空格，就无需处理
        if(!iniString.contains(" ")){
            return iniString;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            if(iniString.charAt(i) != ' '){
                sb.append(iniString.charAt(i));
            }else{
                sb.append("%20");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace("mr  john smith",14));
    }
}
