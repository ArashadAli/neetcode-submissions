class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int zeroCount = 0;
        int totalMulti = 1;
        for(int i = 0; i < len; i++) {
            if(zeroCount >= 2) break;
            if(nums[i] == 0) zeroCount++;
            if(nums[i] != 0) {
                totalMulti *= nums[i];
            }
        }
        if(zeroCount >= 2) {
            for(int i = 0; i < len; i++) {
                nums[i] = 0;
            }
            return nums;
        }
        else if(zeroCount == 1) {
            for(int i = 0; i < len; i++) {
                if(nums[i] == 0) nums[i] = totalMulti;
                else nums[i] = 0;
            }
            return nums;
        }
        for(int i = 0; i < len; i++) {
            nums[i] = totalMulti / nums[i];
        }
        return nums;
    }
}  
