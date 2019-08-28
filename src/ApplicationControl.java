import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

class ApplicationControl {

    private MainForm mainForm;
    private File selectedFile;

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
                }
            }
        });

    }





}