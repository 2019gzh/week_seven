package com.gzh;
import java.util.Arrays;
import java.util.Stack;
import java.util.Map;
import java.util.HashMap;
public class ShuJuJieGou {
    public static void main(String[] args) {
        //数据结构题
        //第一题
        int[] num1 = {4,1,2};
        int[] num2 = {1,3,4,2};
        System.out.println(Arrays.toString(GreaterElement(num1,num2)));
        //第二题
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,5,3,2,1};
        System.out.println(StackSequences(pushed,popped));
        //第三题
        int[] nums = {1,2,3,2};
        System.out.println(SumUnique(nums));
    }
    public static int[] GreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int[] arr = new int[nums1.length];
        for(int i = nums2.length - 1;i >= 0;i--){
            stack1.push(nums2[i]);
        }
        int flag = 0;
        for(int j = 0;j < nums1.length;j++){
            int temp = nums1[j];
            while(!stack1.empty() && temp != stack1.peek()){
                stack2.push(stack1.peek());
                stack1.pop();
            }
            while(!stack1.empty()){
                if(temp < stack1.peek()){
                    arr[flag++] = stack1.peek();
                    break;
                }
                stack2.push(stack1.peek());
                stack1.pop();
            }
            if(stack1.empty()){
                arr[flag++] = -1;
            }
            while(!stack2.empty()){
                stack1.push(stack2.peek());
                stack2.pop();
            }
        }
        return arr;
    }
    public static boolean StackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 0 && popped.length == 0) return true;
        if (pushed.length == 0 && popped.length != 0 || pushed.length != 0 && popped.length == 0 || pushed.length != popped.length) return false;
        Stack<Integer> stack = new Stack<>();
        int flag = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && flag < pushed.length && stack.peek() == popped[flag]) {
                stack.pop();
                flag++;
            }
        }
        return flag == pushed.length;
    }
    public static int SumUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            if (entry.getValue() == 1) sum += entry.getKey();
        return sum;
    }
}
