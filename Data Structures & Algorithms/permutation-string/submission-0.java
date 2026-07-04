class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if(len1 > len2) return false;
        int[] freq = new int[26];
        for(char ch : s1.toCharArray()) {
            freq[ch -  'a']++;
        }
        int req = len1;
        int left = 0;
        for(int right = 0; right < len2; right++) {
            if(freq[s2.charAt(right) - 'a'] > 0) req--;
            freq[s2.charAt(right) - 'a']--;
            if(req == 0) return true;
            if(right - left + 1 == len1) {
                if(freq[s2.charAt(left) - 'a'] >= 0) req++;
                freq[s2.charAt(left) - 'a']++;
                left++;
            }
        }
        return false;
    }
}
