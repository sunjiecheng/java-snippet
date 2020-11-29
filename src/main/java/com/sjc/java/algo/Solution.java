package com.sjc.java.algo;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author jiecheng
 * @create 2020-02-11 下午6:10
 * <p>
 * 1、n^2的复杂度，计算所有的面积
 * 2、
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        //s.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
        s.largestRectangleArea(new int[]{6, 7, 5, 2, 4, 5, 9, 3});
    }

    public int[] maxSlidingWindow(int[] a, int k) {
        if (a == null || k <= 0) {
            return new int[0];
        }
        int n = a.length;
        int[] r = new int[n - k + 1];
        int ri = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            // remove numbers out of range k
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }
            // q contains index... r contains content
            q.offer(i);
            if (i >= k - 1) {
                r[ri++] = a[q.peek()];
            }
        }
        return r;
    }

    public int largestRectangleArea(int[] height) {
        int len = height.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for (int i = 0; i <= len; i++) {
            int h = (i == len ? 0 : height[i]);
            if (s.isEmpty() || h >= height[s.peek()]) {
                s.push(i);
            } else {
                int tp = s.pop();
                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }

    public static void quickSort(int[] array, int begin, int end) {
        if (end <= begin) return;
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    static int partition(int[] a, int begin, int end) {
        // pivot: 标杆位置，counter: 小于pivot的元素的个数
//        int pivot = end, counter = begin;
//        for (int i = begin; i < end; i++) {
//            if (a[i] < a[pivot]) {
//                int temp = a[counter]; a[counter] = a[i]; a[i] = temp;
//                counter++;
//            }
//        }
//        int temp = a[pivot]; a[pivot] = a[counter]; a[counter] = temp;
//        return counter;
        int pivot = end, counter = begin;
        for (int i = begin; i < end; i++) {
            if (a[i] < a[pivot]) {
                int temp = a[counter];
                a[counter] = a[i];
                a[i] = temp;
                counter++;
            }
        }
        int temp = a[pivot];a[pivot]=a[counter];a[counter] = temp;
        return counter;
    }

    public static void quickSort2(int[] array,int begin,int end) {
        if (end <= begin) return;
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot - 1);
        quickSort(array, pivot + 1, end);
    }
}


