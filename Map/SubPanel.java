package Map;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class SubPanel extends JPanel implements ItemListener {

    // label
    public JLabel l,l2,l3;

    // combobox
    public JComboBox c1,c2;

    public void itemStateChanged(ItemEvent e)
    {
        // if the state combobox is changed
        if (e.getSource() == c1) {
            l2.setText(c1.getSelectedItem() + " selected");
        }
        if (e.getSource() == c2) {
            l3.setText(c2.getSelectedItem() + " selected");
        }
    }
}
