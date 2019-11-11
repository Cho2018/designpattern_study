package ch04.sample;

import ch04.sample.framework.Factory;
import ch04.sample.framework.Product;
import ch04.sample.idcard.IDCardFactory;

public class Main {
    public static void main(String[] args) {
        Factory f01 = new IDCardFactory();
        Product p01 = f01.create("가나다");

        p01.use();
    }
}
