import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class PrimeForm {
    private JPanel mainPanel;
    private JButton collapse;
    private JTextArea textSurname;
    private JPanel FIO;
    private JPanel surname_text_1;
    private JPanel Name_form;
    private JPanel formSurname1;
    private JPanel for_Button;
    private JPanel for_Button_1;
    private JPanel for_Button_2;
    private JPanel from_Button_border;
    private JPanel middle_name_1;
    private JPanel middle_name_2;
    private JPanel middle_name_2_1;
    private JPanel middle_name_2_2;
    private JTextArea textMiddleName;
    private JPanel middle_name_3;
    private JLabel form_middle_name;
    private JTextArea textName;
    private JPanel forTextName_1;
    private JPanel forTextName2;
    private JPanel forFormName_1;
    private JPanel forFormName_2;
    private JLabel formName;
    private JPanel surname_text_2;
    private JPanel formSurname2;
    private JLabel formSurname;
    private static Main objectFirst;
    private String namePersonString;
    private String textSurnameString;
    private String textMiddleNameString;
    private String concatFIO = "";
    String nameFormat = "^[ЁА-ЯA-Z][а-яёa-z-]*$";

    public static Main getObjectFirst() {
        return objectFirst;
    }

    public void setObjectFirst(Main objectFirst) {
        this.objectFirst = objectFirst;
    }

    public PrimeForm() {

        collapse.addActionListener(new Action() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }

            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            /*@Override
            public void actionPerformed(ActionEvent e) {
                namePersonString = textSurname.getText();
                 textSurnameString = textName.getText();
                 textMiddleNameString = textMiddleName.getText();
                 if(namePersonString != null && textSurnameString != null){
                if(namePersonString.matches(nameFormat) && textSurnameString.matches(nameFormat) && (
                        textMiddleNameString.matches(nameFormat) || textMiddleNameString.equals("")
                        )) {
                    concatFIO = concatFIO.concat(namePersonString).concat(" ").concat(textSurnameString)
                            .concat(" ").concat(textMiddleNameString);
                    Final frame = new Final(concatFIO);
                    frame.setVisible(true);
                    objectFirst.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Введен недопустимый символ",
                            "Диалог сообщений", JOptionPane.WARNING_MESSAGE);
                }
                 }
                else {
                    JOptionPane.showMessageDialog(null, "Заполните поля Имя Фамилия",
                            "Диалог сообщений", JOptionPane.WARNING_MESSAGE);
                }
            }*/
        });
    }

    public JPanel getMainPanel(){
        return mainPanel;
    }

    public JPanel getMainPanel(ArrayList<String> fIOText){

        textSurname.setText(fIOText.get(0));
        textName.setText(fIOText.get(1));
        if(fIOText.size() == 3) {
            textMiddleName.setText(fIOText.get(2));
        }
        return mainPanel;
    }
}
