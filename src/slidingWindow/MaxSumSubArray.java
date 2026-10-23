package slidingWindow;
public class MaxSumSubArray {
    public static int subArray(int arr[], int k) {
        int wsum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            wsum += arr[i];
        }
        for (int i = k; i < arr.length; i++) {
            wsum = wsum - arr[i - k] + arr[i];
            maxSum = Math.max(wsum, maxSum);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int arr[] = {10, 20, -1, 20, 30, 40, 10, -32};
        int k = 3;
        System.out.println(subArray(arr, k));
    }
}
