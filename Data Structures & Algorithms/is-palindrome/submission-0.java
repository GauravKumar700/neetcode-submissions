class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            Character l = s.charAt(left);
            Character r = s.charAt(right);

            if(!Character.isLetterOrDigit(l)){
                left++;
                continue;
            }

            if(!Character.isLetterOrDigit(r)){
                right--;
                continue;
            }

            if(Character.toLowerCase(l) == Character.toLowerCase(r)){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }
}
