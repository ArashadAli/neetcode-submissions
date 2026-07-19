class Solution {
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int[] freq = new int[len + 1];
        for(int i = 0; i <= len; i++) freq[i] = 0;
        int rep = -1;
        for(int i = 0; i < len; i++) {
            if(freq[nums[i]] >= 1) {
                rep = nums[i];
                break;
            }
            freq[nums[i]] += 1;
        }

        return rep;
    }
}
