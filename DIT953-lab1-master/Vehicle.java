import java.awt.*;
import java.util.ArrayList;

public abstract class Vehicle implements Observers {

    public final ArrayList<GUIObserver> observers = new ArrayList<>();
    private final int nrDoors; // Number of doors on the car
    private final double enginePower; // Engine power of the car
    private final Color color; // Color of the car
    private final String modelName;
    public final Movable state;

    /**
     * Constructor
     *
     * @param nrDoors     This is the amount of doors
     * @param enginePower This is enginepower
     * @param color       This is car color
     * @param modelName   This is car model name
     */
    public Vehicle(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.state = new MovingState();

    }

    public void addObserver(GUIObserver a) {
        observers.add(a);
    }

    public void notifyObservers() {
        for (GUIObserver o : observers) o.update(this);
    }

    public Movable.Directions getCurrentDir() {
        return state.getCurrentDir();
    }

    public void setCurrentDir(Movable.Directions currentDir) {
        state.setCurrentDir(currentDir);
    }

    public double getX() {
        return state.getX();
    }

    public double getY() {
        return state.getY();
    }

    public void setX(double x) {
        state.setX(x);
    }

    public void setY(double y) {
        state.setY(y);
    }

    /**
     * @return enginepower
     */
    public double getEnginePower() {
        return enginePower;
    }

    /**
     * @return currentSpeed
     */
    public double getCurrentSpeed() {
        return state.getCurrentSpeed();
    }

    public void setCurrentSpeed(double i) {
        state.setCurrentSpeed(i);
    }

    /**
     * Starts the engine by setting currentSpeed to 0.1
     */
    public void startEngine() {
        setCurrentSpeed(0.1);
    }

    /**
     * Stops the engine
     */
    public void stopEngine() {
        setCurrentSpeed(0);
    }

    public String getModelName() {
        return modelName;
    }

    /**
     * Abstract class for speedFactor function in sub classes
     */
    abstract double speedFactor();

    /**
     * Increases speed
     *
     * @param amount This is the amount of increasing
     * @return currentSpeed
     */
    private double incrementSpeed(double amount) {
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
        return getCurrentSpeed();
    }

    /**
     * Decreases speed
     *
     * @param amount This is the amount of decreasing
     * @return currentSpeed
     */
    private double decrementSpeed(double amount) {
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount, 0));
        return getCurrentSpeed();
    }

    /**
     * currentSpeed is constrained
     *
     * @param amount
     */
    public void gas(double amount) {
        if (amount < 1 && amount > 0)
            if (getCurrentSpeed() < getEnginePower() && incrementSpeed(amount) < getEnginePower())
                incrementSpeed(amount);
    }

    /**
     * currentSpeed is constrained
     *
     * @param amount
     */
    public void brake(double amount) {
        if (amount < 1 && amount > 0)
            if (decrementSpeed(amount) > 0)
                decrementSpeed(amount);
    }

    public void move() {
        state.move();
    }

    public void turnLeft() {
        state.turnLeft();
    }

    public void turnRight() {
        state.turnRight();
    }
}
