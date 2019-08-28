import java.awt.geom.Point2D;

public class CoordinateRotateAroundSinglePoint extends CoordinateRotateAbstract {

    private Point2D.Double pointAround;

    public CoordinateRotateAroundSinglePoint(Point2D.Double pointAround, double angle) {

        this.pointAround = pointAround;
        cosAngle = Math.cos(Math.toRadians(angle));
        sinAngle = Math.sin(Math.toRadians(angle));

    }

    public Point2D.Double rotateRelToAbs(Point2D.Double targetPoint) {
        return compRotateRelToAbs(targetPoint, pointAround);
    }

    public Point2D.Double rotateAbsToRel(Point2D.Double targetPoint) {
        return  compRotateAbsToRel(targetPoint, pointAround);
    }

}
