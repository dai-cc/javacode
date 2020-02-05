package www.demo.com;

import java.util.Scanner;

/**
 * 猜数字游戏
 * a.先随机产生一个数字
 * b.让用户输入数字
 * c.判断输入数字和产生数字的大小关系
 * c1 如果大于，提示用户输入的数字大于要猜的数字
 * c2        小于                                   小于
 * c3        等于，提示成功，退出程序
 */
public class test2 {

//    public String name;
    public void guessNumberForever(){
        while (true) {
            System.out.println("游戏开始，请输入你要猜的数字：");
            this.guessNumber();
            System.out.println("是否继续游戏，yes or no");
            Scanner scanner = new Scanner(System.in);
            String next = scanner.next();
            if (next.equals("no")) {
                break;
            }
        }
    }

    public void guessNumber() {
        int random = (int) (Math.random() * 100);
        int count = 0;//记录猜了几次猜对
//         System.out.println(random);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int i = scanner.nextInt();
            if (random > i) {
                System.out.println("数字小了，请重新输入：");
                count++;
            } else if (random < i) {
                System.out.println("数字大了，请重新输入：");
                count++;
            } else {
                count++;
                System.out.println("恭喜你猜对啦");
                System.out.println("你一共猜了" + count + "次");
                break;
            }
        }
    }
}
