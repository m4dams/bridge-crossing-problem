package com.problem.cli.commands;

import com.problem.cli.logic.ProblemSolver;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(
    name = "bridge",
    description = "Application calculates shortest time to cross the bridge according" +
        " to the specified problem",
    mixinStandardHelpOptions = true,
    header = "Crossing app",
    optionListHeading = "%nOptions :%n"
)

public class Bridge implements Runnable {

  @CommandLine.Option(
      names = {"-c", "--crossing"},
      description = "Number of people crossing",
      arity = "1"
  )
  Integer crossing;

  @CommandLine.Option(
      names = {"-s", "--speeds"},
      description = "List of the crossing times separated by a non number delimiter"
  )
  String speeds;

  @Override
  public void run() {
    if (crossing == null && speeds == null) {
      ProblemSolver problemSolver = new ProblemSolver();
      problemSolver.response();
    } else if (speeds != null) {
      ProblemSolver problemSolver = new ProblemSolver(convert(speeds));
      problemSolver.response();
    } else {
      ProblemSolver problemSolver = new ProblemSolver(crossing);
      problemSolver.response();
    }
  }

  private int[] convert(String string) {
    Matcher matcher = Pattern.compile("\\d+").matcher(string);
    List<Integer> numbers = new ArrayList<>();
    while (matcher.find()) {
      numbers.add(Integer.valueOf(matcher.group()));
    }
    int[] array = new int[numbers.size()];
    for (int i = 0; i < numbers.size(); i++) {
      array[i] = numbers.get(i);
    }
    return array;
  }

}
