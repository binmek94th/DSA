import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayExercise {

    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            } else if (prices[i] - buy > profit) {
                profit = prices[i] - buy;
            }
        }
        return profit;
    }

    public int insert(int[] nums, int target) {
        int start = nums[0];
        int end = nums.length - 1;
        int mid = 0;

        while (start <= end) {
            mid = start + end + 1;
            if (nums[mid] == target)
                return mid;

            else if (nums[mid] < target)
                start = mid + 1;

            else
                end = mid - 1;
        }
        return mid + 1;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m, j = 0; i < m + n; i++, j++) {
            nums1[i] = nums2[j];
        }
        Arrays.sort(nums1);
    }

    public int singleNumber(int[] nums){
        Arrays.sort(nums);
        int unique = 0;

        for (int i = 1, size = nums.length; i < size; i++){
            if (nums[unique] == nums[i] && i != unique){
                unique = i + 1;
            }
        }
        return nums[unique];
    }

    public int majorityElement(int[] nums) {

        Arrays.sort(nums);
        int majority = 0;
        int count = 0;
        int size = nums.length;
        int half = size /2 + size % 2;

        for (int i = 0; i < size; i++){
            if (count == half) return majority;
            if (nums[i] == majority)
                count++;

            else {
                majority = nums[i];
                count++;
            }
        }
        return majority;
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) return result;
        int start = 0;
        int end = 0;

        for (int i = 1, size = nums.length; i < size; i++) {
            if (nums[end] + 1 == nums[i]) end = i;
            else {
                String entry;
                if (start != end)
                    entry = nums[start] + "->" + nums[end];
                else entry = "" + nums[start];
                result.add(entry);
                start = ++end;
            }
        }
        String entry;
        if (start != end)
            entry = nums[start] + "->" + nums[end];
        else entry = "" + nums[start];
        result.add(entry);
        return result;
    }
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int size = nums.length - 1;
        int last = nums.length;
        for (int i = 0, j = 1; i < size; i++, j++){
            if (nums[i] + 1 != nums[j]) return nums[i] + 1 ;
        }
        if (nums[size] == 0) return 1;
        if (size  == 0) return 0;
        if (nums[size] != last && size != 0) return nums[size] + 1;

        return 0;
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] arr = new int[nums1.length];
        int count = 0;
        boolean found = false;
        for (int i = 0, size1 = nums1.length; i < size1; i++){
            for (int j = 0, size2 = nums2.length; j < size2; j++){
                if (nums1[i] == nums2[j]) {
                    for (int k = 0; k < count; k++){
                        if (arr[k] == nums1[i]) found = true;
                        else found = false;
                    }
                    if (!found) arr[count++] = nums1[i];
                }
            }
        }
        int[] result = new int[count];
        for (int i = 0; i < count; i++) result[i] = arr[i];
        return result;
    }
}
