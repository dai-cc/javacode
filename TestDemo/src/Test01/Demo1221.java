package Test01;

import sun.awt.SunHints;

import java.util.*;

/*
查找字符串当中重复元素的个数
aabbccaa=>  a 4,b 2,c 2    =》可以通过HashMap集合来存储结果
1 遍历字符串 chatAt(i)获取每一个元素
2 查看该元素是否在Map集合中存在   containsKey/get
3 返回value 存在 则value++
4 返回null 不存在 value=1
5 遍历
*/
public class Demo1221 {
    public static void main(String[] args) {
        Map<Character,Integer> map=new HashMap<>();
        Scanner scanner=new Scanner(System.in);
        String str=scanner.next();
        for(int i=0;i<str.length();i++){
            if(map.containsKey(str.charAt(i))){
                //如果包含该关键字
                Integer value=map.get(str.charAt(i));
                value++;
                map.put(str.charAt(i),value);
            } else{
                map.put(str.charAt(i),1);
            }
        }
        Set<Character> set=map.keySet();
        Iterator<Character> it=set.iterator();
        for(Character x:set){
            Character key=it.next();
            Integer value=map.get(key);
            System.out.println(key+"->"+value);
        }
    }
}
