import algorithms.KruskalsAlgorithm;
import algorithms.PrimsAlgorithm;

public class Main {

    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> new Application().start());
        new TestAlgorithms(new KruskalsAlgorithm()).start();
        new TestAlgorithms(new PrimsAlgorithm()).start();
    }


}