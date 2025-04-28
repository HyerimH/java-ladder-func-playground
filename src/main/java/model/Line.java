package model;

import java.util.ArrayList;
import java.util.List;
import util.LadderGenerator;

public class Line {
  private final List<Status> points;

  public Line(int width, LadderGenerator generator) {
    this.points = new ArrayList<>();
    for (int column = 0; column < width - 1; column++) {
      makeLine(column, generator);
    }
  }

  private void makeLine(int column, LadderGenerator generator) {
    if (points.size() >= 1 && points.get(column - 1).getStatus()) {
      points.add(Status.DISCONNECTED);
      return;
    }
    points.add(Status.findStatus(generator.generate()));
  }

  public int move(int position) {
    if (position > 0 && points.get(position - 1).getStatus()) {
      return position - 1;
    }
    if (position < points.size() && points.get(position).getStatus()) {
      return position + 1;
    }
    return position;
  }

  public List<Status> getPoints() {
    return List.copyOf(points);
  }
}
