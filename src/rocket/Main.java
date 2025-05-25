package rocket;


import rocket.simulation.Rocket;
import rocket.simulation.Simulator;
import rocket.output.ConsolePrinter;
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
        List<Simulator.FlightData> results = simulator.getResults();
        ConsolePrinter.print(results);
    }
}