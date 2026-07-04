class Solution {
    public String minWindow(String s, String t) {
        String res = "";
        int len1 = s.length();
        int len2 = t.length();
        Map<Character, Integer> freq = new HashMap<>();
        for(char ch : t.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int sInd = -1;
        int count = 0;
        while(right < len1) {
            char ch = s.charAt(right);
            if(freq.getOrDefault(ch, 0) > 0) {
                count++;
            }
            freq.put(ch, freq.getOrDefault(ch, 0) - 1);
            right++;

            while(count == len2) {
                if(right - left < minLen) {
                    minLen = right - left;
                    sInd = left;
                }
                freq.put(s.charAt(left), freq.get(s.charAt(left)) + 1);
                if(freq.get(s.charAt(left)) > 0) count--;
                left++;
            }
        }
        return sInd == -1 ? "" : s.substring(sInd, sInd + minLen);
    }
}
