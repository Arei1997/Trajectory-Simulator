package rocket.simulation;

public class Rocket {


    private double mass;
    private double burnRate;
    private double thrust;
    private double dragCoefficient;
    private double area;

    public Rocket(double mass,
                  double burnRate,
                  double thrust,
                  double dragCoefficient,
                  double area) {
        this.mass              = mass;
        this.burnRate          = burnRate;
        this.thrust            = thrust;
        this.dragCoefficient   = dragCoefficient;
        this.area              = area;
    }

    public double getMass() {
        return mass;
    }

    public double getBurnRate() {
        return burnRate;
    }

    public double getThrust() {
        return thrust;
    }

    public double getDragCoefficient() {
        return dragCoefficient;
    }

    public double getArea() {
        return area;
    }



}
