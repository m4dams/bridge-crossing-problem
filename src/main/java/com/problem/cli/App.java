package com.problem.cli;

import com.problem.cli.commands.Bridge;
import picocli.CommandLine;

public class App {
  public static void main(String[] args) {
    new CommandLine(new Bridge()).execute("-s 20,23x45h78;11f");
  }
}
