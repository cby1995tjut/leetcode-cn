package middle;

//给定一个字符串 s 请你找出其中不含有重复字符的最长子串的长度
//
//输入: s = "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        int result = lengthOfLongestSubstring("abcabdsadfdafdsgasddddsabb");
        System.out.println(result);
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> positionMap = new HashMap<>();
        int max = 0;
        int length = s.length();
        int left = 0;
        for (int i = 0; i < length; i++) {
            if (positionMap.containsKey(s.charAt(i))) {
                //如果left在相同两个字符间，则left不变，反之left即为上一个相同字符索引的位置往右移一位
                left = Math.max(positionMap.get(s.charAt(i)) + 1, left);
            }
            //记录当前字符唯一索引
            positionMap.put(s.charAt(i), i);
            int res = i - left + 1;
            max = res > max ? res : max;
        }
        return max;
    }
}
