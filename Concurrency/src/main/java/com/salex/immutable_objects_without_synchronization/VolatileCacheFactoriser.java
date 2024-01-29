package com.salex.immutable_objects_without_synchronization;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class VolatileCacheFactoriser {
    private volatile OneValueCache cache =
        new OneValueCache(BigInteger.ZERO, new BigInteger[]{});

    public BigInteger[] service(BigInteger i) {
        BigInteger[] factors = cache.getFactors(i);
        if (factors == null) {
            factors = factor(i);
            cache = new OneValueCache(i, factors);
        }
        return factors;
    }

    private BigInteger[] factor(BigInteger i) {
        List<BigInteger> list = new ArrayList<>();
        BigInteger delimeter = BigInteger.TWO;
        while ((i.compareTo(BigInteger.ONE) != 0) && (i.sqrt().compareTo(delimeter) >= 0)) {
            if (i.remainder(delimeter).equals(BigInteger.ZERO)) {
                list.add(delimeter);
                i = i.divide(delimeter);
            } else {
                delimeter = delimeter.add(BigInteger.ONE);
            }
        }
        if (!i.equals(BigInteger.ONE)) {
            list.add(i);
        }
        return list.toArray(new BigInteger[0]);
    }

}
