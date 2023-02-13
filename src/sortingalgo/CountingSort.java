package sortingalgo;

import java.util.Arrays;

public class CountingSort {
    private int[] countingSort(int[] arr){
        int k = 0;
        int[] sortedArr = new int[arr.length];

        for(int i: arr){
            if(k<i) k = i;
        }

        int[] countArr = new int[k+1];

        for(int i=0; i<arr.length; i++){
            countArr[arr[i]]++;
        }

        for(int i=1; i<=k; i++){
            countArr[i] = countArr[i]+countArr[i-1];
        }

        for(int i=arr.length-1; i>=0; i--){
            int ind = countArr[arr[i]]--;
            sortedArr[ind-1] = arr[i];
        }

        return sortedArr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,5,4,2,6,5,9,8,2,1,5,4,7,5};
        int[] res = new CountingSort().countingSort(arr);
        System.out.println(Arrays.toString(res));
    }
}
