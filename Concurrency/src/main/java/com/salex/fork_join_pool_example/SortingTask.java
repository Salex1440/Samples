package com.salex.fork_join_pool_example;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class SortingTask extends RecursiveTask<int[]> {

    private final int[] array;

    public SortingTask(int[] array) {
        this.array = array;
    }

    @Override
    protected int[] compute() {
        if (array.length <= 1) {
            return array;
        }
        SortingTask leftPart = new SortingTask(Arrays.copyOfRange(array, 0, array.length/2));
        SortingTask rightPart = new SortingTask(Arrays.copyOfRange(array, array.length/2, array.length));
        leftPart.fork();
        rightPart.fork();

        int[] leftSortedArr = leftPart.join();
        int[] rightSortedArr = rightPart.join();
        for (int i = 0, l = 0, r = 0; i < array.length; i++) {
            if (r == rightSortedArr.length) {
                array[i] = leftSortedArr[l++];
            } else if (l == leftSortedArr.length) {
                array[i] = rightSortedArr[r++];
            }
            else if (leftSortedArr[l] < rightSortedArr[r]) {
                array[i] = leftSortedArr[l++];
            } else {
                array[i] = rightSortedArr[r++];
            }
        }
        return array;
    }
}
