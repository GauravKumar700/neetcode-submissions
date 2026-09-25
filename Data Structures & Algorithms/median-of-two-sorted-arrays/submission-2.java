class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        System.out.println(len);
        int need = (len + 1) / 2;
        int a = 0;
        boolean first = true;
        int count = 1;
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (count == need) {
                if (len % 2 != 0) {
                    return Math.min(nums1[i], nums2[j]);
                } else {
                    a += Math.min(nums1[i], nums2[j]);
                    if (first) {
                        count--;
                        first = false;
                    }
                }
            }
            if (nums1[i] <= nums2[j]) {
                i++;
            } else {
                j++;
            }
            count++;
        }

        while (count <= need && i < nums1.length) {
            if (count == need) {
                if (len % 2 != 0) {
                    return nums1[i];
                } else {
                    a += nums1[i];
                    if (first) {
                        count--;
                        first = false;
                    }
                }
            }
            count++;
            i++;
        }

        while (count <= need && j < nums2.length) {
            if (count == need) {
                if (len % 2 != 0) {
                    return nums2[j];
                } else {
                    a += nums2[j];
                    if (first) {
                        count--;
                        first = false;
                    }
                }
            }
            count++;
            j++;
        }
        return a / 2.0;
    }
}
