import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.RenderContext;
import edu.uci.ics.jung.visualization.decorators.EdgeShape;
import edu.uci.ics.jung.visualization.renderers.DefaultEdgeLabelRenderer;
import edu.uci.ics.jung.visualization.renderers.Renderer;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Application extends JFrame {

    Application(){
        super("Application");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void start(){
        new SimpleTestingAlgorithm().start(GraphProvider.getInstance().getDefinedGraph());
        Layout<Node, Edge> layout = new CircleLayout(GraphProvider.getInstance().getDefinedGraph());
        layout.setSize(new Dimension(600,600));
        BasicVisualizationServer<Node,Edge> vv = new BasicVisualizationServer<>(layout);
        vv.setPreferredSize(new Dimension(650,650));
        setStyle(vv);

        add(vv);
        pack();
        setVisible(true);
    }

    private void setStyle(BasicVisualizationServer<Node, Edge> vv){
        RenderContext<Node, Edge> context = vv.getRenderContext();

        vv.getRenderer().getVertexLabelRenderer().setPosition(Renderer.VertexLabel.Position.CNTR);
        vv.setBackground(Color.WHITE);
        context.setEdgeLabelTransformer(edge -> Integer.toString(edge.getWeight()));
        context.setEdgeDrawPaintTransformer(edge -> edge.isVisible() ? Color.BLACK : Color.LIGHT_GRAY);
        context.setEdgeShapeTransformer(new EdgeShape.Line<>());
        context.setEdgeLabelRenderer(new DefaultEdgeLabelRenderer(Color.LIGHT_GRAY){
            @Override
            public <E> Component getEdgeLabelRendererComponent(JComponent vv, Object value, Font font, boolean isSelected, E edge) {
                super.getEdgeLabelRendererComponent(vv, value, font, isSelected, edge);
                setForeground(((Edge)edge).isVisible() ? Color.BLACK : Color.LIGHT_GRAY);
                return this;
            }
        });
        context.setVertexShapeTransformer(node -> new Ellipse2D.Double(-12, -12, 24, 24));
        context.setVertexLabelTransformer(node -> Integer.toString(node.getNumber()));
        context.setVertexFillPaintTransformer(node -> Color.WHITE);
    }


}
