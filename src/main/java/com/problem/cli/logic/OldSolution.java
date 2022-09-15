package com.problem.cli.logic;

import java.util.Arrays;

public class OldSolution {

  public int solve(int[] speeds) {
    int n = speeds.length;
    Arrays.sort(speeds);
    if (n < 3) {
      return speeds[n - 1];
    }
    else {
      int sum = 0;
      for (int i = 1; i < n; i++) {
        sum += speeds[i];
      }
      return sum + (n - 2) * speeds[0];
    }
  }
}
