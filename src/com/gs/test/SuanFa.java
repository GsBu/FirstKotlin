package com.gs.test;

import com.gs.first.com.gs.test.LearnKotlin2Kt;

import java.util.*;

public class SuanFa {
    public static void main(String[] args) {
        System.out.println("Java 代码");
        for (String str : "12.345-6.A".split("\\.")) {
            System.out.print(str + " ");
        }
        lengthOfLongestSubstring("abcabcbb");

        myAtoi("  -0012a42");
        int[] a = new int[]{3,2,4,1};
        pancakeSort(a);

        pushDominoes("RR.L");
        reverseOnlyLetters("ab-cd");

        System.out.println("合并链表");

        ListNode l1 = new ListNode(1);
        ListNode l12 = new ListNode(5);
        ListNode l13 = new ListNode(6);
        l1.next = l12;
        l12.next = l13;

        ListNode l2 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(6);

        l2.next = l22;
        l22.next = l23;
        ListNode listNode = mergeTwoLists(l1, l2);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static char callKotlin() {
        return LearnKotlin2Kt.lastChar("sdfdfdasj");
    }

    public static boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        if (charArray.length % 2 == 0) {
            for (int i = 0; i < charArray.length / 2; i++) {
                switch (charArray[i]) {
                    case '(':
                        if (charArray[charArray.length - i - 1] != ')' || charArray[i + 1] != ')') {
                            return false;
                        }
                        break;
                    case '[':
                        if (charArray[charArray.length - i - 1] != ']' || charArray[i + 1] != ']') {
                            return false;
                        }
                        break;
                    case '{':
                        if (charArray[charArray.length - i - 1] != '}' || charArray[i + 1] != '}') {
                            return false;
                        }
                        break;
                    default:
                        return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    //540. 有序数组中的单一元素
    public int singleNonDuplicate(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[0] == nums[i]) {
                i++;
                nums[0] = nums[i];
            } else {
                return nums[0];
            }
        }
        return nums[0];
    }

    //1380. 矩阵中的幸运数
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int hanMin = 0;
        int hanMinIndex = 0;
        for (int i = 0; i < matrix.length; i++) {
            hanMin = matrix[i][0];
            for (int n = 1; n < matrix[i].length; n++) {
                if (hanMin > matrix[i][n]) {
                    hanMin = matrix[i][n];
                    hanMinIndex = n;
                }
            }
            for (int j = 0; j < matrix.length; j++) {
                if (hanMin < matrix[j][hanMinIndex]) {
                    break;
                }
                if (j == matrix.length - 1) {
                    list.add(hanMin);
                }
            }
        }
        return list;
    }

    //2006. 差的绝对值为 K 的数对数目
    public int countKDifference(int[] nums, int k) {
        int a = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int n = i + 1; n < nums.length; n++) {
                if (Math.abs(nums[i] - nums[n]) == k) {
                    a++;
                }
            }
        }
        return a;
    }

    //3. 无重复字符的最长子串
    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int result = 1;
        Set set = new HashSet<Character>();

        for (int i = 0; i < s.length() - 1; i++) {
            set.clear();
            set.add(s.charAt(i));
            for (int n = i + 1; n < s.length(); n++) {
                if (!set.contains(s.charAt(n))) {
                    set.add(s.charAt(n));
                } else {
                    break;
                }
            }
            if (set.size() > result) {
                result = set.size();
            }
        }
        return result;
    }

    //11. 盛最多水的容器
    public int maxArea(int[] height) {
        if (height.length < 2) {
            return 0;
        }

        int result = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            if (height[l] < height[r]) {
                if (result < height[l] * (r - l)) {
                    result = height[l] * (r - l);
                }
                ++l;
            } else {
                if (result < height[r] * (r - l)) {
                    result = height[r] * (r - l);
                }
                --r;
            }
        }
        return result;
    }

    //42. 接雨水
    public int trap(int[] height) {
        int result = 0;
        int l = 0, r = height.length - 1;
        int lMax = height[l], rMax = height[r];
        while (l < r) {
            if (height[l] < height[r]) {
                if (height[l + 1] < lMax) {
                    result += lMax - height[l + 1];
                } else {
                    lMax = height[l + 1];
                }
                ++l;
            } else {
                if (height[r - 1] < rMax) {
                    result += rMax - height[r - 1];
                } else {
                    rMax = height[r - 1];
                }
                --r;
            }
        }
        return result;
    }

    //1791. 找出星型图的中心节点
    public int findCenter(int[][] edges) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[i].length; j++) {
                if (map.containsKey(edges[i][j])) {
                    map.put(edges[i][j], map.get(edges[i][j]) + 1);
                } else {
                    map.put(edges[i][j], 1);
                }
            }
        }
        for (int key : map.keySet()) {
            if (map.get(key) == edges.length) {
                return key;
            }
        }
        return 0;
    }

    //8. 字符串转换整数 (atoi)
    public static int myAtoi(String s) {
        boolean isFu = false;
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }

        int i = 0;
        if (s.charAt(0) == '-') {
            isFu = true;
            i = 1;
        }else if(s.charAt(0) == '+'){
            i = 1;
        }
        while (i < s.length()) {
            if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                ++i;
            } else {
                s = s.substring(0, i);
                break;
            }
        }
        if (s.isEmpty() || s.equals("-") || s.equals("+")) {
            return 0;
        }
        int a = 0;
        try {
            a = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            if (isFu) {
                a = Integer.MIN_VALUE;
            } else {
                a = Integer.MAX_VALUE;
            }
        }
        return a;
    }

    //969. 煎饼排序
    public static List<Integer> pancakeSort(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int max = 0, maxIndex = 0;

        for(int a = 0; a < arr.length; a++){
            max = 0;
            maxIndex = 0;
            for (int i = 0; i < arr.length - a; i++){
                if(max < arr[i]){
                    max = arr[i];
                    maxIndex = i;
                }
            }
            if(maxIndex == arr.length - a - 2){
                continue;
            }

            list.add(maxIndex + 1);
            int b;
            for (int n = 0; n < maxIndex / 2 + 1; n++){
                b = arr[n];
                arr[n] = arr[maxIndex - n];
                arr[maxIndex - n] = b;
            }
            list.add(arr.length - a);
            for (int n = 0; n < (arr.length - a) / 2; n++){
                b = arr[n];
                arr[n] = arr[arr.length - a - n - 1];
                arr[arr.length - a - n - 1] = b;
            }
        }

        return list;
    }

    //717. 1比特与2比特字符
    public boolean isOneBitCharacter(int[] bits) {
        for(int i = 0; i < bits.length; i++){
            if(bits[i] == 1){
                i++;
            }else {
                if(i == bits.length - 1){
                    return true;
                }
            }
        }
        return false;
    }

    //838. 推多米诺
    public static String pushDominoes(String dominoes) {
        char[] onlyLeft = dominoes.toCharArray(), onlyRight = dominoes.toCharArray();
        int l = 0, r = dominoes.length() - 1;
        boolean hasLeft = false, hasRight = false;
        while (l < dominoes.length()){
            if(dominoes.charAt(l) == 'R'){
                hasRight = true;
            }else if(dominoes.charAt(l) == 'L'){
                hasRight = false;
            }
            if(dominoes.charAt(l) == '.' && hasRight){
                onlyRight[l] = 'R';
            }
            l++;

            if(dominoes.charAt(r) == 'L'){
                hasLeft = true;
            }else if(dominoes.charAt(r) == 'R'){
                hasLeft = false;
            }
            if(dominoes.charAt(r) == '.' && hasLeft){
                onlyLeft[r] = 'L';
            }
            r--;
        }
        int start = -1;
        for (int i = 0; i < dominoes.length(); i++){

            if(onlyRight[i] == '.'){
                onlyRight[i] = onlyLeft[i];
            }else if(onlyRight[i] == 'R'){
                if(onlyLeft[i] == 'L'){
                    if(start == -1) {
                        start = i;
                    }
                    continue;
                }
            }else if(onlyRight[i] == 'L'){
                if(start != -1) {
                    int end = i - 1;
                    if(end == start){
                        onlyRight[start] = '.';
                    }
                    while (start < end){
                        onlyRight[start] = 'R';
                        onlyRight[end] = 'L';
                        start++;
                        end--;
                        if(end == start){
                            onlyRight[start] = '.';
                        }
                    }
                    start = -1;
                }
            }
        }
        return new String(onlyRight);
    }

    //27. 移除元素
    public int removeElement(int[] nums, int val) {
        int l = 0, r = nums.length - 1;
        while (l <= r){
            if(val == nums[l]){
                if(val == nums[r]){
                    r--;
                }else {
                    nums[l] = nums[r];
                    r--;
                }
            }else {
                l++;
            }
        }

        return l;
    }

    //917. 仅仅反转字母
    public static String reverseOnlyLetters(String s) {
        int left = 0, right = s.length() - 1;
        char[] array = s.toCharArray();
        char snap = '0';
        while (left < right){
            if(isZiMu(array[left])){
                if(isZiMu(array[right])){
                    snap = array[right];
                    array[right] = array[left];
                    array[left] = snap;
                    left++;
                }
                right--;
            }else {
                left++;
            }
        }
        return new String(array);
    }

    private static boolean isZiMu(char a){
        if(('a' <= a && a <= 'z') || ('A' <= a && a <= 'Z')){
            return true;
        }
        return false;
    }

    //21. 合并两个有序链表
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }

        if(list1.val > list2.val){
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }else {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
