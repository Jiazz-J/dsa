package com.kk.arr_vec.pairs;

import java.util.Arrays;
import java.util.HashSet;

public class PairsOptimal {
  public static void main(String[] args) {

    int[] input = {10, 5, 2, 3, -6, 9, 11, 2, 2};
    int sum = 4;

    System.out.println(
        Arrays.toString(
            findPairs(
                input,
                sum))); // result.toString() is returning address instead of values in it. Need to
    // check
    // where went wrong
    // Update need to use Arrays.toString(result)

  }

  static int[] findPairs(int[] arr, int sum) {

    int[] result = new int[2];

    HashSet<Integer> hashSet = new HashSet<>();

    for (int ele : arr) {

      int sumCompliment = sum - ele;
      if (hashSet.contains(sumCompliment)) {
        result[0] = ele;
        result[1] = sumCompliment;
      } else {
        hashSet.add(ele);
      }
    }

    return result;
  }
}
