package heap;

/**
 * User: absharma
 * Date: 6/7/12
 */
public interface PriorityQueue {

    void enqueue(Comparable object);

    Comparable findMin();

    Comparable extractMin();
    
}
