import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
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
                    fillTable(coordinatesFileReader.getListFromFile(mainForm.getSeparator()), 20);

                }
            }
        });

    }

    public void fillTable(List<String[]> list, int maxLines) {
        Object[] tableColumn = new Object[list.get(0).length];
        Object[][] data;

        if (mainForm.getHeaderExist()) {
            System.arraycopy(list.get(0), 0, tableColumn, 0, tableColumn.length);

            data = new Object[Math.min(maxLines, list.size()+1)][list.get(0).length];
            for (int i = 0; i < data.length; i++) {
                System.arraycopy(list.get(i+1), 0, data[i], 0, data[i].length);
            }
        } else {
            for (int i = 0; i < tableColumn.length; i++) {
                tableColumn[i] = i;
            }
            data = new Object[Math.min(maxLines, list.size())][list.get(0).length];
            for (int i = 0; i < data.length; i++) {
                System.arraycopy(list.get(i), 0, data[i], 0, data[i].length);
            }
        }
        mainForm.fillTable(tableColumn, data);

    }



}
