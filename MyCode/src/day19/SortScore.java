package day19;


import java.util.*;

/*
 * 成绩排序
 *
 * 输入：
 *       输入多行，现输入要排序的人的个数，排序方式（0代表从高到低，1代表从低到高）
 *       然后分别输入他们的名字和成绩，用空格隔开
 * 输出：
 *       按照指定方式输出名字和成绩，名字和成绩用空格隔开
 *       排序中如果遇到相同成绩的，则按先录入排列在前的规则处理*/
public class SortScore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();//排序人数
            int way = sc.nextInt();//排序方式
            List<Integer> list = new ArrayList<>();
            //因为是如果遇到相同成绩的要按照插入顺序排，所以不能用HashMap
            //又因为班上存在重名/重分数的情况，所以用（名字 分数）作为hm的key值
            //用分数作为他的i值
            LinkedHashMap<String, Integer> hm = new LinkedHashMap<>();
            for (int i = 0; i < n; i++) {
                String name = sc.next();
                int score = sc.nextInt();
                list.add(score);
                String key = name + " " + score;
                hm.put(key, score);
            }

            Collections.sort(list);
            if (way == 0) {
                Collections.reverse(list);
            }
            //设置一个标志位用来判断当前成绩是否输出过
            int pre = -1;
            //从小到大输出成绩
            for (int sco : list) {
                if (pre == sco) {
                    continue;
                }
                for (String key : hm.keySet()) {
                    if (hm.get(key).equals(sco)) {
                        System.out.println(key);
                    }
                }
                pre = sco;
            }

        }
    }
}
