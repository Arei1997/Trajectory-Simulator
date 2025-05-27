package rocket;

import rocket.simulation.Rocket;
import rocket.simulation.Simulator;
import rocket.simulation.Simulator.FlightData;
import rocket.output.ConsolePrinter;
import rocket.ui.TrajectoryVisualizer;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        double initialMass = 50000;   // kg
        double burnRate    = 250;     // kg/s
        double thrust      = 1_000_000; // N
        double dragCoef    = 0.5;     // Cd
        double area        = 10;      // m^2

        Rocket rocket     = new Rocket(initialMass, burnRate, thrust, dragCoef, area);
        Simulator simulator = new Simulator(rocket);

        simulator.run();
        List<FlightData> results = simulator.getResults();
        ConsolePrinter.print(results);


        double maxAlt = results.stream().mapToDouble(f -> f.altitude).max().orElse(1);
        double minAlt = results.stream().mapToDouble(f -> f.altitude).min().orElse(0);
        double altRange = maxAlt - minAlt;

        int panelHeight = 600;
        int panelWidth = 800;


        List<Point> drawPoints = new ArrayList<>();

        for (FlightData data : results) {
            int x = (int)(data.time * 2);

            // normalize altitude to 0–1
            double norm = (data.altitude - minAlt) / altRange;
            int y = (int)((1.0 - norm) * panelHeight);

            drawPoints.add(new Point(x, y));
        }
        TrajectoryVisualizer.display(drawPoints);
    }
}
