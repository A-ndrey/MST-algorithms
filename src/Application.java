import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;

import javax.swing.*;
import java.awt.*;

public class Application extends JFrame {

    public void start(){
        Layout<Node, Edge> layout = new CircleLayout(GraphProvider.getDefinedGraph());
        layout.setSize(new Dimension(300,300)); // sets the initial size of the space
        // The BasicVisualizationServer<V,E> is parameterized by the edge types
        BasicVisualizationServer<Node,Edge> vv = new BasicVisualizationServer<>(layout);
        vv.setPreferredSize(new Dimension(350,350)); //Sets the viewing area size

        add(vv);
        pack();
        setVisible(true);
    }

    Application(){
        super("Application");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
