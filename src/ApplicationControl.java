import javax.swing.*;

class ApplicationControl {

    public ApplicationControl(JFrame frame) {

        MainForm mainForm = new MainForm(frame);
        frame.setContentPane(mainForm.getRootPanel());
        frame.setVisible(true);
    }



}
