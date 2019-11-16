package ch11.sample;

public class Main {
    public static void main(String[] args) {
        Directory root = new Directory("root");
        Directory d1 = new Directory("Kim");
        Directory d2 = new Directory("Choi");

        root.add(d1);

        File f1 = new File("diary.html", 100);
        File f2 = new File("Composite.java", 200);

        d1.add(f1);
        d1.add(f2);

        File f3 = new File("choi.diary.html", 300);
        File f4 = new File("choi.Composite.java", 400);

        d2.add(f3);
        d2.add(f4);

        d1.add(d2);

        System.out.println(f1.toString());
        System.out.println(f2);

        System.out.println(d1.toString());

        System.out.println(d1.getSize());
        d1.printList();

        System.out.println("root.getSize():" + root.getSize());
        root.printList();
    }
}
