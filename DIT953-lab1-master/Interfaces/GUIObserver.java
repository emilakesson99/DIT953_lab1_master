/**
 * Interface for GUI classes to implement in order to listen to events
 */

public interface GUIObserver {
    <T> void update(T v);
}
