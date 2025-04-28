package controller;

import model.Ladder;
import model.LadderGame;
import model.LadderHeight;
import model.LadderWidth;
import model.Line;
import java.util.ArrayList;
import java.util.List;
import util.LadderGenerator;
import view.InputView;
import view.OutputView;

public class LadderController {
  private final InputView inputView;
  private final OutputView outputView;
  private final LadderGenerator generator;

  public LadderController(InputView inputView, OutputView outputView, LadderGenerator generator) {
    this.inputView = inputView;
    this.outputView = outputView;
    this.generator = generator;
  }

  public void run() {
    LadderWidth width = inputView.inputLadderWidth();
    LadderHeight height = inputView.inputLadderHeight();
    List<Line> lines = new ArrayList<>();
    for (int i = 0; i < height.getLadderHeight(); i++) {
      lines.add(new Line(width.getLadderWidth(), generator));
    }
    Ladder ladder = new Ladder(height, width, lines);
    outputView.printLadder(ladder);
    outputView.printResults(new LadderGame(ladder).play());
  }
}
