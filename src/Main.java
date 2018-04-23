import algorithms.BoruvkasAlgorithm;
import algorithms.KruskalsAlgorithm;
import algorithms.PrimsAlgorithm;

import javax.swing.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> new Application().start());
        int numberOfVertex = 10000;
        new TestAlgorithms(new BoruvkasAlgorithm()).start(GraphProvider.getInstance().getRandomCreated(numberOfVertex));
        new TestAlgorithms(new KruskalsAlgorithm()).start(GraphProvider.getInstance().getRandomCreated(numberOfVertex));
        new TestAlgorithms(new PrimsAlgorithm()).start(GraphProvider.getInstance().getRandomCreated(numberOfVertex));
    }


}