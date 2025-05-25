package rocket.simulation;

import java.util.ArrayList;
import java.util.List;

public class Simulator {

    private Rocket rocket;
    private double timeStep = 0.1;
    private List<FlightData> results;

    public Simulator(Rocket rocket) {
        this.rocket = rocket;
        this.results = new ArrayList<>();
    }

    /**
     * Holds flight data for each time step: time, altitude, velocity, acceleration
     */
    public static class FlightData {
        public final double time;
        public final double altitude;
        public final double velocity;
        public final double acceleration;

        public FlightData(double t, double h, double v, double a) {
            this.time = t;
            this.altitude = h;
            this.velocity = v;
            this.acceleration = a;
        }
    }

    /**
     * Runs the simulation, integrating physics until impact or fuel exhaustion.
     */
    public void run() {
        double t = 0.0;
        double h = 0.0;
        double v = 0.0;
        double m = rocket.getMass();


        double dryMass = 20000.0;


        while (m > dryMass && h >= 0) {

            double rho0 = 1.225;
            double H    = 8500.0;
            double density = rho0 * Math.exp(-h / H);


            double Cd = rocket.getDragCoefficient();
            double A  = rocket.getArea();
            double dragForce = 0.5 * density * v * v * Cd * A;


            double thrustForce = (m > dryMass) ? rocket.getThrust() : 0.0;


            double g = 9.81;
            double acceleration = (thrustForce - dragForce - m * g) / m;


            v += acceleration * timeStep;
            h += v * timeStep;


            double burn = rocket.getBurnRate() * timeStep;
            m = Math.max(dryMass, m - burn);

            t += timeStep;

            results.add(new FlightData(t, h, v, acceleration));


            if (h < 0) break;
        }
    }

    /**
     * returns the collected flight data after run()
     */
    public List<FlightData> getResults() {
        return results;
    }
}