class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int len = strs.length;
        List<List<String>> anagrams = new ArrayList<>();
        if(len == 0) return anagrams;
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < len; i++) {
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(strs[i]);
        }

        // here i am iterating over the values that map contains...
        for(List<String> list : map.values()) {
        anagrams.add(list);
        }
        return anagrams;
    }
}
