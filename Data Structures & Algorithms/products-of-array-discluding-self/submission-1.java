class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] leftSuffix = new int[len];

        leftSuffix[0] = 1;
        for(int i = 1; i < len; i++){
            leftSuffix[i] = leftSuffix[i - 1] * nums[i - 1];
        }
        int right =  1;
        for(int i = len - 1; i >= 0; i--){
            leftSuffix[i] = leftSuffix[i] * right;
            right *= nums[i];
        }
        return leftSuffix;
    }
}