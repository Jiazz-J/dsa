package com.kk.arr_vec.mountains;

public class FindingPeaksCleanCode {

  public static void main(String[] args) {
    int[] input = {5, 6, 1, 2, 3, 4, 5, 4, 3, 2, 0, 1, 2, 3, -2, 4};
    System.out.println(findPeaks(input));
  }

  static int findPeaks(int[] arr) {

    int max = 0;
    // Considering for a mountain array should contain 3 elements
    for (int i = 1; i < arr.length - 1; ) {
      if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
        int count = 1;

        int j = i;

        while (j > 0 && (arr[j - 1] < arr[j])) {
          count++;
          j--;
        }

        while (i < arr.length - 1 && (arr[i] > arr[i + 1])) {
          count++;
          i++;
        }
        if (count > max) {
          max = count;
        }
      } else {
        i++;
      }
    }
    return max;
  }
}
