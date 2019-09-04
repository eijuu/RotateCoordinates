import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class MainForm extends Component {
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

        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; j < data.get(i).length; j++) {
                if (j != data.get(i).length - 1) {
                    showDataTextArea.append(data.get(i)[j] + "\t|\t");
                } else {
                    showDataTextArea.append(data.get(i)[j]);
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

    public void selectXCoordinate(int c) {
        coordinateXComboBox.setSelectedIndex(c);
    }

    public void selectYCoordinate(int c) {
        coordinateYComboBox.setSelectedIndex(c);
    }

}
