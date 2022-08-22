package middle;


//给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
//
//        找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//
//        返回容器可以储存的最大水量。

//输入：[1,8,6,2,5,4,8,3,7]
//输出：49
public class MaxArea {
    public static void main(String[] args) {

    }

    //暴力破解 不可取0.0
    public static int maxArea(int[] height) {
        int max = 0;

        for (int i = 0; i < height.length; i++) {
            for (int j = height.length - 1; j >= i ; j--) {
                int minHeight = Math.min(height[i], height[j]);
                max = Math.max(max, (j - i) * minHeight);
            }
        }
        return max;
    }

    public static int maxAreaB(int[] height) {
        int max = 0;

        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            if (height[i] > height[j]) {
                max = Math.max(max, (j - i) * height[j]);
                j--;
            } else {
                max = Math.max(max, (j - i) * height[i]);
                i++;
            }
        }
        return max;
    }
}
