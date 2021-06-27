package com.kk.arr_vec.triplets;

import java.util.ArrayList;
import java.util.Arrays;

public class TripletsTwoPointer {

  public static void main(String[] args) {
    int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 15};
    int target = 18;

    ArrayList<Integer[]> arr = findTriplets(input, target);
    for (Integer[] arr_ : arr) {
      System.out.println(Arrays.toString(arr_));
    }
  }

  static ArrayList<Integer[]> findTriplets(int[] input, int target) {
    ArrayList<Integer[]> triplets = new ArrayList<>();
    // HashSet<Integer> usedPairs = new HashSet<>();
    for (int i = 0; i < input.length; i++) {
      int compliment = target - input[i];
      int[] pairs = findPairs(input, i + 1, compliment);
      // if (pairs.length > 0 && !usedPairs.contains(pairs[0]) && !usedPairs.contains(pairs[1])) {
      if (pairs.length > 0) {

        triplets.add(new Integer[] {input[i], pairs[0], pairs[1]});
        /*   usedPairs.add(pairs[0]);
        usedPairs.add(pairs[1]);*/
      }
    }
    return triplets;
  }

  static int[] findPairs(int[] arr, int start, int sum) {

    int end = arr.length - 1;

    int[] result = new int[2];

    while (start < end) {
      if (arr[start] + arr[end] == sum) {
        result[0] = arr[start];
        result[1] = arr[end];
        return result;
      } else if (arr[start] + arr[end] > sum) {
        end -= 1;
      } else {
        start += 1;
      }
    }
    return new int[] {};
  }
}

  /*static int[] findPairs(int[] input, int start, int target) {
      HashSet<Integer> hashSet = new HashSet<>();
      ArrayList<Integer[]> arrayList = new ArrayList<>();
      if (start != input.length) {
        for (int i = start; i < input.length; i++) {

          int compliment = target - input[i];
          if (hashSet.contains(compliment)) {
            return new int[] {input[i], compliment};
            // arrayList.add(new Integer[] {input[i], compliment});
          } else {
            hashSet.add(input[i]);
          }
        }

        //  return arrayList.stream().sorted().toArray();
      }
      return new int[] {};
    }
  }
  */
