class Pair {
    String value;
    int timeStamp;
    Pair(String val, int ts) {
        value = val;
        timeStamp = ts;
    }
}

class TimeMap {
    Map<String, List<Pair>> map = new HashMap<>();
    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        Pair keyValue = new Pair(value, timestamp);
        map.get(key).add(keyValue);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        List<Pair> list = map.get(key);
        int low = 0, high = list.size() - 1;
        int ans = -1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if (list.get(mid).timeStamp == timestamp) {
            return list.get(mid).value;
            }
            else if (list.get(mid).timeStamp < timestamp) {
            ans = mid;          // possible answer
            low = mid + 1;      // search for a later valid timestamp
            }
            else {
            high = mid - 1;
            }
        }
        return ans == -1 ? "" : list.get(ans).value;
    }
}
