package ch10.hw;

public class InsertSorter implements Sorter {
    @Override
    public void sort(Comparable[] data) {
        for (int i = 1; i < data.length; i++) {
            for (int j = i; j > 0; j--) {
                if (data[j - 1].compareTo(data[j]) > 0) {
                    Comparable temp = data[j - 1];
                    data[j - 1] = data[j];
                    data[j] = temp;
                }
            }
        }
    }
}
