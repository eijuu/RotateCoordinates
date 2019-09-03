import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;

class FormController {

    private MainForm mainForm;
    private File selectedFile;
    private FileWithCoordinates coordinatesFile;

    public FormController(JFrame frame) {

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
                    coordinatesFile = new FileWithCoordinates(selectedFile.getPath());
                    fillFileViewer();
                }
            }
        });

        mainForm.getSeparatorTabRadio().addActionListener(actionEvent -> {
            mainForm.getSeparatorAnotherTextField().setEnabled(false);
            if (coordinatesFile != null) {
                fillFileViewer();
            }
        });
        mainForm.getSeparatorCommaRadio().addActionListener(actionEvent -> {
            mainForm.getSeparatorAnotherTextField().setEnabled(false);
            if (coordinatesFile != null) {
                fillFileViewer();
            }
        });
        mainForm.getSeparatorSemicolonRadio().addActionListener(actionEvent -> {
            mainForm.getSeparatorAnotherTextField().setEnabled(false);
            if (coordinatesFile != null) {
                fillFileViewer();
            }
        });
        mainForm.getSeparatorSpaceRadio().addActionListener(actionEvent -> {
            mainForm.getSeparatorAnotherTextField().setEnabled(false);
            if (coordinatesFile != null) {
                fillFileViewer();
            }
        });
        mainForm.getSeparatorAnotherRadio().addActionListener(actionEvent -> {
            mainForm.getSeparatorAnotherTextField().setEnabled(true);
            mainForm.getSeparatorAnotherTextField().requestFocus();
            if (coordinatesFile != null) {
                fillFileViewer();
            }
        });
        mainForm.getSeparatorAnotherTextField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (coordinatesFile != null) {
                    fillFileViewer();
                }
            }
        });

    }

    private void fillFileViewer() {
        String[] columns = coordinatesFile.getColumns(mainForm.getHeaderExist(), mainForm.getSeparator());
        ArrayList<String[]> data = (ArrayList<String[]>) coordinatesFile.getData(mainForm.getHeaderExist(),
                mainForm.getSeparator(), 20);
        mainForm.fillFileViewer(columns, data);
    }


}
