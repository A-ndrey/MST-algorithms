import algorithms.BoruvkasAlgorithm;
import algorithms.KruskalsAlgorithm;
import algorithms.PrimsAlgorithm;

import javax.swing.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> new Application(new BoruvkasAlgorithm()).start(GraphProvider.getInstance().getRandomCreated(10)));
        SwingUtilities.invokeLater(() -> new Application(new KruskalsAlgorithm()).start(GraphProvider.getInstance()
                .getRandomCreated(10, true)));
//        SwingUtilities.invokeLater(() -> new Application(new PrimsAlgorithm()).start(GraphProvider.getInstance().getRandomCreated(10)));
//        for (int numberOfVertex = 10_000; numberOfVertex <= 100_000; numberOfVertex += 10_000) {
//            new TestAlgorithms(new BoruvkasAlgorithm()).start(GraphProvider.getInstance().getRandomCreated(numberOfVertex));
//            new TestAlgorithms(new KruskalsAlgorithm()).start(GraphProvider.getInstance().getRandomCreated(numberOfVertex));
//            new TestAlgorithms(new PrimsAlgorithm()).start(GraphProvider.getInstance().getRandomCreated(numberOfVertex));
//        }
    }


}