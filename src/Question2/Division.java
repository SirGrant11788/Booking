package Question2;

import javax.swing.JOptionPane;

/**
 *
 * @author Grant Verheul 12001640
 */
public abstract class Division {

    protected String number;
    protected String name;

    public Division(String number, String name) {
        this.number = JOptionPane.showInputDialog(null, "Enter Plane Number");
        this.name = JOptionPane.showInputDialog(null, "Enter Name");

    }

    public abstract String display();

}
