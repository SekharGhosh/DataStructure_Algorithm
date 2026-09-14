package org.dataStructure.array;

import java.util.Arrays;

public class FindFirstAndLastPosition {
    public static void main(String[] args) {
        //Find First and Last Position of an Element in a Sorted Array
        //Required time Complexity - O(log N)
        int arr[] = {2,4,6,7,7,8,10};
        int input = 7;
        //Using Brutefore - Time complexity O(n)
        int res[] = findFnlPostion(arr,input);
        for (int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
        //complexity O(log n)
        System.out.println("Using Binary Search:");
        int result[]  = usingBinarySearch(arr,input);
        for (int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }

    private static int[] usingBinarySearch(int[] arr, int input) {

        int findFirst = findFirstIndex(arr,input);
        int findLast = findLastIndex(arr,input);
        
        return new int[]{findFirst,findLast};
    }

    private static int findLastIndex(int[] arr, int input) {
        int start =0;
        int end = arr.length-1;
        int index =-1;
        while (start<=end){
            int mid = start + (end-start)/2;
            if(arr[mid] == input){
                index = mid;
                start = mid+1;
            } else if (arr[mid] < input) {
                start = mid+1;
            }else{
                end =mid-1;
            }
        }
        return index;
    }

    private static int findFirstIndex(int[] arr, int input) {
        
        int start = 0;
        int end = arr.length-1;
        int index=-1;
        while(start<=end){
           int mid = start +(end-start)/2;
           if(arr[mid]==input){
               index=mid;
               end=mid-1;
           } else if (arr[mid] < input) {
               start = mid+1;
           }else {
               end = mid-1;
           }
        }
        return index;
    }

    private static int[] findFnlPostion(int[] arr, int input) {
        int firstPosition = 0;
        int lastPosition = 0;

        for(int i =0;i<arr.length;i++){
            if(arr[i]==input){
                firstPosition = i;
                break;
            }
        }
        for(int j=firstPosition+1;j<arr.length;j++){

            if(arr[j]==input){
                lastPosition = j;
                break;
            }
        }

        return new int[]{firstPosition,lastPosition};
    }
}
