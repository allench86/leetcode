import java.util.HashMap;
import java.util.Set;

public class TwoSum {
    HashMap<Integer, Integer> store;

    public TwoSum() {
        store = new HashMap<Integer, Integer>();
    }

    public void add(int number) {
        if (store.containsKey(number)) {
            int value = store.get(number);
            value++;
            store.put(number, value);
        }
        else {
            store.put(number, 1);
        }
    }

    public boolean find(int value) {
        Set<Integer> keySet = store.keySet();

        for (Integer key : keySet) {
            int t = value - key;
            int v = store.get(key);
            if (v > 1) {
                if (t == key) {
                    return true;
                }
                else if (store.containsKey(t)) {
                    return true;
                }
            }
            else {
                if (t == key) {
                    return false;
                }
                else if (store.containsKey(t)) {
                    return true;
                }
            }
        }
        return false;
    }
}
