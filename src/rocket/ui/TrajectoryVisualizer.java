package rocket.ui;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TrajectoryVisualizer extends JPanel {
    private final List<Point> points;

    public TrajectoryVisualizer(List<Point> points) {
        this.points = points;
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);

        for (Point p : points) {
            g.fillOval(p.x, p.y, 5, 5);
        }
    }

    public static void display(List<Point> points) {
        JFrame frame = new JFrame("Trajectory Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new TrajectoryVisualizer(points));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
