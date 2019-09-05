import java.awt.geom.Point2D;

public interface ViewInterface {

    String getSeparator();
    void setSeparator(String separator);

    boolean getHeaderInFileExists();
    void setHeaderInFileExists(boolean headerExists);

    void setPathToFile(String pathToFile);
    String getPathToFile();

    /**
     *
     * @param column - номер колонны
     * @return - true, если задано удачно, false - если что-то пошло нет
     */
    boolean setColumnForXCoordinate(int column);
    public boolean setColumnForYCoordinate(int column);

    void setFirstPoint(Point2D.Double firstPoint);
    void setSecondPoint(Point2D.Double secondPoint);
    void setAzimuth(double angleInDegrees);

    /**
     *
     * @param direction - направление поворота:
     *                  из абсолютных в относительные - true
     *                  из относительных в абсолютные - false
     */
    void setDirectionCoordinatesRotate(boolean direction);
    boolean getDirectionCoordinatesRotate();

    void fileDisplay();



}
