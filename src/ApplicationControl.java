import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

class ApplicationControl {

    private MainForm mainForm;
    private File selectedFile;
    private CoordinatesFileReader coordinatesFileReader;

    public ApplicationControl(JFrame frame) {

        mainForm = new MainForm(frame);
        frame.setContentPane(mainForm.getRootPanel());
        frame.setVisible(true);


        mainForm.getBrowsePathButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser fileChooser = new JFileChooser();
                if (fileChooser.showOpenDialog(mainForm) == JFileChooser.APPROVE_OPTION) {

                    selectedFile = fileChooser.getSelectedFile();
                    mainForm.setPath(selectedFile.getPath());
                    coordinatesFileReader = new CoordinatesFileReader(selectedFile.getPath());

                    String[] columns = coordinatesFileReader.getColumns(mainForm.getHeaderExist(), mainForm.getSeparator());
                    ArrayList<String[]> data = (ArrayList<String[]>) coordinatesFileReader.getData(mainForm.getHeaderExist(), mainForm.getSeparator(), 20);

                    mainForm.setTextIntoShowDataTextArea(columns, data);

                }
            }
        });

    }


}
