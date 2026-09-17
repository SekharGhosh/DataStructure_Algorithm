package org.Pattern.SlidingWindow;

public class MinimumWindowSubstring {
    public static void main(String[] args) {

        String input = "OUZODYXAZV" ;
        String t = "XYZ";
        //output - YXAZ
        System.out.println(minimumWindowSubString(input,t));
    }

    private static String minimumWindowSubString(String input, String t) {
        if(input==null || t == null || input.length()<t.length()){
            return "";
        }
        int[] isrequired = new int[128];

        for(char c: t.toCharArray()){
            isrequired[c]++;
        }

        int left = 0,right =0;
        int requiredCount = t.length();
        int minStart =0;
        int minLength =Integer.MAX_VALUE;

        while(right<input.length()){
            char rightChar = input.charAt(right);

            if(isrequired[rightChar] > 0){
                requiredCount--;
            }
            isrequired[rightChar]--;
            right++;

            while (requiredCount ==0){
                if(right-left < minLength){
                    minLength =right-left;
                    minStart =left;
                }
                char leftChar = input.charAt(left);
                isrequired[leftChar]++;

                if(isrequired[leftChar] > 0){
                    requiredCount++;
                }
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : input.substring(minStart,minStart+minLength);
    }
}
