package org.dataStructure.array;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MedianOfTwoSortedArray {
    /*
    *
    * Given two sorted arrays nums1 and nums2 of size m and n respectively,
    * return the median of the two sorted arrays.
      The overall run time complexity should be O(log (m+n)).



Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
    *
    * */

    public static void main(String[] args) {

        int arr1[] = {1,2};
        int arr2[] = {3,4};
        double result = findMedianSortedArray(arr1,arr2);
        System.out.println("Median of two sorted array: "+result);
    }

    private static double findMedianSortedArray(int[] arr1, int[] arr2) {
        double result =0;
        int res[] = IntStream.concat(Arrays.stream(arr1),Arrays.stream(arr2))
                .sorted().toArray();
        int low=0; int high = res.length-1;
            if(res.length %2 ==0){

                int mid1 = res.length/2;
                int mid2 = res.length/2 - 1;
                result = (res[mid1] +res[mid2])/2.0;
                return result;
            }else{
                int mid = res.length/2;
                result = res[mid];
                return result;
            }
    }

}
