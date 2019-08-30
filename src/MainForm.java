import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainForm extends Component {
    private JPanel rootPanel;
    private JPanel pathPanel;
    private JTextField pathTextField;
    private JButton browsePathButton;
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

    public void setPath(String path) {
        pathTextField.setText(path);
    }

    public String getSeparator() {
        if (separatorTabRadio.isSelected()) {
            return "\t";
        } else if (separatorSpaceRadio.isSelected()) {
            return " ";
        } else if (separatorCommaRadio.isSelected()) {
            return ",";
        } if (separatorSemicolonRadio.isSelected()) {
            return ";";
        /*if (separatorAnotherRadio.isSelected())*/
        } else {
            return separatorAnotherTextField.getText();
        }
    }



    public boolean getHeaderExist() {
        return headerIsExistCheckBox.isSelected();
    }


    public JPanel getShowDataPanel() {
        return showDataPanel;
    }

    public void setTextIntoShowDataTextArea(String[] columns, ArrayList<String[]> data) {
        showDataTextArea.setText(null);

        for (int i = 0; i < columns.length; i++) {
            if (i != columns.length - 1) {
                showDataTextArea.append(columns[i] + "\t|\t");
            } else {
                showDataTextArea.append(columns[i]);
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
}
