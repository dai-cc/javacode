package MeiTuan;

import java.util.Scanner;

/*
* 小美是美团的前端工程师，为了防止系统被恶意攻击，小美必须要在用户输入用户名之前做一个合法性检查，一个合法的用户名必须满足以下几个要求：

1.    用户名的首字符必须是大写或者小写字母。

2.    用户名只能包含大小写字母，数字。

3.    用户名需要包含至少一个字母和一个数字。

如果用户名合法，请输出“Accept”，反之输出“Wrong”。
* */
public class userName {
    private static boolean check(String name){
        int charnum = 0;
        int numn = 0;
        for (int i = 0; i < name.length(); i++) {
            if(!(name.charAt(i) >= 'A' && name.charAt(i) <= 'Z'
                    || name.charAt(i) >= 'a' && name.charAt(i) <= 'z')
            &&!(name.charAt(i) >= '0' && name.charAt(i) <= '9')){
                return false;
            }
            if((name.charAt(i) >= 'A' && name.charAt(i) <= 'Z'
                    || name.charAt(i) >= 'a' && name.charAt(i) <= 'z')){
                charnum++;
            }
            if(name.charAt(i) >= '0' && name.charAt(i) <= '9'){
                numn++;
            }
        }
        if(numn == 0 || charnum == 0){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()) {
            int count = sc.nextInt();
            while (count-- > 0) {
                String userName = sc.next();
                if (userName.charAt(0) >= 'A' && userName.charAt(0) <= 'Z'
                        || userName.charAt(0) >= 'a' && userName.charAt(0) <= 'z') {
                    if (check(userName)) {
                        System.out.println("Accept");
                    } else {
                        System.out.println("Wrong");
                    }
                } else {
                    System.out.println("Wrong");
                }
            }
        }
        sc.close();
    }
}
