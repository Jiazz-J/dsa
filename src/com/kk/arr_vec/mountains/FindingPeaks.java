package com.kk.arr_vec.mountains;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FindingPeaks {

  public static void main(String[] args) {

    int[] input = {5, 6, 1, 2, 3, 4, 5, 4, 3, 2, 0, 1, 2, 3, -2, 4};
    System.out.println(Objects.requireNonNull(findPeaks(input)));
  }

  static List<Integer> findPeaks(int[] arr) {
    if (arr.length == 0) {
      return null;
    }
    ArrayList<Integer> peaks = new ArrayList<>();
    int right = 0;
    int left = 0;
    int peakLng = 0;
    int max = 0;
    // Considering for a mountain array should contain 3 elements
    for (int i = 1; i < arr.length - 1; i++) {
      if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
        peaks.add(arr[i]);
        left = findLeft(arr, i);
      }
      if (arr[i] > arr[i + 1] && left > 0) {
        right++;
      }
      if (arr[i] < arr[i + 1] && left > 0) {
        peakLng = left + right + 1;
        if (peakLng > max) {
          max = peakLng;
        }
        right = 0;
        left = 0;
        System.out.printf("Length of the peak  %d \n", peakLng);
      }

      //
    }
    System.out.printf("Longest length of a peak %d \n", max);
    return peaks;
  }

  static int findLeft(int[] arr, int start) {
    int leftLng = 0;
    for (int i = start; i > 0; i--) {
      if (arr[i] > arr[i - 1]) {
        leftLng++;
      }
      if (arr[i - 1] > arr[i]) {
        break;
      }
    }
    return leftLng;
  }
}
