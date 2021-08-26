package meet;

/**
 * @author lan
 * @create 2021-08-26 19:52
 */
public class Test {
    public static void main(String[] args) {
        //String s = "babad";
        String s = "cbbd";
        //String s = "a";
        //String s = "ac";
        String str = getStr(s);
        System.out.println(str);
    }

    /**
     * 2、最长回文子串
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     * <p>
     * 示例 1：
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     * <p>
     * 示例 2：
     * 输入：s = "cbbd"
     * 输出："bb"
     * <p>
     * 示例 3：
     * 输入：s = "a"
     * 输出："a"
     * <p>
     * 示例 4：
     * 输入：s = "ac"
     * 输出："a"
     * <p>
     * 提示：
     * 1 <= s.length <= 1000
     * s 仅由数字和英文字母（大写和/或小写）组成
     *
     * @param str
     * @return
     */
    private static String getStr(String str) {
        if (str == null || str.trim().length() == 0) {
            return "";
        }
        char[] ch = str.toCharArray();
        String p = "";
        String res = "";
        int max = 0, start = 0, end = 0;
        int x = 0, y = 0;

        for (int i = 0; i < ch.length; i++) {
            x = i;
            y = i;
            while (x >= 0 && y < ch.length && ch[x] == ch[y]) {
                if (y - x > max) {
                    max = y - x;
                    start = x;
                    end = y;
                }
                x--;
                y++;

            }
        }

        for (int i = 0; i < ch.length; i++) {
            x = i;
            y = i + 1;
            while (x >= 0 && y < ch.length && ch[x] == ch[y]) {
                if (y - x > max) {
                    max = y - x;
                    start = x;
                    end = y;
                }
                x--;
                y++;

            }
            res = String.valueOf(ch).substring(start, end + 1);
            if (p.length() > res.length()) {
                res = p;
            }
        }
        return res;
    }


    /**
     * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
     * '.' 匹配任意单个字符
     * '*' 匹配零个或多个前面的那一个元素
     * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
     * <p>
     * 示例 1：
     * 输入：s = "aa" p = "a"
     * 输出：false
     * 解释："a" 无法匹配 "aa" 整个字符串。
     * <p>
     * 示例 2:
     * 输入：s = "aa" p = "a*"
     * 输出：true
     * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
     * <p>
     * 示例 3：
     * 输入：s = "ab" p = ".*"
     * 输出：true
     * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
     * <p>
     * <p>
     * 示例 4：
     * 输入：s = "aab" p = "c*a*b"
     * 输出：true
     * 解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
     * <p>
     * 示例 5：
     * 输入：s = "mississippi" p = "mis*is*p*."
     * 输出：false
     * <p>
     * 提示：
     * 0 <= s.length <= 20
     * 0 <= p.length <= 30
     * s 可能为空，且只包含从 a-z 的小写字母。
     * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
     * 保证每次出现字符 * 时，前面都匹配到有效的字符
     * <p>
     * <p>
     * 判断p的构成:
     * 有无 *
     * 1） 、 无 *
     * 有无 .
     * （1）、无  p为字符串  长度比较 不相等返回false , @1 相同 校验字符串 是否相同 ，同返回true ，不同，返回false
     * (2)、有 比较长度 不同返回false;同 ，进行 p点位置记录 ，去掉s中对饮位置的字符 ,操作 同@1
     * 2）、有 *  若以 *bbbb*aaa 开头 返回true
     * 有无 .
     * (1)、无 . 判断前缀是否相同
     * 不同 返回false
     * 相同 将多个 * 连续(a***bxx*s) 出现压缩成点个*(a*bxx*s),然后进行分割成 * 个数 +1 个字符串数组，
     * 从第二个开始比较 查看字符串 bxx  出现的位置，若没有匹配到 ，则返回 false , 若找到 ，则记录p 中 x的下标，
     * 进行 第三个 字符串数组 比较 ，不同返回false,。。。直到最后也一个 也相同，则返回true ,否则，返回false
     * (2)、有. 判断是否以(n*b.m*aa)
     * 以 . 开始 统计 .长度(无*) n ,
     */

    public static boolean getRes(String s, String p) {

        return false;
    }

}
