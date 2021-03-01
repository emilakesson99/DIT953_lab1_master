/**
 * Interface to be implemented by everything that is updated on a screen
 */

public interface Observers {

    void addObserver(GUIObserver v);

    void notifyObservers();

}
