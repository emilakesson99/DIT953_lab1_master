
public interface Movable {

    enum Directions {
        EAST,
        WEST,
        NORTH,
        SOUTH
    }

    void move();

    void turnLeft();

    void turnRight();

    Directions getCurrentDir();

    void setCurrentDir(Directions currentDir);

    double getX();

    double getY();

    void setX(double x);

    void setY(double y);

    double getCurrentSpeed();

    void setCurrentSpeed(double i);
}
