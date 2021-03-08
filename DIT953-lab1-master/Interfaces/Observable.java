/**
 * Interface to be implemented by everything that is updated on a screen
 */

public interface Observable {

    void addObserver(Observer o);

    void notifyObservers();

}
