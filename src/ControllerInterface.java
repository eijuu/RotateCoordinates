import java.awt.geom.Point2D;
public interface ControllerInterface {

    public String getSeparator();
    public void setSeparator(String separator);

    public boolean getHeaderInFileExists();
    public void setHeaderInFileExists(boolean headerExists);

    public void setPathToFile(String pathToFile);
    public String getPathToFile();

    /**
     *
     * @param column - номер колонны
     * @return - true, если задано удачно, false - если что-то пошло нет
     */
    public boolean setColumnForXCoordinate(int column);
    public boolean setColumnForYCoordinate(int column);

    public void setFirstPoint(Point2D.Double firstPoint);
    public void setSecondPoint(Point2D.Double secondPoint);
    public void setAzimuth(double angleInDegrees);

    /**
     *
     * @param direction - направление поворота:
     *                  из абсолютных в относительные - true
     *                  из относительных в абсолютные - false
     */
    public void setDirectionCoordinatesRotate(boolean direction);
    public boolean getDirectionCoordinatesRotate();

    public void fileDisplay();


}
