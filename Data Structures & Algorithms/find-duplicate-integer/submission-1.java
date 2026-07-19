class Solution {
    public int findDuplicate(int[] nums) {

        //THIS SOLUTION IS THE MOST OPTIMAL ONE WHERE THE SPACE COMPLEXITY IS O(1) AND TIME COMPLEXITY O(N)
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);

        fast = nums[0];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}