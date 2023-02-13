package sortingalgo;

import java.util.Arrays;

public class MergeSort {

    private void mergeSort(int[] arr, int start, int mid, int end){
        int n1 = mid - start + 1;
        int n2 = end - mid;

        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];

        for(int i=0; i<n1; i++)
            arr1[i] = arr[start+i];

        for(int i=0; i<n2; i++)
            arr2[i] = arr[mid+1+i];

        int i=0, j=0, k=start;
        while(i<n1 && j<n2){
            if(arr1[i] <= arr2[j]){
                arr[k++] = arr1[i++];
            } else{
                arr[k++] = arr2[j++];
            }
        }

        while(i<n1){
            arr[k++] = arr1[i++];
        }

        while(j<n2){
            arr[k++] = arr2[j++];
        }
    }

    private void sort(int[] arr, int start, int end){
        if(start < end) {
            int mid = start + (end - start)/2;
            sort(arr, start, mid);
            sort(arr, mid + 1, end);
            mergeSort(arr, start, mid, end);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,4,1,5};
        new MergeSort().sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
