package arrays;

public class sorting {

    public static void quickSort(int[] data){
        quicksort(data, 0, data.length-1);
    }
    private static  void quicksort(int[] data, int left, int right){
        if(left>=right){
            return;
        }
        int pivot=data[(left+right)/2];
       int index= partition(data, left, right, pivot);
       quicksort(data,left, index-1);
       quicksort(data, index, right);
    }

    public static int partition(int[] data, int left, int right, int pivot){
        while(left<=right){
            while(data[left]<pivot){
                left++;
            }
            while(data[right]>pivot){
                right--;
            }
            if(left<=right){
                swap(data,left,right);
                left++;
                right--;
            }
        }
        return left;
    }
    public static void swap(int[] data, int left, int right){
        int temp=data[left];
        data[left]=data[right];
        data[right]=temp;
    }

    public static void main(String[] args) {
        int[] list= {2,6,4,9,4,3,6,1,0,3};
        quickSort(list);
        for (int i = 0; i <list.length; i++) {
            System.out.println(list[i]);
        }
    }
}
