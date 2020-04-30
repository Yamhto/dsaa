package com.yamhto.code;

/**
 * @author yamhto
 * @className: Method3.java
 * @package com.yamhto.code
 * @description:
 * @date 2020/4/29 18:17
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Method3 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dgfnhjuykiluiliol"));
    }

    public static int lengthOfLongestSubstring(String s) {

        System.out.println(s.length());

        Map<Character, Integer> index = new HashMap<>();

        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            int len = 0;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    ++len;
                    if(len>res)
                        res = len;
                }else {

                }
            }
        }

        return res;
    }
}
