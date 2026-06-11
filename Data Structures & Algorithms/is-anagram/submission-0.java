class Solution {
    public boolean isAnagram(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        if(len1 != len2) return false;
        Map<Character, Integer> track1 = new HashMap<>();
        Map<Character, Integer> track2 = new HashMap<>();
        for(int i = 0; i < len1; i++){
            track1.put(s.charAt(i), track1.getOrDefault(s.charAt(i), 0) + 1);
        }
        for(int i = 0; i < len2; i++){
            track2.put(t.charAt(i), track2.getOrDefault(t.charAt(i), 0) + 1);
        }

        for(int i = 0; i < len2; i++) {
            char ch = t.charAt(i);
            if(!track1.containsKey(ch)) return false;
            int val1 = track1.get(ch);
            int val2 = track2.get(ch);
            if(val1 != val2) return false;
        }
        return true;
    }
}
