
import java.util.List;

public class ListOp {

    static void removeFromList(Object o, List<?> list) {
        list.removeIf(object -> object == o);
    }

    static boolean isInList(Object o, List<?> list) {
        return list.contains(o);
    }

}
