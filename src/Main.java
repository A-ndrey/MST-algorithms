import algorithms.BoruvkasAlgorithm;
import algorithms.KruskalsAlgorithm;
import algorithms.PrimsAlgorithm;
import algorithms.SimpleTestingAlgorithm;

import javax.swing.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        boolean isStronglyConnected = true;
//        SwingUtilities.invokeLater(() -> new Application(new BoruvkasAlgorithm()).start(GraphProvider.getInstance()
//                .getRandomCreated(10, true)));
//        SwingUtilities.invokeLater(() -> new Application(new KruskalsAlgorithm()).start(GraphProvider.getInstance()
//                .getRandomCreated(10, true)));
//        SwingUtilities.invokeLater(() -> new Application(new PrimsAlgorithm()).start(GraphProvider.getInstance()
//                .getRandomCreated(10, false)));
        // warm-up
//        new SimpleTestingAlgorithm().start(GraphProvider.getInstance().getRandomCreated(100_000, true));

        for (int numberOfVertex = 10_000; numberOfVertex <= 100_000; numberOfVertex += 10_000) {
//            new TestAlgorithms(new KruskalsAlgorithm()).start(numberOfVertex, isStronglyConnected);
            new TestAlgorithms(new PrimsAlgorithm()).start(numberOfVertex, isStronglyConnected);
//            new TestAlgorithms(new BoruvkasAlgorithm()).start(numberOfVertex, isStronglyConnected);
        }
    }


}