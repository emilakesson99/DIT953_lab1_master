import java.awt.*;

public abstract class Vehicle implements Movable{

    private double x = 0;
    private double y = 0;
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName;
    private Directions currentDir;

    public enum Directions {
        EAST,
        WEST,
        NORTH,
        SOUTH
    }

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
    }

    /**
     * @return nrDoors
     */
    public int getNrDoors() {
        return nrDoors;
    }

    public Directions getCurrentDir() {
        return currentDir;
    }

    public void setCurrentDir(Directions currentDir) {
        this.currentDir = currentDir;
    }

    public  double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
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
        return currentSpeed;
    }

    public void setCurrentSpeed(double i) {
        currentSpeed = i;
    }

    /**
     * @return color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Package-private Setter
     *
     * @param clr
     */
    void setColor(Color clr) {
        color = clr;
    }

    /**
     * Starts the engine by setting currentSpeed to 0.1
     */
    public void startEngine() {
        currentSpeed = 0.1;
    }

    /**
     * Stops the engine
     */
    public void stopEngine() {
        currentSpeed = 0;
    }

    /**
     * set conditions for direction
     *
     * @param left, right
     */


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
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
        return currentSpeed;
    }

    /**
     * Decreases speed
     *
     * @param amount This is the amount of decreasing
     * @return currentSpeed
     */
    private double decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
        return currentSpeed;
    }

    /**
     * currentSpeed is constrained
     *
     * @param amount
     */
    public void gas(double amount) {
        if (amount < 1 && amount > 0)
            if (currentSpeed < enginePower && incrementSpeed(amount) < enginePower)
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

    /**
     * Y represents 2D movement on a vertical axis
     * X represents 2D movement on a horizontal axis
     */
    @Override
    public void move() {
        if (this.currentDir == null) {
            this.currentDir = Directions.NORTH;
            setY(getY() + getCurrentSpeed());
        } else if (this.currentDir == Directions.EAST) {
            setX(getX() + getCurrentSpeed());
        } else if (this.currentDir == Directions.SOUTH) {
            setY(getY() - getCurrentSpeed());
        } else if (this.currentDir == Directions.WEST) {
            setX(getX() - getCurrentSpeed());
        }

    }

    @Override
    public void turnLeft() {
        if (getCurrentDir() == null) {
            setCurrentDir(Directions.WEST);
        } else if (getCurrentDir() == Directions.EAST) {
            setCurrentDir(Directions.NORTH);
        } else if (getCurrentDir() == Directions.SOUTH) {
            setCurrentDir(Directions.EAST);
        } else if (getCurrentDir() == Directions.WEST) {
            setCurrentDir(Directions.SOUTH);
        }
    }

    @Override
    public void turnRight() {
        if (getCurrentDir() == null) {
            setCurrentDir(Directions.EAST);
        } else if (getCurrentDir() == Directions.EAST) {
            setCurrentDir(Directions.SOUTH);
        } else if (getCurrentDir() == Directions.SOUTH) {
            setCurrentDir(Directions.WEST);
        } else if (getCurrentDir() == Directions.WEST) {
            setCurrentDir(Directions.NORTH);
        }
    }
}
