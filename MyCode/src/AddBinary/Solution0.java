package AddBinary;
/*给定两个二进制字符串，返回他们的和（用二进制表示）。
输入为非空字符串且只包含数字 1 和 0。

示例 1:
输入: a = "11", b = "1"
输出: "100"

示例 2:
输入: a = "1010", b = "1011"
输出: "10101"
*/
public class Solution0 {
    public static String addBinary(String a, String b) {
        /*比较字符串长度，长度短的前面用零补位
          设置一个进位标志int ans
          从字符串末尾开始 对应位置相加再加上进位数即为结果，若该位置没有数则加0，
          根据加得的结果进行字符串拼接*/
        int ans = 0;//进位标志位
        StringBuffer sb = new StringBuffer();
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = ans;
            sum += i >= 0? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            //此时sum只有四种情况 0，1，2 ，3，
            // 当sum为0，2时拼接0
            // 当sum为1，3时拼接1
            sb.append(sum % 2);
            //拼接完之后查看进位数是多少
            ans = sum / 2;
        }
        sb.append(ans == 1 ? ans : "");
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("11","1"));
    }
}
