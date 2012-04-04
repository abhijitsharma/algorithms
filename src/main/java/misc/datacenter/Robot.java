package misc.datacenter;

/**
 * User: absharma
 * Date: 3/29/12
 */
public class Robot {
    private int x;
    private int y;
    private Direction d;
    private Grid grid;

    /**
     * Rotation Matrix for angle a
     * [
     *  [cos(a), -sin(a)]
     *  [sin(a), cos(a)]
     * ]
     * E.g. if the robot is @ (1,1) facing E and it receives a command sequence LF
     * (x',y') = [1,1] [ [0,-1], = [1 * 0 + 1 * -1, 1 * 1 + 1 * 0] = [-1, 1]
     *                  [1,0] ]
     */
    private int[][] rot45 =
            new int[][] {
                    {1,-1},
                    {1, 1},
                    };
    
    private int[][] rot90 =
            new int[][] {
                    {0, -1},
                    {1, 0}};

    /*
    
     */
    public Robot(Grid grid, int x, int y, Direction d) {
        validate(grid, "grid");
        this.grid = grid;
        set(x, y, d);
    }

    private void validate(Object o, String s) {
        if (o == null) {
            throw new NullPointerException(s + " is null");
        }
    }

    public void set(int x, int y, Direction d) {
        validate(d, "direction");
        grid.validatePos(x, y);
        this.x = x;
        this.y = y;
        this.d = d;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public Direction d() {
        return d;
    }
}
