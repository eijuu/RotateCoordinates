import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;

public class MainForm extends Component implements ViewInterface{
    private JPanel rootPanel;
    private JPanel pathPanel;
    private JTextField pathTextField;
    private JButton browsePathButton;
    private JComboBox<String> coordinateXComboBox;
    private JComboBox<String>  coordinateYComboBox;
    private JCheckBox headerIsExistCheckBox;
    private JPanel selectSeparatorPanel;
    private JPanel selectColumnXYPanel;
    private JTabbedPane prmRotateTabbedPane;
    private JPanel selectPrmRotatePanel;
    private JPanel twoPointsPanel;
    private JPanel singlePointAzimuthPanel;
    private JPanel coordinateXPanel;
    private JPanel coordinateYPanel;
    private JPanel headerExistPanel;
    private JPanel firstPointPanel;
    private JPanel secondPointPanel;
    private JPanel firstPointCoordXPanel;
    private JPanel firstPointCoordYPanel;
    private JPanel secondPointCoordXPanel;
    private JPanel secondPointCoordYPanel;
    private JPanel singlePointPanel;
    private JPanel azimuthPanel;
    private JPanel singlePointCoordXPanel;
    private JPanel singlePointCoordYPanel;
    private JTextField azimuthTextField;
    private JTextField singlePointCoordXTextField;
    private JTextField singlePointCoordYTextField;
    private JTextField secondPointCoordXTextField;
    private JTextField secondPointCoordYTextField;
    private JTextField firstPointCoordXTextField;
    private JTextField firstPointCoordYTextField;
    private JPanel chooseDirection;
    private JRadioButton absToRelRadio;
    private JRadioButton relToAbsRadio;
    private JPanel controlPanel;
    private JButton saveButton;
    private JButton calculateButton;
    private JRadioButton separatorTabRadio;
    private JRadioButton separatorSpaceRadio;
    private JRadioButton separatorCommaRadio;
    private JRadioButton separatorSemicolonRadio;
    private JRadioButton separatorAnotherRadio;
    private JTextField separatorAnotherTextField;
    private JPanel showDataPanel;
    private JTextArea showDataTextArea;


    private final int FILE_DISPLAY_MAX_ROWS = 20;
    private final String COORDINATE_X_IDENTIFIER = "x";
    private final String COORDINATE_Y_IDENTIFIER = "y";

    private String separator;
    private boolean headerExists;
    private String pathToFile;
    private int columnXCoordinate;
    private int columnYCoordinate;

    private Point2D firstPoint;
    private Point2D secondPoint;
    private double azimuth;
    private boolean directionRotate;

    private FileWithCoordinates coordinatesObject;

