package Question2;

import javax.swing.JOptionPane;

/**
 *
 * @author Grant Verheul 12001640
 */
public class InternationalDivision extends Division {

    private String country, language;

    public InternationalDivision(String country, String language, String number, String name) {
        super(number, name);
        this.country = JOptionPane.showInputDialog(null, "Enter Country");;
        this.language = JOptionPane.showInputDialog(null, "Enter Language of country");
    }

    @Override
    public String display() {
        return "Plane Number: " + number + "\nName: " + name + "\nCountry: " + country + "\nLanguage of country: " + language;
    }

}
