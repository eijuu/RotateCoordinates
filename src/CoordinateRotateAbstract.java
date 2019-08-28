import java.awt.geom.Point2D;

public abstract class CoordinateRotateAbstract {
    double cosAngle;
    double sinAngle;

    public CoordinateRotateAbstract() {

    }

    public Point2D.Double compRotateAbsToRel(Point2D.Double targetPoint, Point2D.Double point1Around) {
        double targetY = (targetPoint.y - point1Around.y) * cosAngle -
                (targetPoint.x - point1Around.x) * sinAngle;
        double targetX = (1 / cosAngle) * (targetPoint.x + targetY * sinAngle - point1Around.x);

        return new Point2D.Double(targetX, targetY);
    }


    public Point2D.Double compRotateRelToAbs(Point2D.Double targetPoint, Point2D.Double point1Around) {
        double targetX = targetPoint.x * cosAngle - targetPoint.y * sinAngle;
        double targetY = targetPoint.x * sinAngle + targetPoint.y * cosAngle;
        targetX += point1Around.x;
        targetY += point1Around.y;
        return new Point2D.Double(targetX, targetY);
    }



}
