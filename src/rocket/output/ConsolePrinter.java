package rocket.output;

import rocket.simulation.Simulator;
import rocket.simulation.Simulator.FlightData;
import java.util.List;

public class ConsolePrinter {
    public static void print(List<FlightData> data) {
        System.out.printf("Time(s)\tAlt(m)\tVel(m/s)\tAcc(m/s^2)\n");
        for (FlightData d : data) {
            System.out.printf(
                    "%.1f\t%.1f\t%.1f\t%.1f\n",
                    d.time, d.altitude, d.velocity, d.acceleration
            );
        }
    }
}
