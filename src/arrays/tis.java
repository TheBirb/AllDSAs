package arrays;

public class tis {
    private static int[] data;
    public static void quickSort(){

    }
    private static void quickSort(int left, int right){
        if(left>=right){
            return;
        }
        int pivot=data[(left+right)/2];
        int index=partition(left, right, pivot);
        quickSort(left, index-1);
        quickSort(index-1, right);
    }
    private static int partition(int left, int right, int pivot){
        while(left<right){
            while(data[left]<pivot){
                left++;
            }
            while(data[right]>pivot){
                right--;
            }
            if(data[left]<data[right]){
                swap(left, right);
                left++;
                right--;
            }
        }
        return left;
    }
    private static void swap(int left, int right){
        int temp=data[left];
        data[left]=data[right];
        data[right]=temp;
    }

}
