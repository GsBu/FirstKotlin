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
        //findMedianSortedArrays(a1, a2);

        reverse(-2147483648);
        System.out.println("递归"+digui(168, 626));
        //System.out.println(countDigitOne(824883294));

        String ss = "rfffxrogytyg";
        //System.out.println(longestPalindrome(ss));

        int[] a11 = new int[]{6,3,2,1,7,8,9,4,9};
        //nextPermutation(a11);

        System.out.println("爬楼梯："+paLouTi3(10));

       //System.out.println("全队列："+permute(a11));

        System.out.println("快速排序：");
        for (int aa: quick(a11, 0, a11.length - 1, a11[0])){
            System.out.print(" "+aa);
        }
        System.out.println("\n快速排序2：");
        for (int aa: quick2(a11, 0, a11.length - 1)){
            System.out.print(" "+aa);
        }

        System.out.println("\n辗转相除法求最大公约数："+zhanZhuan(15, 25));
        System.out.println("更相减损术求最大公约数："+gengXiang(15, 25));
        System.out.println("最优解求最大公约数："+zuiYou(13, 26));

        MinStack minStack = new MinStack();
        minStack.pushMinStack2(4);
        minStack.pushMinStack2(5);
        minStack.pushMinStack2(2);
        minStack.popMinStack2();
        minStack.pushMinStack2(3);
        try {
            System.out.println("\n栈中最小元素："+minStack.getMin2());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            StackToQueue stackToQueue = new StackToQueue();
            System.out.println("用栈实现队列：入队：" + stackToQueue.inQueue(1));
            System.out.println("用栈实现队列：入队：" + stackToQueue.inQueue(2));
            System.out.println("用栈实现队列：入队：" + stackToQueue.inQueue(3));
            System.out.println("用栈实现队列：出队：" + stackToQueue.outQueue());
            System.out.println("用栈实现队列：出队：" + stackToQueue.outQueue());
            System.out.println("用栈实现队列：出队：" + stackToQueue.outQueue());
        }catch (Exception e){
            e.printStackTrace();
        }

        int[] intArray = new int[]{1,2,4,6,3,5};
        findNearestNumber2(intArray);//先调用方法2，因为函数内它没有改变数组。
        findNearestNumber(intArray);
        deleteMinNumber("12340",3);
        deleteMinNumber2("12340",3);
        daShuJia("426709752318", "95481253129");
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

    //动态规划 爬楼梯优化
    private static HashMap<Integer, Integer> map = new HashMap();
    public static int paLouTi2(int n){
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }

        if(map.containsKey(n)){
            return map.get(n);
        }else {
            map.put(n, paLouTi2(n-1) + paLouTi2(n - 2));
        }
        return map.get(n);
    }
    //动态规划 爬楼梯再优化
    public static int paLouTi3(int n){
        int result = 0;
        int a1 = 1, a2 = 2;
        for(int i = 3;i<=n;i++){
            result = a1 + a2;
            a1 = a2;
            a2 = result;
        }
        return result;
    }

    //快速排序-自己实现-双边循环
    public static int[] quick(int[] nums, int left, int right, int point){
        int start = left;
        int end = right;
        if(left >= right){
            return nums;
        }

        while (left != right){
            if(nums[right] >= point){
                right--;
                continue;
            }
            if(nums[left] <= point){
                left++;
                continue;
            }
            int a = nums[left];
            nums[left] = nums[right];
            nums[right] = a;
        }

        int a = nums[start];
        nums[start] = nums[left];
        nums[left] = a;

        if(left - 1 >= 0) {
            quick(nums, start, left - 1, nums[start]);
        }
        if(left + 1 < nums.length) {
            quick(nums, left + 1, end, nums[left + 1]);
        }

        return nums;
    }

    //快速排序-自己实现-单边循环
    public static int[] quick2(int[] nums, int start, int end){
        int point = nums[start];

        if(start >= end){
            return nums;
        }

        int mark = start;
        for(int i = start + 1; i <= end; i++){
            if(nums[i] >= point){
                continue;
            }else {
                mark++;
                int a = nums[mark];
                nums[mark] = nums[i];
                nums[i] = a;
            }
        }

        nums[start] = nums[mark];
        nums[mark] = point;

        if(mark - 1 >= 0) {
            quick2(nums, start, mark - 1);
        }
        if(mark + 1 < nums.length) {
            quick2(nums, mark + 1, end);
        }

        return nums;
    }

    //46. 全排列
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        int length = nums.length;
        if(length == 0){
            return lists;
        }

        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[length];

        dfs(nums, length, 0, path, used, lists);
        return lists;
    }

    public static void dfs(int[] nums, int length, int depth,  List<Integer> path, boolean[] used, List<List<Integer>> lists){
        if(length == depth){
            lists.add(new ArrayList<>(path));
            return ;
        }

        for(int i = 0; i < length; i++){
            if(!used[i]){
                path.add(nums[i]);
                used[i] = true;

                dfs(nums, length, depth + 1, path, used, lists);

                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    //判断链表有环
    public static boolean isCycle(ListNode listNode) {
        ListNode p1 = listNode;
        ListNode p2 = listNode;

        while (p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
            if(p1 == p2){
                return true;
            }
        }
        return false;
    }

    //有环链表的环长
    public static int cycleCount(ListNode listNode) {
        ListNode p1 = listNode;
        ListNode p2 = listNode;
        int i = 0;
        boolean mark = false;

        while (p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
            if(p1 == p2){
                if(mark){
                    return i;
                }else {
                    mark = true;
                }
            }
            if(mark){
                i++;
            }
        }
        return 0;
    }

    //求最大公约数-辗转相除法(欧几里得算法)
    public static int zhanZhuan(int a, int b){
        int big = a > b ? a : b;
        int small = a < b ? a : b;
        if(big % small == 0){
            return small;
        }

        return zhanZhuan(small, big % small);
    }

    //求最大公约数-更相减损术
    public static int gengXiang(int a, int b){
        if(a == b){
            return a;
        }
        int big = a > b ? a : b;
        int small = a < b ? a : b;

        return gengXiang(small, big - small);
    }

    //求最大公约数-最优解
    public static int zuiYou(int a, int b){
        if (a == b) {
            return a;
        }
        if ((a & 1) == 0 && (b & 1) == 0) {
            return zuiYou(a >> 1, b >> 1) << 1;
        } else if ((a & 1) == 0 && (b & 1) != 0) {
            return zuiYou(a >> 1, b);
        } else if ((a & 1) != 0 && (b & 1) == 0) {
            return zuiYou(a, b >> 1);
        } else {
            int big = a > b ? a : b;
            int small = a < b ? a : b;
            return zuiYou(big - small, small);
        }
    }

    /**
     * 判断整数是否是2的整数次幂
     * @param a
     * @return
     */
    public static boolean zhengShuMi(int a){
        return (a & a-1) == 0;
    }

    /**
     * 最小栈（返回栈中最小值）
     */
    public static class MinStack{
        private Stack<Integer> stack = new Stack<>();
        private Stack<Integer> stackMin = new Stack<>();
        private int min = 0;

        public void pushMinStack(int a){
            if(stack.isEmpty()){
                min = a;
                stackMin.push(a);
            }

            if(a <= min){
                stackMin.push(a);
                min = a;
            }
            stack.push(a);
        }

        public void pushMinStack2(int a){
            stack.push(a);
            //如果辅助栈为空，或者新元素小于或等于辅助栈栈顶，新元素入辅助栈
            if(stackMin.empty() || a <= stackMin.peek()){
                stackMin.push(a);
            }
        }

        public int popMinStack(){
            if(stack.peek() <= stackMin.peek()){
                stackMin.pop();
            }
            return stack.pop();
        }

        public int popMinStack2(){
            if(stack.peek().equals(stackMin.peek())){
                stackMin.pop();
            }
            return stack.pop();
        }

        public int getMin(){
            int a;
            a = stack.peek();
            if(!stackMin.isEmpty() && a >= stackMin.peek()){
                a = stackMin.peek();
            }
            return a;
        }

        public int getMin2() throws Exception{
            if(stack.empty()){
                throw new Exception("栈为空");
            }
            return stackMin.peek();
        }
    }

    /**
     * 用栈实现队列
     */
    public static class StackToQueue{
        private Stack<Integer> inStack = new Stack<>();
        private Stack<Integer> outStack = new Stack<>();

        public int inQueue(int a){
            inStack.push(a);
            return a;
        }

        public int outQueue() throws Exception{
            if(inStack.isEmpty() && outStack.isEmpty()){
                throw new Exception("无数据");
            }

            if(outStack.isEmpty()){
                while (!inStack.isEmpty()){
                    outStack.push(inStack.pop());
                }
            }

            return outStack.pop();
        }
    }

    /**
     * 给出一个正整数，请找出这个正整数所有数字全排列的下一个数。
     * @param numbers
     * @return
     */
    public static int[] findNearestNumber(int[] numbers){
        System.out.print("\n给出一个正整数:");
        for (int i = 0; i<numbers.length;i++){
            System.out.print(numbers[i]);
        }

        int index = getIndex(numbers);

        if(index == 0){
            return null;
        }

        int min = numbers[index];
        int minIndex = index;
        for(int i = index + 1; i < numbers.length; i++){
            if(min > numbers[i] && numbers[i] > numbers[index - 1]){
                min = numbers[i];
                minIndex = i;
            }
        }

        numbers[minIndex] = numbers[index - 1];
        numbers[index - 1] = min;

        int temp = 0;
        for(int i = index; i < numbers.length; i++){
            for(int j = i; j < numbers.length - 1; j++){
                if(numbers[j] > numbers[j + 1]){
                    temp = numbers[i];
                    numbers[i] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }
        System.out.print("\n找出这个正整数所有数字全排列的下一个数:");
        for (int i = 0; i<numbers.length;i++){
            System.out.print(numbers[i]);
        }
        return numbers;
    }

    private static int getIndex(int[] numbers){
        for(int i = numbers.length - 1; i > 0; i--){
            if(numbers[i] > numbers[i - 1]){
                return i;
            }
        }
        return 0;
    }


    //-------------
    public static int[] findNearestNumber2(int[] numbers){
        System.out.print("\n给出一个正整数:");
        for (int i = 0; i<numbers.length;i++){
            System.out.print(numbers[i]);
        }

        int index = findTransferPoint(numbers);
        if(index == 0){
            return null;
        }
        int[] numbersCopy = Arrays.copyOf(numbers, numbers.length);
        exchangeHead(numbersCopy, index);
        reverse(numbersCopy, index);

        System.out.print("\n找出这个正整数所有数字全排列的下一个数:");
        for (int i = 0; i<numbersCopy.length;i++){
            System.out.print(numbersCopy[i]);
        }

        return numbersCopy;
    }
    private static int findTransferPoint(int[] numbers){
        for(int i=numbers.length-1; i>0; i--){
            if(numbers[i] > numbers[i-1]){
                return i;
            }
        }
        return 0;
    }

    private static int[] exchangeHead(int[] numbers, int index) {
        int head = numbers[index - 1];
        for (int i = numbers.length - 1; i > 0; i--) {

            if (head < numbers[i]) {
                numbers[index - 1] = numbers[i];
                numbers[i] = head;
                break;
            }
        }
        return numbers;
    }

    private static int[] reverse(int[] num, int index) {
        for (int i = index, j = num.length - 1; i < j; i++, j--) {
            int temp = num[i];
            num[i] = num[j];
            num[j] = temp;
        }
        return num;
    }

    public static void deleteMinNumber(String num, int k){
        System.out.print("\n原數："+num);
        for(int i = 0; i < k; i++){
            char[] chars = num.toCharArray();
            for (int j = 0; j < chars.length - 1; j++) {
                if(chars[j] > chars[j+1]){
                    if(j == 0){
                        num = num.substring(1, num.length());
                    }else {
                        num = num.substring(0, j) + num.substring(j + 1, num.length());
                    }
                    break;
                }
                if(j == num.length() - 2){
                    num = num.substring(0, num.length() - 1);
                }
            }
        }
        System.out.println("減去"+k+"個數后，最小的數是："+Integer.parseInt(num));
    }

    public static void deleteMinNumber2(String num, int k){
        System.out.print("\n原數：" + num);

        //新整数的最终长度 =  原整数长度-k
        int newLength = num.length() - k;
        //创建一个栈，用于接收所有的数字
        char[] stack = new char[num.length()];
        int top = 0;
        for (int i = 0; i < num.length(); ++i) {
            //遍历当前数字
            char c = num.charAt(i);
            //当栈顶数字大于遍历到的当前数字时，栈顶数字出栈（相当于删除数字）
            while (top > 0 && stack[top-1] > c && k > 0) {
                top -= 1;
                k -= 1;
            }
            //遍历到的当前数字入栈
            stack[top++] = c;
        }
        // 找到栈中第1个非零数字的位置，以此构建新的整数字符串
        int offset = 0;
        while (offset < newLength && stack[offset] == '0') {
            offset++;
        }
        String result =  offset == newLength? "0": new String(stack, offset, newLength - offset);
        System.out.println("減去" + k + "個數后，最小的數是：" + result);
    }

    public static void daShuJia(String s1, String s2){
        System.out.print("\n两个大整数"+s1+"和"+s2+"相加=");
        int[] ints1 = new int[s1.length()];
        int[] ints2 = new int[s2.length()];
        int max = s1.length() > s2.length() ? s1.length() : s2.length();
        int[] result = new int[max + 1];
        for (int i = 0; i < s1.length(); i++){
            ints1[i] = Integer.parseInt(s1.charAt(s1.length() - i - 1)+"");
        }
        for (int i = 0; i < s2.length(); i++){
            ints2[i] = Integer.parseInt(s2.charAt(s2.length() - i - 1)+"");
        }

        int i = 0, j = 0;
        boolean jin = false;
        while (i <= ints1.length - 1 || j <= ints2.length - 1){

            if(i > ints1.length - 1){
                result[i] = result[i] + ints2[j];
            }else if(j > ints2.length - 1){
                result[i] = result[i] + ints1[i];
            }else {
                if (result[i] + ints1[i] + ints2[j] >= 10) {
                    jin = true;
                    result[i] = (result[i] + ints1[i] + ints2[j]) % 10;
                } else {
                    result[i] = result[i] + (ints1[i] + ints2[j]);
                }
            }

            i++;
            j++;
            if(jin) {
                result[i] = 1;
                jin = false;
            }
        }
        for (int i1 = result.length - 1; i1 >= 0; i1--){
            if(i1 == result.length - 1 && result[i1] == 0){
                continue;
            }
            System.out.print(result[i1]);
        }
    }
}
