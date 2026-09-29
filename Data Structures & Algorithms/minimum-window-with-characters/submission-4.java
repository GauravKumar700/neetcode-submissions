class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length())
            return "";
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int req = t.length();
        int window = s.length() + 1;
        int start = 0;
        int minStart = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (map.get(c) > 0) {
                    req--;
                }
                map.put(c, map.get(c) - 1);
            }
            while (req == 0) {
                char cs = s.charAt(start);
                if (map.containsKey(cs)) {
                    if (map.get(cs) == 0) {
                        req++;
                    }
                    map.put(cs, map.get(cs) + 1);
                }
                if (window > i - start + 1) {
                    window = i - start + 1;
                    minStart = start;
                }
                start++;
            }
        }

        if(window > s.length()) return "";

        return s.substring(minStart, minStart + window);
    }
}
