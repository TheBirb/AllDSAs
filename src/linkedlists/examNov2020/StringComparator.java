package linkedlists.examNov2020;

import java.util.Comparator;

public class StringComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        int cmp=o1.compareTo(o2);
        if(cmp>0){
            return 1;
        }else if(cmp<0){
            return -1;
        }else{
            return 0;
        }
    }
}
