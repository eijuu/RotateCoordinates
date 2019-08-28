import java.awt.geom.Point2D;

public class CoordinateRotateAroundTwoPoints extends CoordinateRotateAbstract {

    private Point2D.Double point1Around;


    public CoordinateRotateAroundTwoPoints(Point2D.Double point1Around, Point2D.Double point2Around) {

        this.point1Around = point1Around;

        double distance = point1Around.distance(point2Around);
        cosAngle = (point2Around.getX() - point1Around.getX()) / distance;
        sinAngle = (point2Around.getY() - point1Around.getY()) / distance;
    }

    public Point2D.Double rotateRelToAbs(Point2D.Double targetPoint) {
        return compRotateRelToAbs(targetPoint, point1Around);
    }

    public Point2D.Double rotateAbsToRel(Point2D.Double targetPoint) {
        return  compRotateAbsToRel(targetPoint, point1Around);
    }


}
