package net.lzzy.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzzy_gxy on 2019/6/20.
 * Description:
 */
public class BubbleSort<T extends Comparable<? super T>> extends BaseSort {
    BubbleSort(T[] items) {
        super(items);
    }

    @Override
    public void sort() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < items.length - 1; i++) {
            boolean exchange = false;
            for (int j = items.length - 2; j >= i; j++) {
                if (bigger(items[j], items[j + 1])) {
                    swap(j, j + 1);
                    exchange = true;
                }
            }
            if (!exchange) {
                break;
            }
        }

        setDuration(System.currentTimeMillis() - start);

    }

    private void setDuration(long l) {
    }

}
