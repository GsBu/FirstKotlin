package com.gs.test;

import com.gs.first.com.gs.test.LearnKotlin2Kt;

public class SuanFa {
    public static void main(String[] args){
        System.out.println("Java 代码");
        for (String str : "12.345-6.A".split("\\.")){
            System.out.print(str+" ");
        }
    }

    public static char callKotlin(){
        return LearnKotlin2Kt.lastChar("sdfdfdasj");
    }

    public static boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        if(charArray.length % 2 == 0){
            for (int i = 0; i < charArray.length / 2; i++){
                switch (charArray[i]){
                    case '(':
                        if(charArray[charArray.length - i - 1] != ')' || charArray[i + 1] != ')'){
                            return false;
                        }
                        break;
                    case '[':
                        if(charArray[charArray.length - i - 1] != ']' || charArray[i + 1] != ']'){
                            return false;
                        }
                        break;
                    case '{':
                        if(charArray[charArray.length - i - 1] != '}' || charArray[i + 1] != '}'){
                            return false;
                        }
                        break;
                    default:
                        return false;
                }
            }
        }else {
            return false;
        }
        return true;
    }

    //540. 有序数组中的单一元素
    public int singleNonDuplicate(int[] nums) {
        for (int i = 1; i < nums.length; i++){
            if(nums[0] == nums[i]){
                i++;
                nums[0]=nums[i];
            }else {
                return nums[0];
            }
        }
        return nums[0];
    }
}
