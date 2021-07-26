package leetcode.lcci.p01;

/**
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 * 输入: s = "leetcode"
 * 输出: false
 * 输入: s = "abc"
 * 输出: true
 */
public class UniqueString {
    public static void main(String[] args) {
        String s = "abcdefa";
        s.chars().forEach(c->{
            System.out.println(1 << c - 'a');
        });

    }
}
