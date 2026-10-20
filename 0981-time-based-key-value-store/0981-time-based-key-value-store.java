class TimeMap {
    HashMap<String, HashMap<Integer, String>> map;
    HashMap<String, List<Integer>> timestamps;

    public TimeMap() {
        map = new HashMap<>();
        timestamps = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new HashMap<>());
            timestamps.put(key, new ArrayList<>());
        }

        map.get(key).put(timestamp, value);
        timestamps.get(key).add(timestamp);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        List<Integer> times = timestamps.get(key);

        int low = 0;
        int high = times.size() - 1;
        String ans = "";

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (times.get(mid) <= timestamp) {
                ans = map.get(key).get(times.get(mid));
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}