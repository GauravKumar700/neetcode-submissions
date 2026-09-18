class Solution {

    public String encode(List<String> strs) {
        StringBuffer sb = new StringBuffer("");
        for(int i = 0;i < strs.size();i++){
            String s = strs.get(i);
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int start = 0;
        while(start < str.length()){
            int len = 0;
            int index = str.indexOf('#',start);
            while(start < index){
                len = (len * 10) + (str.charAt(start) - '0');
                start++;
            }
            start = index+1;
            int end = index + len;
            String s = "";
            while(start <= end){
                s += str.charAt(start);
                start++;
            }
            list.add(s);
        }
        return list;
    }
}
