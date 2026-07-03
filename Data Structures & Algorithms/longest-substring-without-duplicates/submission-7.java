class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int[] store = new int[128];
        Arrays.fill(store, -1);
        int result = 0;
        int left = 0;
        for(int right = 0; right < len; right++) {
            char ch = s.charAt(right);
            // store[ch] means store['a'] = store[97]
            if(store[ch] >= left) {
                left = store[ch] + 1;
            }
            store[ch] = right;
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
