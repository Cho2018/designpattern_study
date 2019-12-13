package ch20.sample;

public class Main {
    public static void main(String[] args) {
        BigCharFactory factory = BigCharFactory.getInstance();
        BigChar bc3 = factory.getBigChar('1');
        BigChar bc4 = factory.getBigChar('1');
        BigChar bc5 = factory.getBigChar('1');

        System.out.println("bc3:" + bc3);
        System.out.println("bc4:" + bc4);
        System.out.println("bc5:" + bc5);

        if (args.length == 0) {
            System.out.println("Usage: java Main digits");
            System.exit(0);
        }

        BigString bs1 = new BigString(args[0]);
        bs1.print();
    }
}
