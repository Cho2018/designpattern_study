package ch04.sample.idcard;

import ch04.sample.framework.*;

import java.util.*;

public class IDCardFactory extends Factory {
    private List owners = new Vector<>();

    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }

    @Override
    protected void registerProduct(Product product) {
        owners.add(((IDCard)product).getOwner());
    }

    public List getOwners() {
        return owners;
    }
}
