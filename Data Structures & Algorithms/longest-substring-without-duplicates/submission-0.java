class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        Set<Character> store = new HashSet<>();
        int result = 0;
        int left = 0;
        for(int right = 0; right < len; right++) {
            char ch = s.charAt(right);
            while(!store.isEmpty() && store.contains(ch)) {
                store.remove(s.charAt(left));
                left++;
            }
            store.add(ch);
            result = Math.max(result, store.size());
        }
        return result;
    }
}
