package com.problem.cli.logic;

import java.util.Arrays;
import java.util.Random;

public class ProblemSolver {
  public static final int[] DEFAULT_ARRAY = {1, 2, 5, 10};
  public static final int RANDOM_MIN = 1;
  public static final int RANDOM_MAX = 30;
  private int arrayLength;
  private int[] speeds;

  public ProblemSolver(int[] speeds) {
    this.arrayLength = speeds.length;
    this.speeds = speeds;
  }

  public ProblemSolver(int arrayLength) {
    this.arrayLength = arrayLength;
  }


  public ProblemSolver() {
    this.speeds = DEFAULT_ARRAY;
  }

  public String response() {
    if (this.speeds == DEFAULT_ARRAY) {
      System.out.println(Arrays.toString(this.speeds));
      System.out.println(solve(this.speeds, DEFAULT_ARRAY.length));
      return null;
    }
    if (this.speeds == null) {
      this.speeds = generateSpeeds();
    }
    Arrays.sort(this.speeds);
    System.out.println(Arrays.toString(this.speeds));
    System.out.println(solve(this.speeds, this.arrayLength));
    return null;
  }

  private int[] generateSpeeds() {
    int[] generated = new int[this.arrayLength];
    Random random = new Random();
    for (int i = 0; i < this.arrayLength; i++) {
      generated[i] = random.nextInt(RANDOM_MAX - RANDOM_MIN + 1) + RANDOM_MIN;
    }
    Arrays.sort(generated);
    return generated;
  }

  private int solve(int[] speeds, int n) {
    //almighty google
    if (n < 3) {
      return speeds[n - 1];
    } else if (n == 3) {
      return speeds[0] + speeds[1] + speeds[2];
    } else {
      int timeTakenCaseOne = speeds[1] + speeds[0] + speeds[n - 1] + speeds[1];
      int timeTakenCaseTwo = speeds[n - 1] + speeds[0] + speeds[n - 2] + speeds[0];

      if (timeTakenCaseOne < timeTakenCaseTwo) {
        return timeTakenCaseOne + solve(speeds, n - 2);
      } else if (timeTakenCaseTwo < timeTakenCaseOne) {
        return timeTakenCaseTwo + solve(speeds, n - 2);
      }
      return timeTakenCaseTwo + solve(speeds, n - 2);
    }
  }
}