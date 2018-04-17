import algorithms.KruskalsAlgorithm;
import algorithms.PrimsAlgorithm;

public class Main {

    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> new Application().start());
        int numberOfVertex = 20000;
        new TestAlgorithms(GraphProvider.getInstance().getRandomCreated(numberOfVertex), new KruskalsAlgorithm()).start();
        new TestAlgorithms(GraphProvider.getInstance().getRandomCreated(numberOfVertex), new PrimsAlgorithm()).start();
    }


}