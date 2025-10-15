import java.util.*;
class Solution {

    static int[] nextSmaller(int[] arr, int n) {
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            // Pop elements greater or equal to arr[i]
            while (!st.isEmpty() && arr[st.peek()]>= arr[i]) {
                st.pop();
            }
            // If stack is empty -> no smaller element
            res[i] = st.isEmpty() ? n : st.peek();
            // Push current element
            st.push(i);
        }
        return res;
    }
    static int[] prevSmaller(int[] arr, int n) {
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            // Pop elements greater or equal to arr[i]
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            // If stack is empty -> no smaller element
            res[i] = st.isEmpty() ? -1 : st.peek();
            // Push current element
            st.push(i);
        }
        return res;
    }
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
       int [] nse=nextSmaller(heights, n);
       int pse[]=prevSmaller(heights, n);
       int maxres=0;
    //   int maxres = 0;
        for (int i = 0; i < n; i++) {
            int width = nse[i] - pse[i] - 1;
            int area = heights[i] * width;
            maxres = Math.max(maxres, area);
        }
       return maxres;
    }
}