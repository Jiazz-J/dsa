package com.kk.arr_vec.triplets;

import java.util.ArrayList;

public class TripletsTwoPointer {

  public static void main(String[] args) {
    int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 15};
    int target = 18;
  }

  static ArrayList<Integer[]> findTriplets(int[] input, int target) {

    // int[][] triplets = new int[][]; // Only column initialization will not work

    ArrayList<Integer[]> triplets = new ArrayList<>();

    for (int i = 0; i < input.length; i++) {
      int compliment = target - input[i];
      int[] pairs = findPairs(input, i + 1, compliment);
      if (pairs.length > 0) {
        triplets.add(new Integer[] {input[i], pairs[0], pairs[1]});
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
        break;
      } else if (arr[start] + arr[end] > sum) {
        end -= 1;
      } else {
        start += 1;
      }
    }
    return result;
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
