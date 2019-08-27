import javax.swing.*;

public class MainForm {
    private JPanel rootPanel;
    private JPanel northPanel;
    private JPanel pathPanel;
    private JTextField textField1;
    private JButton browsePathButton;
    private JComboBox selectSeparatorComboBox;
    private JComboBox coordinateXComboBox;
    private JComboBox coordinateYComboBox;
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
    private JPanel centerPanel;
    private JTable showFileTable;

    public MainForm(JFrame frame) {
//        pathPanel.setBorder(BorderFactory.createTitledBorder("Specify the path to the file"));
//        browsePathButton.setText("Browse...");
//        selectSeparatorPanel.setBorder(BorderFactory.createTitledBorder("Select separator"));
//
//        selectColumnXYPanel.setBorder(BorderFactory.createTitledBorder("Select XY coordinates"));
//        coordinateXPanel.setBorder(BorderFactory.createTitledBorder("X coordinate"));
//        coordinateYPanel.setBorder(BorderFactory.createTitledBorder("Y coordinate"));
//
//        headerExistPanel.setBorder(BorderFactory.createTitledBorder("The file has headers"));
//        headerIsExistCheckBox.setText("Exist");
//
//        firstPointPanel.setBorder(BorderFactory.createTitledBorder("First point"));
//        firstPointCoordXPanel.setBorder(BorderFactory.createTitledBorder("X-1"));
//        firstPointCoordYPanel.setBorder(BorderFactory.createTitledBorder("Y-1"));
//        secondPointPanel.setBorder(BorderFactory.createTitledBorder("Second point"));
//        secondPointCoordXPanel.setBorder(BorderFactory.createTitledBorder("X-2"));
//        secondPointCoordYPanel.setBorder(BorderFactory.createTitledBorder("Y-2"));
//
//        singlePointPanel.setBorder(BorderFactory.createTitledBorder("Single point"));
//        singlePointCoordXPanel.setBorder(BorderFactory.createTitledBorder("X"));
//        singlePointCoordYPanel.setBorder(BorderFactory.createTitledBorder("Y"));
//        azimuthPanel.setBorder(BorderFactory.createTitledBorder("Azimuth (in degrees)"));
//
//        chooseDirection.setBorder(BorderFactory.
//                createTitledBorder("Choose direction coordinates rotate"));
//        absToRelRadio.setText("Absolute to relative");
//        relToAbsRadio.setText("Relative to absolute");
//
//        controlPanel.setBorder(BorderFactory.createTitledBorder("Control panel"));
//        calculateButton.setText("Calculate");
//        saveButton.setText("Save to...");
//
//        centerPanel.setBorder(BorderFactory.createTitledBorder("Show table"));
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}
