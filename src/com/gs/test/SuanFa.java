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
        int[] a = new int[]{5,7,3,2,4,1,2,9,1};
        xuanze(a);
        maopao(a);
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

        int[] a1 = new int[]{1, 2};
        int[] a2 = new int[]{3, 4};
        findMedianSortedArrays(a1, a2);

        reverse(-2147483648);
        System.out.println("递归"+digui(168, 626));
        System.out.println(countDigitOne(824883294));

        String ss = "rfffxrogytyg";
        System.out.println(longestPalindrome(ss));

        int[] a11 = new int[]{3,2,1};
        nextPermutation(a11);

        System.out.println("爬楼梯："+paLouTi(10));
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

    //1704. 判断字符串的两半是否相似
    public boolean halvesAreAlike(String s) {
        int leftCount = 0, rightCount = 0;
        int leftIndex = 0, rightIndex = s.length() - 1;
        while (leftIndex < rightIndex){
            if(isYuan(s.charAt(leftIndex))){
                leftCount++;
            }
            if(isYuan(s.charAt(rightIndex))){
                rightCount++;
            }
            leftIndex ++;
            rightIndex --;
        }
        return leftCount == rightCount;
    }

    private static boolean isYuan(char c){
        if(c == 'A' || c == 'a' || c == 'e' || c == 'E' || c == 'i' ||
                c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U'){
            return true;
        }
        return false;
    }

    //2016. 增量元素之间的最大差值
    public int maximumDifference(int[] nums) {
        int result = -1;
        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                if(nums[j] > nums[i]){
                    if(result < nums[j] - nums[i]) {
                        result = nums[j] - nums[i];
                    }
                }
            }
        }
        return result;
    }

    //4. 寻找两个正序数组的中位数
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Double> result = new ArrayList();
        int a = 0, b = 0;
        while (a < nums1.length || b < nums2.length){
            if(a == nums1.length){
                result.add((double)nums2[b]);
                b++;
                continue;
            }
            if(b == nums2.length){
                result.add((double)nums1[a]);
                a++;
                continue;
            }

            if(nums1[a] < nums2[b]){
                result.add((double)nums1[a]);
                a++;
            }else {
                result.add((double)nums2[b]);
                b++;
            }
        }
        int i = (nums1.length + nums2.length) % 2;
        if(i == 0){
            return (result.get((nums1.length + nums2.length) / 2) + result.get((nums1.length + nums2.length) / 2 - 1)) / 2.0;
        }else {
            return result.get((nums1.length + nums2.length) / 2);
        }
    }

    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int count = nums1.length + nums2.length;
        int index = 0, left = 0, right = 0;
        int a1 = 0, a2 = 0;

        while (index <= count / 2){
            a2 = a1;
            if(left == nums1.length){
                a1 = nums2[right];
                right++;
                index++;
                continue;
            }
            if(right == nums2.length){
                a1 = nums1[left];
                left++;
                index++;
                continue;
            }
            if(nums1[left] < nums2[right]){
                a1 = nums1[left];
                left++;
            }else {
                a1 = nums2[right];
                right++;
            }
            index++;
        }

        if(count % 2 == 0){
            return (a1 + a2) / 2.0;
        }else {
            return a1;
        }
    }

    public static double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int totalLength = length1 + length2;
        if (totalLength % 2 == 1) {
            int midIndex = totalLength / 2;
            double median = getKthElement(nums1, nums2, midIndex + 1);
            return median;
        } else {
            int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
            double median = (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
            return median;
        }
    }

    public static int getKthElement(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;
        int kthElement = 0;

        while (true) {
            // 边界情况
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            // 正常情况
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }

    //7. 整数反转
    public static int reverse(int x) {
        Queue<Integer> queue = new ArrayDeque<>();

        while (true){
            queue.add(x % 10);
            if(Math.abs((long)x) < 10){
                break;
            }
            x = x / 10;
        }

        x = queue.poll();
        while (!queue.isEmpty()){
            if(x * 10l > Integer.MAX_VALUE || x * 10l < Integer.MIN_VALUE){
                return 0;
            }
            x = x * 10 + queue.poll();
        }

        return x;
    }

    //递归
    public static int digui(int hight, int wight){
        int a, b;
        if(hight > wight){
            a = hight;
            b = wight;
        }else {
            a = wight;
            b = hight;
        }

        int c = a % b;
        if(c == 0){
            return b;
        }else {
            return digui(c, b);
        }
    }

    //选择排序
    public static void xuanze(int[] a){
        int snap, index = -1;
        for (int i = 0; i < a.length; i++){
            index = i;
            for (int j = i + 1; j < a.length; j++){
                if(a[index] > a[j]){
                    index = j;
                }
            }
            if(i != index){
                snap = a[i];
                a[i] = a[index];
                a[index] = snap;
            }
        }
        System.out.println("\n+++选择排序");
        for (int i = 0; i < a.length; i++){
            System.out.print(" " + a[i]);
        }
        System.out.println("\n---选择排序");
    }

    //选择排序
    public static void maopao(int[] a){
        int snap;
        for (int i = a.length; i > 0; i--){
            for (int j = 0; j + 1 < i; j++){
                if(a[j] > a[j + 1]){
                    snap = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = snap;
                }
            }
        }

        System.out.println("\n+++冒泡排序");
        for (int i = 0; i < a.length; i++){
            System.out.print(" " + a[i]);
        }
        System.out.println("\n---冒泡排序");
    }

    //53. 最大子数组和
    public int maxSubArray(int[] nums) {
        int result = nums[0], preMax = 0;
        for (int i : nums){
            preMax = preMax + i;
            preMax = Math.max(preMax, i);
            result = Math.max(preMax, result);
        }
        return result;
    }

    //55. 跳跃游戏
    public boolean canJump(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length - 1; i++){
            if (i > max){
                return false;
            }
            max = Math.max(max, nums[i] + i);
        }
        return true;
    }

    //135. 分发糖果
    public int candy(int[] ratings) {

        int[] left = new int[ratings.length];
        for (int i = 0; i < left.length; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }

        int right = 0;
        int ret = 0;
        for (int i = ratings.length - 1; i >= 0; i--) {
            if (i < ratings.length - 1 && ratings[i] > ratings[i + 1]) {
                right++;
            } else {
                right = 1;
            }
            ret += Math.max(right, left[i]);
        }
        return ret;
    }

    //31. 下一个排列
    public static void nextPermutation(int[] nums) {
        if(nums.length < 2){
            return;
        }
        int snap = 0, index = 0;

        int i = nums.length - 2, j = nums.length - 1;
        while (i >= 0){
            if(nums[i] < nums[j]){
                break;
            }
            i--;
            j--;
        }

        if(i > 0) {
            int k = 0;
            for (k = nums.length - 1; k > i; k--) {
                if (nums[k] > nums[i]) {
                    snap = nums[k];
                    nums[k] = nums[i];
                    nums[i] = snap;
                    break;
                }
            }
        }

        for (int a = i + 1; a < nums.length; a++){
            index = a;
            for (int b = a + 1; b < nums.length; b++){
                if(nums[index] > nums[b]){
                    index = b;
                }
            }
            if(a != index){
                snap = nums[a];
                nums[a] = nums[index];
                nums[index] = snap;
            }
        }
    }
    //233. 数字 1 的个数
    public static int countDigitOne(int n) {
        int count = 0;
        int snap;
        for(int i = n; i > 0; i--){
            snap = i;
            while (snap != 0) {
                if (snap % 10 == 1) {
                    count++;
                }
                snap = snap / 10;
            }
        }
        return count;
    }

    //5. 最长回文子串
    public static String longestPalindrome(String s) {
        char[] cArray = s.toCharArray();
        String ret = "", snap = "";
        int length = cArray.length;
        for(int i = 0; i < length; i++){
            snap = cArray[i] + "";
            int left = 1, right = 1;
            for (int j = 1; i + j < length; j++){
                if(cArray[i] == cArray[i+j]){
                    snap = snap + cArray[i+j];
                    right = right + 1;
                }else {
                    break;
                }
            }
            for(int j = 1; i-j >= 0; j++){
                if(cArray[i] == cArray[i-j]){
                    snap = cArray[i-j] + snap;
                    left = left + 1;
                }else {
                    break;
                }
            }
            while (true){
                if(right + i >= length || i - left < 0){
                    break;
                }
                if(cArray[i + right] == cArray[i - left]){
                    snap = cArray[i + right] + snap + cArray[i - left];
                    left++;
                    right++;
                }else {
                    break;
                }
            }
            if(ret.length()<snap.length()){
                ret = snap;
            }
        }
        return ret;
    }

    //229. 求众数 II
    public List<Integer> majorityElement(int[] nums) {
        int x = 0,y = 0;
        int a1=0,a2=0;
        for (int num : nums){
            if(a1 > 0 && x == num){
                a1++;
            }else if(a2 > 0 && y == num){
                a2++;
            }else if(a1 == 0){
                x = num;
                a1++;
            }else if(a2 == 0){
                y = num;
                a2++;
            }else {
                a1--;
                a2--;
            }
        }

        int count1 = 0, count2 = 0;
        for(int num : nums){
            if(x == num){
                count1++;
            }else if(y == num){
                count2++;
            }
        }

        List<Integer> list = new ArrayList<>();
        if(count1>nums.length/3){
            list.add(x);
        }
        if(count2>nums.length/3){
            list.add(y);
        }
        return list;
    }

    //动态规划 爬楼梯
    public static int paLouTi(int n){
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        return paLouTi(n-1) + paLouTi(n - 2);
    }
}
