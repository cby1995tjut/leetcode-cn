package middle;

public class LongestPalindrome {
    public static void main(String[] args) {
        boolean cbbd = isPalindrome("cbbd");
        String s = "";

        String res = longestPalindrome("bb");
        System.out.println("....");
    }

    public static String longestPalindrome(String s) {
        String max = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j >= i; j--) {
                if (i == j) {
                    String substring = s.charAt(i) + "";
                    max = max.length() <= substring.length() ? substring : max;
                }
                String substring = s.substring(i, j + 1);
                if (isPalindrome(substring)) {
                    max = max.length() <= substring.length() ? substring : max;
                    break;
                }
            }
        }
        return max;
    }

    public static boolean isPalindrome(String s) {
        int length = s.length();
        for (int i = 0; i < length / 2; i++) {
            char left = s.charAt(i);
            char right = s.charAt(length - 1 - i);
            if (left != right) {
                return false;
            }
        }
        return true;
    }
}
