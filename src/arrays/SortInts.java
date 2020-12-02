package arrays;

import java.util.Random;

public class SortInts {
public static int[] arr;


    public void quickSort(int[] arr, int low, int high){
        if(low<high){
            int pi=partition(arr, low, high);
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }

    }
    private void swap(int index1, int index2){
        int temp=arr[index1];
        arr[index1]=arr[index2];
        arr[index2]=temp;
    }
    public int partition(int[] arr, int low, int high){
        swap(low, high);
        int border=low+1;
        for(int i=border; i<=high; i++){
            if(arr[i] <arr[low]){
                swap(i, border++);
            }
        }
        swap(low, border++);
        return border-1;

    }
    public static void main(String[] args) {
        SortInts s= new SortInts();
        int size=10;
        Random r= new Random();
        arr= new int[size];
        for(int i=0; i<arr.length; i++){
            arr[i]=Math.abs(r.nextInt()%size);
        }
       s.quickSort(arr,0,arr.length-1);


    }
}
