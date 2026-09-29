class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] ch = new int[26];
        for (char c : s1.toCharArray()) {
            ch[c - 'a']++;
        }

        int n = s1.length();
        int window = 0;
        int req = n;
        for (int i = 0; i < s2.length(); i++) {
            window++;
            char c = s2.charAt(i);
            if (ch[c - 'a'] > 0) {
                req--;
            }
            ch[c - 'a']--;
            if (window == s1.length()) {
                if (req == 0) {
                    return true;
                }
                char c2 = s2.charAt(i - window + 1);
                if(ch[c2 - 'a'] >= 0){
                    req++;
                };
                ch[c2 - 'a']++;
                window--;
            }
        }
        return false;
    }
}
