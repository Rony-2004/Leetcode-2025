import java.util.HashMap;
import java.util.Map;

class Solution {
    public long countGood(int[] nums, int k) {
        long ans = 0;
        int pairs = 0;
        Map<Integer, Integer> count = new HashMap<>();

        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            pairs += count.getOrDefault(nums[r], 0);
            count.put(nums[r], count.getOrDefault(nums[r], 0) + 1);

            while (pairs >= k) {
                count.put(nums[l], count.get(nums[l]) - 1);
                pairs -= count.get(nums[l]);
                l++;
            }

            ans += l;
        }

        return ans;
    }
}
