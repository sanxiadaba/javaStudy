import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer v = nums[i];
            if (map.get(v) != null) {
                return (new int[]{map.get(i), i});
            }
            map.put(target - v, i);

        }
    }
}