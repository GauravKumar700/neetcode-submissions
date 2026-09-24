class TimeMap {
    HashMap<String, List<Pair<String,Integer>>> map;
    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key,new ArrayList<>());
        }
        map.get(key).add(new Pair<>(value,timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        String s = "";
        List<Pair<String,Integer>> ls = map.get(key);
        int left = 0;
        int right = ls.size() - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(ls.get(mid).getValue() <= timestamp){
                s = ls.get(mid).getKey();
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return s;
    }
}
