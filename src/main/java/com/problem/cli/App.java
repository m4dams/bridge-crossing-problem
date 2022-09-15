package com.problem.cli;

import com.problem.cli.commands.Bridge;
import picocli.CommandLine;

public class App {
  public static void main(String[] args) {
    if ((args[0].equals("-s") || args[0].equals("--speeds"))
        && !(args[1].matches(".*\\d+.*"))) {
      throw new IllegalArgumentException("String must contain at least 1 number");
    }
    new CommandLine(new Bridge()).execute(args);
  }
}
