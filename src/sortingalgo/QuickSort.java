package sortingalgo;

import java.util.Arrays;

public class QuickSort {

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int partition(int[] arr, int start, int end){
        int pivot = arr[start];
        int i=start, j=end;

        while(i<j) {
            while (i<=end && arr[i] <= pivot)
                i++;
            while (j>=0 && arr[j] > pivot)
                j--;
            if(i<j) swap(arr, i, j);
        }

        swap(arr, start, j);

        return j;
    }

    private void quickSort(int[] arr, int start, int end){
        if(start < end) {
            int pivotPt = partition(arr, start, end);
            quickSort(arr, start, pivotPt - 1);
            quickSort(arr, pivotPt + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,4,5,1};
        new QuickSort().quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
