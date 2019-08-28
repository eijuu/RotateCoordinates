import javax.swing.*;

public class Loader {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        ApplicationControl appControl = new ApplicationControl(frame);


        frame.setTitle("Coordinates Rotate App");
        frame.setSize(800,800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }

}
