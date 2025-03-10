package net.lzzy.algorithm;

/**
 * Created by lzzy_gxy on 2019/6/20.
 * Description:
 */
public class SheliBort<T extends Comparable<? super T>> extends BaseSort<T> {
    SheliBort(T[] items) {
        super(items);

    }

    @Override
    public void sort() {
        int len = items.length;
        int g = len / 2;
        while (g > 0) {
            for (int i = g; i < items.length; i++) {
                int j = i - 1;
                if (bigger(items[i], items[j])) {
                    continue;
                }
                T tmp = items[i];
                while (j >= 0 && bigger(items[i], tmp)) {
                    items[j + g] = items[j];
                    moveStep++;
                    j -= g;
                }
                items[j + g] = tmp;
            }
            g = g / 2;
        }
    }
}