    public MainForm(JFrame frame) {

    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public JButton getBrowsePathButton() {
        return browsePathButton;
    }

    public void setPathToPathTextField(String path) {
        pathTextField.setText(path);
    }

    public JTextField getPathTextField() {
        return pathTextField;
    }

    public String recognizeSeparator() {
        if (separatorTabRadio.isSelected()) {
            return "\t";
        } else if (separatorSpaceRadio.isSelected()) {
            return " ";
        } else if (separatorCommaRadio.isSelected()) {
            return ",";
        }
        if (separatorSemicolonRadio.isSelected()) {
            return ";";
        } else {
            return separatorAnotherTextField.getText();
        }
    }

    public boolean recognizeHeaderExist() {
        return headerIsExistCheckBox.isSelected();
    }


    public JPanel getShowDataPanel() {
        return showDataPanel;
    }

    public void fillFileViewer(String[] columns, ArrayList<String[]> data) {
        showDataTextArea.setText(null);

        for (int i = 0; i < columns.length; i++) {
            if (i != columns.length - 1) {
                showDataTextArea.append(columns[i] + "\t|\t");
            } else {
                showDataTextArea.append(columns[i]);
            }
        }
        showDataTextArea.append("\n");

        String[] rowSeparator = new String[columns.length];
        Arrays.fill(rowSeparator, "-----------");

        for (int i = 0; i < columns.length; i++) {
            if (i != rowSeparator.length - 1) {
                showDataTextArea.append(rowSeparator[i] + "\t|\t");
            } else {
                showDataTextArea.append(rowSeparator[i]);
            }
        }
        showDataTextArea.append("\n");

        for (String[] datum : data) {
            for (int j = 0; j < datum.length; j++) {
                if (j != datum.length - 1) {
                    showDataTextArea.append(datum[j] + "\t|\t");
                } else {
                    showDataTextArea.append(datum[j]);
                }
            }
            showDataTextArea.append("\n");
        }
        showDataTextArea.append("....");
        showDataTextArea.setCaretPosition(0);
    }

    public JRadioButton getSeparatorTabRadio() {
        return separatorTabRadio;
    }

    public JRadioButton getSeparatorSpaceRadio() {
        return separatorSpaceRadio;
    }

    public JRadioButton getSeparatorCommaRadio() {
        return separatorCommaRadio;
    }

    public JRadioButton getSeparatorSemicolonRadio() {
        return separatorSemicolonRadio;
    }

    public JRadioButton getSeparatorAnotherRadio() {
        return separatorAnotherRadio;
    }

    public JTextField getSeparatorAnotherTextField() {
        return separatorAnotherTextField;
    }

    public JCheckBox getHeaderIsExistCheckBox() {
        return headerIsExistCheckBox;
    }

    public void fillXYCoordinateSelector(String[] header) {
        coordinateXComboBox.removeAllItems();
        coordinateYComboBox.removeAllItems();
        for (String s : header) {
            coordinateXComboBox.addItem(s);
            coordinateYComboBox.addItem(s);
        }
    }

    private void selectXCoordinate(int c) {
        coordinateXComboBox.setSelectedIndex(c);
    }

    private void selectYCoordinate(int c) {
        coordinateYComboBox.setSelectedIndex(c);
    }

    @Override
    public String getSeparator() {
        return separator;
    }

    @Override
    public void setSeparator(String separator) {
        this.separator = separator;
    }

    @Override
    public boolean getHeaderInFileExists() {
        return headerExists;
    }

    @Override
    public void setHeaderInFileExists(boolean headerExists) {
        this.headerExists = headerExists;
    }

    @Override
    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    @Override
    public String getPathToFile() {
        return pathToFile;
    }

    @Override
    public boolean setColumnForXCoordinate(int column) {
        try {
            selectXCoordinate(column);
            columnXCoordinate = column;
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean setColumnForYCoordinate(int column) {
        try {
            selectYCoordinate(column);
            columnYCoordinate = column;
        } catch (Exception e) {
            return false;
        }


        return true;
    }

    @Override
    public void setFirstPoint(Point2D.Double firstPoint) {
        this.firstPoint = firstPoint;
    }

    @Override
    public void setSecondPoint(Point2D.Double secondPoint) {
        this.secondPoint = secondPoint;
    }

    @Override
    public void setAzimuth(double angleInDegrees) {
        azimuth = angleInDegrees;
    }

    @Override
    public void setDirectionCoordinatesRotate(boolean direction) {
        this.directionRotate = direction;
    }

    @Override
    public boolean getDirectionCoordinatesRotate() {
        return directionRotate;
    }

    @Override
    public void fileDisplay() {
        setSeparator(recognizeSeparator());
        setHeaderInFileExists(recognizeHeaderExist());
        if (coordinatesObject != null) {
            String[] header = coordinatesObject.getHeader(headerExists, separator);
            ArrayList<String[]> data = (ArrayList<String[]>) coordinatesObject.getData(headerExists,
                    separator, FILE_DISPLAY_MAX_ROWS);
            fillFileViewer(header, data);

        }
    }

    public void setCoordinatesObject(FileWithCoordinates coordinatesObject) {
        this.coordinatesObject = coordinatesObject;
    }

    public void fillXYCoordinateSelector() {
        if (coordinatesObject != null) {
            String[] header = coordinatesObject.getHeader(headerExists, separator);
            fillXYCoordinateSelector(header);
            setColumnForXCoordinate(0);
            setColumnForYCoordinate(0);
            for (int i = 0; i < header.length; i++) {
                if (header[i].toLowerCase().contains(COORDINATE_X_IDENTIFIER)) {
                    setColumnForXCoordinate(i);
                }
                if (header[i].toLowerCase().contains(COORDINATE_Y_IDENTIFIER)) {
                    setColumnForYCoordinate(i);
                }
            }
        }

    }
}
