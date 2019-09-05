import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
import java.io.File;
import java.util.ArrayList;

class FormController {

    private MainForm mainForm;
    private FileWithCoordinates coordinatesFile;

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
                mainForm.setPathToFile(selectedFile.getPath());

                mainForm.setPathToPathTextField(mainForm.getPathToFile());
                coordinatesFile = new FileWithCoordinates(mainForm.getPathToFile());
                mainForm.setCoordinatesObject(coordinatesFile);

                mainForm.fileDisplay();
                mainForm.fillXYCoordinateSelector();
            }
        });

        mainForm.getPathTextField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    mainForm.setPathToFile(mainForm.getPathTextField().getText());

                    if (!(new File(mainForm.getPathToFile())).exists()) {
                        JOptionPane.showMessageDialog(frame, "Not exists");
                    } else System.out.println(false);
                }
            }

        });

        mainForm.getSeparatorTabRadio().addActionListener(actionEvent -> {
            mainForm.getSeparatorAnotherTextField().setEnabled(false);
            mainForm.setSeparator(mainForm.recognizeSeparator());
            mainForm.fileDisplay();
            mainForm.fillXYCoordinateSelector();

        });
        mainForm.getSeparatorCommaRadio().addActionListener(actionEvent -> {
            mainForm.getSeparatorAnotherTextField().setEnabled(false);
            mainForm.setSeparator(mainForm.recognizeSeparator());
            mainForm.fileDisplay();
            mainForm.fillXYCoordinateSelector();

        });
        mainForm.getSeparatorSemicolonRadio().addActionListener(actionEvent -> {
            mainForm.getSeparatorAnotherTextField().setEnabled(false);
            mainForm.setSeparator(mainForm.recognizeSeparator());
            mainForm.fileDisplay();
            mainForm.fillXYCoordinateSelector();

        });
        mainForm.getSeparatorSpaceRadio().addActionListener(actionEvent -> {
            mainForm.getSeparatorAnotherTextField().setEnabled(false);
            mainForm.setSeparator(mainForm.recognizeSeparator());
            mainForm.fileDisplay();
            mainForm.fillXYCoordinateSelector();

        });
        mainForm.getSeparatorAnotherRadio().addActionListener(actionEvent -> {
            mainForm.getSeparatorAnotherTextField().setEnabled(true);
            mainForm.setSeparator(mainForm.recognizeSeparator());
            mainForm.getSeparatorAnotherTextField().requestFocus();
            mainForm.fileDisplay();
            mainForm.fillXYCoordinateSelector();
        });
        mainForm.getSeparatorAnotherTextField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                mainForm.setSeparator(mainForm.recognizeSeparator());
                mainForm.fileDisplay();
                mainForm.fillXYCoordinateSelector();
            }
        });
        mainForm.getHeaderIsExistCheckBox().addActionListener(actionEvent -> {
            mainForm.setHeaderInFileExists(mainForm.recognizeHeaderExist());
            mainForm.fileDisplay();
            mainForm.fillXYCoordinateSelector();
        });

    }



}
