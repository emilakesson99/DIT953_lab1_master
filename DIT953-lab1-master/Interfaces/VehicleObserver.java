/**
 * Interface for GUI classes to implement in order to listen to events
 */

public interface VehicleObserver {
    <T> void update(T v);
}
