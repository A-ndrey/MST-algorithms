import algorithms.BoruvkasAlgorithm;
import algorithms.KruskalsAlgorithm;
import algorithms.PrimsAlgorithm;
import algorithms.SimpleTestingAlgorithm;
import reading_verilog.VerilogReader;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException, FileNotFoundException {



//        SwingUtilities.invokeLater(() -> new Application(new BoruvkasAlgorithm()).start(GraphProvider.getInstance()
//                .getRandomCreated(10, true)));
//        SwingUtilities.invokeLater(() -> new Application(new KruskalsAlgorithm()).start(GraphProvider.getInstance()
//                .getRandomCreated(10, true)));
//        SwingUtilities.invokeLater(() -> {
//            try {
//                new Application(new PrimsAlgorithm()).start(GraphProvider
//                        .getInstance().getGraphFromVerilogFile("resources/c17.v"));
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
//        });
        // warm-up
        new SimpleTestingAlgorithm().start(GraphProvider.getInstance().getRandomCreated(100_000, false));

//            new TestAlgorithms(new KruskalsAlgorithm()).start(false);
//            new TestAlgorithms(new PrimsAlgorithm()).start(false);
//            new TestAlgorithms(new BoruvkasAlgorithm()).start(false);
//
//            new TestAlgorithms(new KruskalsAlgorithm()).start(true);
//            new TestAlgorithms(new PrimsAlgorithm()).start(true);
//            new TestAlgorithms(new BoruvkasAlgorithm()).start(true);
//
//        new TestVerilogAlgorithms(new KruskalsAlgorithm()).start();
//        new TestVerilogAlgorithms(new PrimsAlgorithm()).start();
//        new TestVerilogAlgorithms(new BoruvkasAlgorithm()).start();
    }


}