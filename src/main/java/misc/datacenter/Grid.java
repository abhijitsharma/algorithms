package misc.datacenter;

import java.util.ArrayList;
import java.util.List;

/**
 * User: absharma
 * Date: 3/29/12
 */
public class Grid {
    private int cols;
    private int rows;

    private List<Robot> robots = new ArrayList<Robot>();

    public Grid(int cols, int rows) {
        if (cols <= 1 || rows <= 1) {
            throw new IllegalArgumentException("Cols/Rows illegal " + cols + " : " + rows);
        }
        this.cols = cols;
        this.rows = rows;
    }

    public int cols() {
        return cols;
    }

    public int rows() {
        return rows;
    }

    public void addRobot(Robot r) {
        if(isOccupied(r.x(), r.y())) {
            throw new RuntimeException("A robot already exists @ " + r.x() + ", " + r.y());
        }
        robots.add(r);
    }

    public Robot getRobot(int i) {
        if(i < 0 || i > (robots.size() - 1)) {
            throw new IllegalArgumentException("No robot at " + i);
        }
        return robots.get(i);
    }

    public boolean isOccupied(int x, int y) {
        for(Robot r : robots) {
            if(r.x() == x && r.y() == y) {
                return true;
            }
        }
        return false;
    }

    public void validatePos(int x, int y) {
        if(x < 0 || x > cols - 1) {
            throw new IllegalArgumentException("Illegal x " + x);
        }
        if(y < 0 || y > rows - 1) {
            throw new IllegalArgumentException("Illegal y " + y);
        }
    }
}
