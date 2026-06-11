class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++) {
            int diff = target - nums[i];
            if(map.containsKey(diff)) {
                int ind = map.get(diff);
                res[0] = ind;
                res[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
