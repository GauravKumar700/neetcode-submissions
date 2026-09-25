class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int prev = 0,curr = 0;
        int i = 0,j = 0;
        for(int count = 0;count <= len / 2;count++){
            prev = curr;
            if(j >= nums2.length || (i < nums1.length && nums1[i] <= nums2[j])){
                curr = nums1[i++];
            }else{
                curr = nums2[j++];
            }
        }
        return len % 2 == 0 ? (prev + curr) / 2.0 : curr;
    }
}
