class Solution {
    public int characterReplacement(String s, int k) {
        int[] ch = new int[26];
        int maxFreq = 0,start = 0,max = 0;
        for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            ch[c - 'A']++;
            maxFreq = Math.max(maxFreq,ch[c - 'A']);
            System.out.println(maxFreq);
            while((i - start + 1) - maxFreq > k){
                ch[s.charAt(start) - 'A']--;
                start++;
            }
            max = Math.max(max,(i - start + 1));
        }
        return max;
    }
}
