package tshirtsort;

import java.util.List;
import tshirtsort.factories.TShirtFactory;
import tshirtsort.models.TShirt;
import tshirtsort.sorting.BubbleSort;
import tshirtsort.sorting.BucketSort;
import tshirtsort.sorting.QuickSort;

public class MainClass {

    public static void main(String[] args) {

        TShirtFactory tFactory = new TShirtFactory();
        List<TShirt> shirts = tFactory.tShirtGenerateX(30);
        QuickSort qs = new QuickSort();
        BubbleSort bs = new BubbleSort();
        BucketSort bus = new BucketSort();

        BucketSort.performBucketSort(bus, shirts);
        BucketSort.performBucketSortPerPropertyASC(bus, shirts);
        BucketSort.performBucketSortPerPropertyDESC(bus, shirts);



//        BubbleSort.performBubbleSort(bs, shirts);
//        BubbleSort.performBubbleSortPerPropertyASC(bs, shirts);
//        BubbleSort.performBubbleSortPerPropertyDESC(bs, shirts);



//        QuickSort.performQuickSort(qs, shirts);
//        QuickSort.performQuickSortPerPropertyDESC(qs, shirts);
//        QuickSort.performQuickSortPerPropertyASC(qs, shirts);
    }
}
