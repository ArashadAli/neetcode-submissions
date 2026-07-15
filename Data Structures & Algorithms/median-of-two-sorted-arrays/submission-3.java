class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        int len1 = nums1.length;
        int len2 = nums2.length;
        int ptr1 = 0, ptr2 = 0;
        while(ptr1 < len1 && ptr2 < len2) {
            if(nums1[ptr1] == nums2[ptr2]) {
                list.add(nums1[ptr1]);
                list.add(nums2[ptr2]);
                ptr1++;
                ptr2++;
            }
            else if(nums1[ptr1] < nums2[ptr2]) {
                list.add(nums1[ptr1]);
                ptr1++;
            }
            else {
                list.add(nums2[ptr2]);
                ptr2++;
            }
        }
        while(ptr1 < len1) {
            list.add(nums1[ptr1]);
            ptr1++;
        }
        while(ptr2 < len2) {
            list.add(nums2[ptr2]);
            ptr2++;
        }

        int len = list.size();
        if(len % 2 == 0) {
            int mid = len / 2;
            int sum = list.get(mid - 1) + list.get(mid);
            return (double)sum / 2;
        }
        int m = len / 2;
        return (double)list.get(m);
    }
}
