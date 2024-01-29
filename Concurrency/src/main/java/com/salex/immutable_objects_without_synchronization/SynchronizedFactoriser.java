package com.salex.immutable_objects_without_synchronization;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class SynchronizedFactoriser {

    private BigInteger lastNumber;
    private BigInteger[] lastFactors;


    public synchronized BigInteger[] service(BigInteger i) {
        if (i.equals(lastNumber)) {
            return lastFactors;
        } else {
            lastNumber = i;
            BigInteger[] factors = factor(i);
            lastFactors = factors;
            return factors;
        }
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
