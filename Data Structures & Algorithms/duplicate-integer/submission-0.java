class Solution {
    public boolean hasDuplicate(int[] nums) {
        int len = nums.length;
        Set<Integer> track = new HashSet<>();
        for(int i = 0; i < len; i++) {
            if(!track.add(nums[i])) return true;
        }
        return false;
    }
}