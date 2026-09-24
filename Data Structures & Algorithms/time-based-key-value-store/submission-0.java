class TimeMap {
    HashMap<String, PriorityQueue<Pair<String, Integer>>> map;
    public TimeMap() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new PriorityQueue<Pair<String, Integer>>((a,b) -> a.getValue() - b.getValue()));
        }
        map.get(key).offer(new Pair<>(value,timestamp));
    }

    public String get(String key, int timestamp) {
        if(map.containsKey(key)){
            String s = "";
            for(Pair<String,Integer> p : map.get(key)){
                if(p.getValue() <= timestamp){
                    s = p.getKey();
                }
            }
            return s;
        }
        return "";
    }
}
