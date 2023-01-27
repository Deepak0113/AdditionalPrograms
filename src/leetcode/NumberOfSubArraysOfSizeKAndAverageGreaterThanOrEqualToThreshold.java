package leetcode;

public class NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold {
    private int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;

        for(int i=0; i<k; i++){
            sum += arr[i];
        }

        int count = sum/k >= threshold ? 1 : 0;

        for(int i=k; i<arr.length; i++){
            sum = sum - arr[i-k] + arr[i];

            if(sum/k >= threshold){
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{11,13,17,23,29,31,7,5,2,3};
        int k=3;
        int threshold=5;

        NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold numsub = new NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold();

        System.out.print(numsub.numOfSubarrays(arr, k, threshold));
    }
}
