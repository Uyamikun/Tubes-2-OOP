package Map;
import java.awt.*;
import javax.swing.*;

class ComboBoxRenderer extends JLabel implements ListCellRenderer {
    public ComboBoxRenderer() {
        setOpaque(true);
        setHorizontalAlignment(CENTER);
        setVerticalAlignment(CENTER);
    }

    /*
     * This method finds the image and text corresponding
     * to the selected value and returns the label, set up
     * to display the text and image.
     */
    public Component getListCellRendererComponent(
            JList list,
            Object value,
            int index,
            boolean isSelected,
            boolean cellHasFocus) {
        //Get the selected index. (The index param isn't
        //always valid, so just use the value.)
        int selectedIndex = ((Integer)value).intValue();

        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        //Set the icon and text.  If icon was null, say so.
//        ImageIcon icon = images[selectedIndex];
//        String isi = petStrings[selectedIndex];
//        setIcon(icon);
//        if (icon != null) {
//            setText(isi);
//            setFont(list.getFont());
//        } else {
//            setUhOhText(pet + " (no image available)",
//                    list.getFont());
//        }

        return this;
    }
}
