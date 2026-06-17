class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0; i <= len - 3; i++) {
            int left = i + 1, right = len - 1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0) {
                    List<Integer> ans = new ArrayList<>();
                    ans.add(nums[i]);
                    ans.add(nums[left]);
                    ans.add(nums[right]);
                    set.add(ans);
                    left++;
                }
                else if(sum > 0) right--;
                else left++;
            }
        }
        return new ArrayList<>(set);
    }
}
