class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        List<List<String>> list = new ArrayList<>();

        for(String str : strs){
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String sortedString = new String(c);

            if(!map.containsKey(sortedString)){
                map.put(sortedString,new ArrayList<>());
            }
            map.get(sortedString).add(str);
        }

        for(Map.Entry<String,List<String>> entry : map.entrySet()){
            list.add(entry.getValue());
        }
        return list;
    }
}
