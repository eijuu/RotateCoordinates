import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
import java.io.File;
import java.util.ArrayList;

class FormController implements ControllerInterface {

    private final int FILE_DISPLAY_MAX_ROWS = 20;
    private final String COORDINATE_X_IDENTIFIER = "x";
    private final String COORDINATE_Y_IDENTIFIER = "y";

    private MainForm mainForm;

    private FileWithCoordinates coordinatesFile;

    private String separator;
    private boolean headerExists;
    private String pathToFile;
    private int columnXCoordinate;
    private int columnYCoordinate;

    private Point2D firstPoint;
    private Point2D secondPoint;
    private double azimuth;
    private boolean directionRotate;

    public FormController() {
        JFrame frame = new JFrame();
        frame.setTitle("Coordinates Rotate App");
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mainForm = new MainForm(frame);
        frame.setContentPane(mainForm.getRootPanel());
        frame.setVisible(true);


        mainForm.getBrowsePathButton().addActionListener(actionEvent -> {
            JFileChooser fileChooser = new JFileChooser(
                    "G:\\Program Files\\OneDrive\\!Study_SkillBox\\tess.txt");
            if (fileChooser.showOpenDialog(mainForm) == JFileChooser.APPROVE_OPTION) {

                File selectedFile = fileChooser.getSelectedFile();
                setPathToFile(selectedFile.getPath());

                mainForm.setPathToPathTextField(getPathToFile());
                coordinatesFile = new FileWithCoordinates(getPathToFile());
                setSeparator(mainForm.recognizeSeparator());
                setHeaderInFileExists(mainForm.recognizeHeaderExist());
                fileDisplay();
                fillXYCoordinateSelector();

            }
        });

        mainForm.getPathTextField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    setPathToFile(mainForm.getPathTextField().getText());

                    if (!(new File(getPathToFile())).exists()) {
                        JOptionPane.showMessageDialog(frame, "Eggs are not supposed to be green.");
                    } else System.out.println(false);
                }
            }

        });

        mainForm.getSeparatorTabRadio().addActionListener(actionEvent -> {
            mainForm.getSeparatorAnotherTextField().setEnabled(false);
            setSeparator(mainForm.recognizeSeparator());
            fileDisplay();
            fillXYCoordinateSelector();

        });
        mainForm.getSeparatorCommaRadio().addActionListener(actionEvent -> {
            mainForm.getSeparatorAnotherTextField().setEnabled(false);
            setSeparator(mainForm.recognizeSeparator());
            fileDisplay();
            fillXYCoordinateSelector();

        });
        mainForm.getSeparatorSemicolonRadio().addActionListener(actionEvent -> {
            mainForm.getSeparatorAnotherTextField().setEnabled(false);
            setSeparator(mainForm.recognizeSeparator());
            fileDisplay();
            fillXYCoordinateSelector();

        });
        mainForm.getSeparatorSpaceRadio().addActionListener(actionEvent -> {
            mainForm.getSeparatorAnotherTextField().setEnabled(false);
            setSeparator(mainForm.recognizeSeparator());
            fileDisplay();
            fillXYCoordinateSelector();

        });
        mainForm.getSeparatorAnotherRadio().addActionListener(actionEvent -> {
            mainForm.getSeparatorAnotherTextField().setEnabled(true);
            setSeparator(mainForm.recognizeSeparator());
            mainForm.getSeparatorAnotherTextField().requestFocus();
            fileDisplay();
            fillXYCoordinateSelector();
        });
        mainForm.getSeparatorAnotherTextField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                setSeparator(mainForm.recognizeSeparator());
                fileDisplay();
                fillXYCoordinateSelector();
            }
        });
        mainForm.getHeaderIsExistCheckBox().addActionListener(actionEvent -> {
            setHeaderInFileExists(mainForm.recognizeHeaderExist());
            fileDisplay();
            fillXYCoordinateSelector();
        });

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
            mainForm.selectXCoordinate(column);
            columnXCoordinate = column;
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean setColumnForYCoordinate(int column) {
        try {
            mainForm.selectYCoordinate(column);
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
        directionRotate = direction;
    }

    @Override
    public boolean getDirectionCoordinatesRotate() {
        return directionRotate;
    }

    @Override
    public void fileDisplay() {
        if (coordinatesFile != null) {
            String[] header = coordinatesFile.getHeader(headerExists, separator);
            ArrayList<String[]> data = (ArrayList<String[]>) coordinatesFile.getData(headerExists,
                    separator, FILE_DISPLAY_MAX_ROWS);
            mainForm.fillFileViewer(header, data);
        }
    }

    public void fillXYCoordinateSelector() {
        if (coordinatesFile != null) {
            String[] header = coordinatesFile.getHeader(headerExists, separator);
            mainForm.fillXYCoordinateSelector(header);
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
