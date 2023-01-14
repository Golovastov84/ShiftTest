import javax.swing.*;

public class Main extends JFrame {
    public static void main(String[] args) {
//        System.out.println(args[0] + " - " + args[1] + " - " + args[2] + " - " + args[3] + " - " + args[4]);
//        System.out.println("Hello world!");
        Main frame = new Main();
        frame.setVisible(true);
    }
    public Main() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 300);
        PrimeForm primeForm = new PrimeForm();
        JPanel jPanel = primeForm.getMainPanel();
        primeForm.setObjectFirst(this);
        setContentPane(jPanel);
    }
}
