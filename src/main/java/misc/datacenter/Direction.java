package misc.datacenter;

/**
 * User: absharma
 * Date: 3/29/12
 */
public enum Direction {
    N(90), W(180), S(270), E(0), NE(45), NW(135), SW(225), SE(315);

    private int angle;

    Direction(int angle) {
        this.angle = angle;
    }

    public int angle() {
        return angle;
    }

}
