package net.lzzy.algorithm;

/**
 * Created by lzzy_gxy on 2019/6/22.
 * Description:
 */
public class SearchFactory {
    public static <T extends Comparable<? super T>> BaseSearch<T> getInstance(int key, T[] items) {
        BaseSort<T> search;
        switch (key) {
            case 0:
                search = new DirectSort<>(items);
                break;
            case 1:
                search = new InsertSort<>(items);
                break;

            default:
                return null;
        }
        return (BaseSearch<T>) search;
    }

    public static String[] getSortNames() {
        return new String[]{"选择排序", "直接插入排序", "希尔排序"};
    }
}
