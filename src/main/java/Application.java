import controller.LadderController;
import util.RandomLadderGenerator;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RandomLadderGenerator generator = new RandomLadderGenerator();
        LadderController controller = new LadderController(inputView, outputView, generator);
        controller.run();
    }
}
