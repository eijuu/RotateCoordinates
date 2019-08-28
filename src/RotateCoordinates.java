/**
 * RotateCoordinates class
 * eijuu 28.08.2019
 *
 *
 */
import java.awt.geom.Point2D;

public class RotateCoordinates {

    private Point2D.Double point1Around;
    private double cosAngle;
    private double sinAngle;

    public RotateCoordinates(Point2D.Double pointAround, double angle) {

        this.point1Around = pointAround;
        cosAngle = Math.cos(Math.toRadians(angle));
        sinAngle = Math.sin(Math.toRadians(angle));
    }

    public RotateCoordinates(Point2D.Double point1Around, Point2D.Double point2Around) {

        this.point1Around = point1Around;
        double distance = point1Around.distance(point2Around);
        if (distance == 0.0) {
            throw new IllegalArgumentException("Same coordinates around which rotation!");
        }
        cosAngle = (point2Around.getX() - point1Around.getX()) / distance;
        sinAngle = (point2Around.getY() - point1Around.getY()) / distance;

    }

    public Point2D.Double rotateRelToAbs(Point2D.Double targetPoint) {
        return compRotateRelToAbs(targetPoint, point1Around);
    }

    public Point2D.Double rotateAbsToRel(Point2D.Double targetPoint) {
        return  compRotateAbsToRel(targetPoint, point1Around);
    }

    private Point2D.Double compRotateAbsToRel(Point2D.Double targetPoint, Point2D.Double point1Around) {
        double targetY = (targetPoint.y - point1Around.y) * cosAngle -
                (targetPoint.x - point1Around.x) * sinAngle;
        double targetX = (1 / cosAngle) * (targetPoint.x + targetY * sinAngle - point1Around.x);

        return new Point2D.Double(targetX, targetY);
    }

    private Point2D.Double compRotateRelToAbs(Point2D.Double targetPoint, Point2D.Double point1Around) {
        double targetX = targetPoint.x * cosAngle - targetPoint.y * sinAngle;
        double targetY = targetPoint.x * sinAngle + targetPoint.y * cosAngle;
        targetX += point1Around.x;
        targetY += point1Around.y;
        return new Point2D.Double(targetX, targetY);
    }


}
