package ch10.hw;

public class Main {
    public static void main(String[] args) {
        String[] data = {
                "Dumpty", "Bowman", "Carroll", "Elfland", "Alice",
        };

        SortAndPrint sap = new SortAndPrint(data, new SelectionSorter());
        sap.execute();
        System.out.println();

        sap.setSorter(new QuickSorter());
        sap.execute();
        System.out.println();

        sap.setSorter(new InsertSorter());
        sap.execute();
        System.out.println();

        sap.setSorter(new BubbleSorter());
        sap.execute();
        System.out.println();
    }
}
