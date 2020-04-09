package IsLongPressedName;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。

示例 1：
输入：name = "alex", typed = "aaleex"
输出：true
解释：'alex' 中的 'a' 和 'e' 被长按。

示例 2：
输入：name = "saeed", typed = "ssaaedd"
输出：false
解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。

示例 3：
输入：name = "laiden", typed = "laiden"
输出：true
解释：长按名字中的字符并不是必要的。
 
提示：
name.length <= 1000
typed.length <= 1000
name 和 typed 的字符都是小写字母。
*/
public class Solution {
    //不可以，忽略了isLongPressedName("kikcxmvzi","kiikcxxmmvvzz")这种情况
    public static boolean isLongPressedName1(String name, String typed) {
        /*可以重复但不能没有*/
        Map<Character,Integer> map = new HashMap();
        //遍历name中的字符，containsKey判断是否含有 含有则value++，不含有则添加key
        for (int i = 0; i < typed.length(); i++) {
            if(map.containsKey(typed.charAt(i))){
                Integer value = map.get(typed.charAt(i));
                value++;
                map.put(typed.charAt(i),value);
            }
            else {
                map.put(typed.charAt(i), 1);
            }
        }
        //再将name中的每个字符遍历判断map中是否含有，若包含则value--，保证value>0
        //若不包含则返回false
        for (int i = 0; i < name.length(); i++) {
            if(map.containsKey(name.charAt(i))){
                Integer value = map.get(name.charAt(i));
                value--;
                map.put(name.charAt(i),value);
                if(value<0){
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }

    public static boolean isLongPressedName(String name, String typed){
        //先判断字符长度，若name长度>typed 则直接返回false
        if(name.length()>typed.length()){
            return false;
        }
        int i=0,j=0;
        while(i<name.length() && j<typed.length()){
            //双指针，比较name和typed字符，
            if(name.charAt(i)==typed.charAt(j)){
                // 如果当前字符相等则i++,j++
                i++;
                j++;
            }else if(j>0 && typed.charAt(j)==typed.charAt(j-1)){
                // 若type.charat(j)和type.charat(j-1)相等 则j++ 再判断是否相等
                j++;
            }else{
                //若不相等则返回false
                return false;
            }
        }
        //出来有两种情况
        //name里面的字符没比较完就退出，说明不同返回false
        if(i<name.length()){
            return false;
        }
        //全部比较完都一样
        return true;

    }

    public static void main(String[] args) {
        System.out.println(isLongPressedName("kikcxmvz","kiikcxxmmvvzz"));
    }
}
