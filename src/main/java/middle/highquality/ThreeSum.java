package middle.highquality;

//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
//
//        注意：答案中不可以包含重复的三元组。

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
public class ThreeSum {
    public static void main(String[] args) {

    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        int length = nums.length;
        if (length < 3) {
            return results;
        }
        Arrays.sort(nums);
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                return results;
            }

            //中心值去重
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left = i + 1;
            int right = length - 1;
            while (right > left) {
                int temp = nums[left] + nums[i] + nums[right];
                if (temp == 0) {
                    List<Integer> result = new ArrayList<>();
                    result.add(nums[left]);
                    result.add(nums[i]);
                    result.add(nums[right]);
                    results.add(result);
                    //左右指针去重
                    while (right > left && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (right > left && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                    continue;
                }
                if (temp > 0) {
                    right--;
                    continue;
                }
                if (temp < 0) {
                    left++;
                }
            }
        }
        return results;

    }

}
