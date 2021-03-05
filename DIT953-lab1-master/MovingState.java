public class MovingState implements Movable {

    private double x;
    private double y;
    private Directions currentDir;
    private double currentSpeed;

    @Override
    public void move() {
        if (this.currentDir == null) {
            this.currentDir = Directions.EAST;
            setX(getX() + getCurrentSpeed());
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

    @Override
    public double getX() {
        return x;
    }

    @Override
    public void setX(double x) {
        this.x = x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public Directions getCurrentDir() {
        return currentDir;
    }

    @Override
    public void setCurrentDir(Directions currentDir) {
        this.currentDir = currentDir;
    }

    @Override
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    @Override
    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

}
