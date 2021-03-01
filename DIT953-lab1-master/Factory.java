import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class Factory {

    final static Map<String, Supplier<Observers>> map = new HashMap<>();

    static {
        map.put("SAAB95", Saab95::new);
        map.put("VOLVO240", Volvo240::new);
        map.put("SCANIA", Scania::new);
        map.put("WORKSHOP", Workshop::new);
    }

    public Observers getObserver(String modelType) {
        Supplier<Observers> vehicle = map.get(modelType.toUpperCase());
        if (vehicle != null) {
            return vehicle.get();
        }
        throw new IllegalArgumentException("No such Object " + modelType.toUpperCase());
    }
}