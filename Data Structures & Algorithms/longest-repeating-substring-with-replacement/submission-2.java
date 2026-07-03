class Solution {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        int right = 0, left = 0;
        int mxfreq = 0;
        int res = 0;
        int[] store = new int[26];
        Arrays.fill(store, 0);
        while(right < len) {
            store[s.charAt(right) - 'A']++;
            mxfreq = Math.max(mxfreq, store[s.charAt(right) - 'A']);
            if((right - left + 1) - mxfreq > k) {
                store[s.charAt(left) - 'A']--;
                mxfreq = 0;
                left++;
            }
            if((right - left + 1) - mxfreq <= k) {
                res = Math.max(res, (right - left + 1));
            }
            right++;
        }
        return res;
    }
}
