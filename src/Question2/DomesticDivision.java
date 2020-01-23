package Question2;

import javax.swing.JOptionPane;

/**
 *
 * @author Grant verheul 12001640
 */
public class DomesticDivision extends Division {

    private String state;

    public DomesticDivision(String state, String number, String name) {
        super(number, name);
        this.state = JOptionPane.showInputDialog(null, "Enter State");;
    }

    @Override
    public String display() {
        return "Plane Number: " + number + "\nName: " + name + "\nState: " + state;
    }
}
