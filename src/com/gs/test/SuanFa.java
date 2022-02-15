package com.gs.test;

import com.gs.first.com.gs.test.LearnKotlin2Kt;

import java.util.ArrayList;
import java.util.List;

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

    //1380. 矩阵中的幸运数
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int hanMin = 0;
        int hanMinIndex = 0;
        for(int i = 0; i < matrix.length; i++){
            hanMin = matrix[i][0];
            for (int n = 1; n < matrix[i].length; n++){
                if(hanMin > matrix[i][n]){
                    hanMin = matrix[i][n];
                    hanMinIndex = n;
                }
            }
            for(int j = 0; j < matrix.length; j++){
                if(hanMin < matrix[j][hanMinIndex] ){
                    break;
                }
                if(j == matrix.length - 1){
                    list.add(hanMin);
                }
            }
        }
        return list;
    }

    //2006. 差的绝对值为 K 的数对数目
    public int countKDifference(int[] nums, int k) {
        int a = 0;
        for(int i = 0; i < nums.length -1; i++){
            for(int n = i + 1; n < nums.length; n++){
                if(Math.abs(nums[i] - nums[n]) == k){
                    a++;
                }
            }
        }
        return a;
    }
}
