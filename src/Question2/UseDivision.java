package Question2;

import static Question1.ReportInformation.menuOption;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.APPEND;
import javax.swing.JOptionPane;

/**
 *
 * @author Grant Verheul 12001640
 */
public class UseDivision {

    public static void main(String[] args) throws IOException {
        String s = "",
                stop = ".";
        String planeNum, name, lang, state, country;
        int trips = Integer.parseInt(JOptionPane.showInputDialog(null, "How many flights?"));
        Division[] div = new Division[trips];
        int x, in, record, inte = 0, dom = 0, flight = 1;
        String[][] array = new String[trips][2];

        for (x = 0; x < div.length; x++) {
            in = Integer.parseInt(JOptionPane.showInputDialog(null, "is flight " + flight + " a International (1) or Domestic (2)"));
            if (in == 1) {

                div[x] = new InternationalDivision(" ", " ", " ", " ");

                array[inte][0] = "" + div[x].display() + ".\n";

                inte++;
            }
            if (in == 2) {

                div[x] = new DomesticDivision(" ", " ", " ");

                array[dom][1] = "" + div[x].display() + ".\n";

                dom++;
            }
            flight++;
        }
        //save to file
        OutputStream output = null;
        Path filePath = Paths.get("F:\\flights.txt");
        try {
            output = new BufferedOutputStream(Files.newOutputStream(filePath, APPEND));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
            for (int q = 0; q < inte; q++) {
                s = s + array[q][0] + stop;
            }
            for (int w = 0; w < dom; w++) {
                s = s + array[w][0] + stop;
            }
            writer.write(s, 0, s.length());
            writer.newLine();
            writer.close();

        } catch (Exception e) {
            System.out.println("Message: " + e);
        }

        //
//        StringBuilder builder = new StringBuilder();
//        for (int i = 0; i < array.length; i++)//for each row
//        {
//            for (int j = 0; j < array.length; j++)//for each column
//            {
//                builder.append(array[i][j] + "");//append to the output string
//                if (j < array.length - 1)//if this is not the last row element
//                {
//                    builder.append(",");//then add comma 
//                }
//            }
//            builder.append("\n");//append new line at the end of the row
//        }
//        BufferedWriter writer = new BufferedWriter(new FileWriter("/f:/flights.txt"));
//        writer.write(builder.toString());//save the string 
//        writer.close();
        record = Integer.parseInt(JOptionPane.showInputDialog(null, "Press one (1) to view International flights, two (2) to view Domestic flights, three (3) to view all flights any other key to exit"));
        switch (record) {
            case 1:
                for (int a = 0; a < inte; a++) {
                    System.out.println(array[a][0]);
                }
                break;
            case 2:
                for (int a = 0; a < dom; a++) {
                    System.out.println(array[a][1]);
                }
                break;
            case 3:
                //read from file

                String[] arrayRec = new String[5];
                InputStream input = null;
                try {
                    input = new BufferedInputStream(Files.newInputStream(filePath));
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                    s = reader.readLine();

                    while (s != null) {
                        arrayRec = s.split(stop);

                        planeNum = arrayRec[0];
                        name = arrayRec[1];
                        lang = arrayRec[2];
                        state = arrayRec[3];
                        country = arrayRec[4];

                        System.out.println(planeNum + "\n " + name + "\n " + lang + "\nS " + state + "\n+" + country + "\n\n");

                        s = reader.readLine();
                    }
                    reader.close();
                } catch (Exception e) {
                    System.out.println("Message: " + e);
                }

//                int[][] text = new int[10][10];
//                BufferedReader reader = new BufferedReader(new FileReader("/f:/flights.txt"));
//                String line = "";
//                int row = 0;
//                while ((line = reader.readLine()) != null) {
//                    String[] cols = line.split(".");
//                    int col = 0;
//                    for (String c : cols) {
//                        text[row][col] = Integer.parseInt(c);
//                        col++;
//                        System.out.println(text[row][col]);
//                        System.out.println(array[row][col]);
//                    }
//                    row++;
//                }
//                reader.close();
                for (int b = 0; b < 2; b++) {
                    for (int a = 0; a < trips; a++) {

                        System.out.println(array[a][b]);
                    }
                }
                break;
            default:
                System.exit(0);

        }

    }
}
