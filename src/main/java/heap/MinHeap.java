package heap;

import java.util.ArrayList;
import java.util.List;

/**
 * User: absharma
 * Date: 6/7/12
 */
public class MinHeap implements PriorityQueue {

    private List<Comparable> objects = new ArrayList<Comparable>();
    
    @Override
    public void enqueue(Comparable object) {
        int size = objects.size();
        objects.add(object);
    }

    @Override
    public Comparable findMin() {
        return objects.size() == 0 ? null : objects.get(0);
    }

    @Override
    public Comparable extractMin() {
        return null;
    }
}
