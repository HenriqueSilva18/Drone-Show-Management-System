package lapr4.customermanagement.domain;

import java.util.Set;

public enum CustomerType {
    REGULAR, VIP;

    public static Iterable<CustomerType> asList() {
        return Set.of(values());
    }
}

