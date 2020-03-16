package chen.mu.dai;

public class Demo1127 {
    public static void main(String[] args) {
        String str="1234";
        char[] s=str.toCharArray();
        int flag=0;
        for (int i = 0; i <s.length ; i++) {
            if(s[i]<48||s[i]>57){
                flag=1;
                break;
            }
        }
        if(flag==0){
            System.out.println("全为数字");
        }else{
            System.out.println("不全为数字");
        }
    }
}
