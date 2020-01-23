package Question1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import static java.nio.file.AccessMode.EXECUTE;
import static java.nio.file.AccessMode.READ;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;
import java.util.Scanner;
import static javafx.scene.input.KeyCode.F;
import javax.swing.JOptionPane;

/**
 *
 * @author grant verheul 12001640
 */
public class ReportInformation {

    boolean format = false;
    String courseName;
    int menuStart;
    int menu;
    int number;
    String fName;
    String lName;
    String gender;
    String date;
    String email;
    String address;
    String suburb;
    String town;
    int postal;
    int course;
    String ID;
    String matric;
    String res;
    String s = "";
    String comma = ";";
    String m;
    int contact;
    String lineToRemove, currentLine;

    public ReportInformation() throws IOException {

        Scanner inputDevice = new Scanner(System.in);
        System.out.println("BRIGHT FUTURE TECHNOLOGIES APPLICATION\n******************************************");
        System.out.println("Enter (1) to launch menue or nay other key to exit");
        this.menuStart = inputDevice.nextInt();
        if (menuStart == 1) {

            menuOption(lineToRemove, currentLine, m, s, comma, courseName, format, menu, number, fName, lName, gender, contact, date, email, address, suburb, town, postal, course, ID, matric, res);
        } else {
            System.exit(0);
        }
    }

    public static void menuOption(String lineToRemove, String currentLine, String m, String s, String comma, String courseName, boolean format, int menu, int number, String fName, String lName, String gender, int contact, String date, String email, String address, String suburb, String town, int postal, int course, String ID, String matric, String res) throws IOException {
        Scanner inputDevice = new Scanner(System.in);
        System.out.println("Please select one of the following menu items:\n(1) Capture a new student.\n(2) Search for a new student.\n(3) Update a student.\n(4) Delete a student.\n(5) Print report.");
        menu = inputDevice.nextInt();
        if (menu >= 1 && menu <= 5) {
            switch (menu) {
                case 1:
                    save(lineToRemove, currentLine, m, s, comma, courseName, format, menu, number, fName, lName, gender, contact, date, email, address, suburb, town, postal, course, ID, matric, res);
                    break;
                case 2:
                    search(lineToRemove, currentLine, m, s, comma, courseName, format, menu, number, fName, lName, gender, contact, date, email, address, suburb, town, postal, course, ID, matric, res);
                    break;
                case 3:
                    update(lineToRemove, currentLine, m, s, comma, courseName, format, menu, number, fName, lName, gender, contact, date, email, address, suburb, town, postal, course, ID, matric, res);
                    break;
                case 4:
                    delete(lineToRemove, currentLine, m, s, comma, courseName, format, menu, number, fName, lName, gender, contact, date, email, address, suburb, town, postal, course, ID, matric, res);
                    break;
                case 5:
                    print(m, s, comma, courseName, format, menu, number, fName, lName, gender, contact, date, email, address, suburb, town, postal, course, ID, matric, res);
                    break;
            }//Note to self, could also use default:
        } else {
            System.out.println("Incorrect menu option.\nTry again");
            menuOption(lineToRemove, currentLine, m, s, comma, courseName, format, menu, number, fName, lName, gender, contact, date, email, address, suburb, town, postal, course, ID, matric, res);
        }
    }

    public static void save(String lineToRemove, String currentLine, String m, String s, String comma, String courseName, boolean format, int menu, int number, String fName, String lName, String gender, int contact, String date, String email, String address, String suburb, String town, int postal, int course, String ID, String matric, String res) throws IOException {
        Scanner inputDevice = new Scanner(System.in);
        System.out.println("CAPTURE A NEW STUDENT");
        System.out.println("***************************");
        System.out.print("Enter student number: ");
        number = inputDevice.nextInt();

        inputDevice.nextLine();
        System.out.print("Enter student first name: ");
        fName = inputDevice.nextLine();

        System.out.print("Enter student surename: ");
        lName = inputDevice.nextLine();

        System.out.print("Indicate the student gender. Enter (1) for male or any other key for female. ");
        gender = inputDevice.nextLine();
        if (gender.equals("1")) {
            gender = "male";
        } else {
            gender = "female";
        }
        while (!format) {
            System.out.print("Please enter the student date of birth(dd/mm/yyyy): ");
            date = inputDevice.nextLine();
            if ((date.charAt(2) == '/') && (date.charAt(5) == '/') && (date.length() == 10)) {
                if (Integer.parseInt(date.substring(3, 5)) < 13) {
                    format = true;
                } else {
                    System.out.println("Your day and month is incorrect");
                }
            } else {
                System.out.println("Incorrect date format.\nPlease try again");
            }

        }
        System.out.print("Please enter the student digit contact number: ");
        contact = inputDevice.nextInt();

        inputDevice.nextLine();
        System.out.print("Please enter the student email address: ");
        email = inputDevice.nextLine();

        System.out.print("Please enter the student street address: ");
        address = inputDevice.nextLine();

        System.out.print("Please enter the suburb: ");
        suburb = inputDevice.nextLine();

        System.out.print("Please enter the town: ");
        town = inputDevice.nextLine();

        System.out.print("Please enter the postal code: ");
        postal = inputDevice.nextInt();
        do {
            inputDevice.nextLine();
            System.out.print("Select the course the student is enrolled in.\n(1) Diploma in Software Development\n(2) Diploma in Network Communication\n(3) Diploma in Web Develpment\n(4) BCOM Information Management\n");
            course = inputDevice.nextInt();
            if (!(course > 0 && course < 5)) {
                System.out.println("Incorrect choice.\nTry again");
            } else {
                switch (course) {
                    case 1:
                        courseName = "Diploma in Software Development";
                        break;
                    case 2:
                        courseName = "Diploma in Network Communication";
                        break;
                    case 3:
                        courseName = "Diploma in Web Develpment";
                        break;
                    case 4:
                        courseName = "BCOM Information Management";
                        break;

                }
            }

        } while (!(course > 0 && course < 5));
        inputDevice.nextLine();
        System.out.print("Has the student submitted an ID document? (y) yes or any other key for no: ");
        ID = inputDevice.nextLine();
        if (ID.equalsIgnoreCase("y")) {
            ID = "yes";
        } else {
            ID = "no";
        }

        System.out.print("Has the student submitted a matric certificate? (y) yes or any other key for no: ");
        matric = inputDevice.nextLine();
        matric = inputDevice.nextLine();
        if (matric.equalsIgnoreCase("y")) {
            matric = "yes";
        } else {
            matric = "no";
        }

        System.out.print("Has the student submitted proof of residence? (y) yes or any other key for no: ");
        res = inputDevice.nextLine();
        res = inputDevice.nextLine();
        if (res.equalsIgnoreCase("y")) {
            res = "yes";
        } else {
            res = "no";
        }

        //save to file
        OutputStream output = null;
        Path filePath = Paths.get("F:\\students.txt");
        try {
            output = new BufferedOutputStream(Files.newOutputStream(filePath, APPEND));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
            s = number + comma + fName + comma + lName + comma + gender + comma + date + comma + contact + comma + email + comma + address + comma + suburb + comma + town + comma + postal + comma + courseName + comma + ID + comma + matric + comma + res;
            writer.write(s, 0, s.length());
            writer.newLine();
            writer.close();
            System.out.println("Student details has been saved succesfully!!!");
        } catch (Exception e) {
            System.out.println("Message: " + e);
        }
        System.out.println("Enter (1) to launch menu or any other key to exit");
        m = inputDevice.nextLine();
        if (m.equals("1")) {
            menuOption(lineToRemove, currentLine, m, s, comma, courseName, format, menu, number, fName, lName, gender, contact, date, email, address, suburb, town, postal, course, ID, matric, res);
        } else {
            System.exit(0);
        }
    }

    public static void search(String lineToRemove, String currentLine, String m, String s, String comma, String courseName, boolean format, int menu, int number, String fName, String lName, String gender, int contact, String date, String email, String address, String suburb, String town, int postal, int course, String ID, String matric, String res) {
        Scanner inputDevice = new Scanner(System.in);
        String searchC;
        int custNbrS;

        String[] arrayRec = new String[15];
        InputStream input = null;
        Path filePath = Paths.get("F:\\students.txt"); //create a file path
        try {
            input = new BufferedInputStream(Files.newInputStream(filePath));
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            s = reader.readLine();
            System.out.print("Please enter the student number to search for: ");
            searchC = inputDevice.nextLine();
            custNbrS = Integer.parseInt(searchC);
            while (s != null) {
                arrayRec = s.split(comma);

                number = Integer.parseInt(arrayRec[0]);
                fName = arrayRec[1];
                lName = arrayRec[2];
                gender = arrayRec[3];
                date = arrayRec[4];
                contact = Integer.parseInt(arrayRec[5]);
                email = arrayRec[6];
                address = arrayRec[7];
                suburb = arrayRec[8];
                town = arrayRec[9];
                postal = Integer.parseInt(arrayRec[10]);
                courseName = arrayRec[11];
                //
                ID = arrayRec[12];
                matric = arrayRec[13];
                res = arrayRec[14];
                //
                if (number == number) {
                    System.out.println("*****************************************************************\nSTUDENT DETAILS\n*****************************************************************\n"
                            + "STUDENT NUMBER: " + number + "\t\tDATE OF BIRTH: " + date + "\nFIRST NAME: " + fName + "\t\tCONTACT NUMBER: " + contact + "\nSURNASME: " + lName + "\t\tEMAIL: " + email + "\nGENDER: " + gender + "\t\tCOURSE :" + course + ""
                            + "\n*****************************************************************\nSTUDENT ADDRESS DETAILS\n*****************************************************************\n"
                            + "STREET: \t" + address + "\nSUBURB: \t" + suburb + "\nTOWN: \t" + town + "\nPCODE: \t" + postal);
                    break;
                } else {
                    System.out.println("No valid student found");
                    menuOption(lineToRemove, currentLine, m, s, comma, courseName, format, menu, number, fName, lName, gender, contact, date, email, address, suburb, town, postal, course, ID, matric, res);
                }
                s = reader.readLine();
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Message: " + e);
        }

    }

    public static void delete(String lineToRemove, String currentLine, String m, String s, String comma, String courseName, boolean format, int menu, int number, String fName, String lName, String gender, int contact, String date, String email, String address, String suburb, String town, int postal, int course, String ID, String matric, String res) throws IOException {
        Scanner inputDevice = new Scanner(System.in);
        String searchC;
        int custNbrS;

////        String[] arrayRec = new String[15];
////        InputStream input = null;
////        Path filePath = Paths.get("F:\\students.txt"); //create a file path
////        try {
////            input = new BufferedInputStream(Files.newInputStream(filePath));
////            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
////            s = reader.readLine();
////            System.out.print("Please enter the student number to delete: ");
////            searchC = inputDevice.nextLine();
////            custNbrS = Integer.parseInt(searchC);
////            System.out.println("Are you sure you want to delete student " + searchC + " from the system? Yes (y) to delete.");
////            String del = inputDevice.nextLine();
////            if (!(del.equalsIgnoreCase("y"))) {
////                menuOption(m, s, comma, courseName, format, menu, number, fName, lName, gender, contact, date, email, address, suburb, town, postal, course, ID, matric, res);
////            }
////            while (s != null) {
////                arrayRec = s.split(comma);
////
////                number = Integer.parseInt(arrayRec[0]);
////                fName = arrayRec[1];
////                lName = arrayRec[2];
////                gender = arrayRec[3];
////                date = arrayRec[4];
////                contact = Integer.parseInt(arrayRec[5]);
////                email = arrayRec[6];
////                address = arrayRec[7];
////                suburb = arrayRec[8];
////                town = arrayRec[9];
////                postal = Integer.parseInt(arrayRec[10]);
////                courseName = arrayRec[11];
////                ID = arrayRec[12];
////                matric = arrayRec[13];
////                res = arrayRec[14];
////                if (number == number) {
////                    //delete
////                    number = 0;
////                    fName = null;
////                    lName = null;
////                    gender = null;
////                    date = null;
////                    contact = 0;
////                    email = null;
////                    address = null;
////                    suburb = null;
////                    town = null;
////                    postal = 0;
////                    courseName = null;
////                    ID = null;
////                    matric = null;
////                    res = null;
////                    OutputStream output = null;
////                    try {
////                        output = new BufferedOutputStream(Files.newOutputStream(filePath, APPEND));
////                        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
////                        s = number + comma + fName + comma + lName + comma + gender + comma + date + comma + contact + comma + email + comma + address + comma + suburb + comma + town + comma + postal + comma + courseName + comma + ID + comma + matric + comma + res;
////                        writer.write(s, 0, s.length());
////                        writer.newLine();
////                        writer.close();
////                    } catch (Exception e) {
////                        System.out.println("Message: " + e);
////                    }
////                    //
////                    System.out.println("Student has been deleted successfully!!!");
////                    break;
////                } else {
////                    System.out.println("No valid student found");
////                    menuOption(m, s, comma, courseName, format, menu, number, fName, lName, gender, contact, date, email, address, suburb, town, postal, course, ID, matric, res);
////                }
////                s = reader.readLine();
////            }
        //edit for delete line
        File inputFile = new File("F:\\students.txt");
        File tempFile = new File("F:\\tempstudents.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        System.out.print("Please enter the student number to delete: ");
        searchC = inputDevice.nextLine();
        custNbrS = Integer.parseInt(searchC);
        System.out.println("Are you sure you want to delete student " + searchC + " from the system? Yes (y) to delete.");
        String del = inputDevice.nextLine();
        if (!(del.equalsIgnoreCase("y"))) {
            menuOption(lineToRemove, currentLine, m, s, comma, courseName, format, menu, number, fName, lName, gender, contact, date, email, address, suburb, town, postal, course, ID, matric, res);
        }
        lineToRemove = searchC;

        while ((currentLine = reader.readLine()) != null) {
            // trim newline when comparing with lineToRemove
            String trimmedLine = currentLine.trim();
            if (trimmedLine.equals(lineToRemove)) {
                continue;
            }
            writer.write(currentLine + System.getProperty("line.separator"));
        }
        writer.close();
        reader.close();
        boolean successful = tempFile.renameTo(inputFile);
        System.out.println("Student has been deleted successfully!!!");

        System.out.println("Enter (1) to launch men or any other key to exit");
        m = inputDevice.nextLine();
        if (m.equals("1")) {
            menuOption(lineToRemove, currentLine, m, s, comma, courseName, format, menu, number, fName, lName, gender, contact, date, email, address, suburb, town, postal, course, ID, matric, res);
        } else {
            System.exit(0);
        }
        reader.close();
//        } catch (Exception e) {
//            System.out.println("Message: " + e);
//        }
    }

    public static void update(String lineToRemove, String currentLine, String m, String s, String comma, String courseName, boolean format, int menu, int number, String fName, String lName, String gender, int contact, String date, String email, String address, String suburb, String town, int postal, int course, String ID, String matric, String res) {
        Scanner inputDevice = new Scanner(System.in);
        String searchC;
        int custNbrS;

        String[] arrayRec = new String[15];
        InputStream input = null;
        Path filePath = Paths.get("F:\\students.txt"); //create a file path
        try {
            input = new BufferedInputStream(Files.newInputStream(filePath));
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            s = reader.readLine();
            System.out.print("Please enter the student number to update: ");
            searchC = inputDevice.nextLine();
            custNbrS = Integer.parseInt(searchC);
            while (s != null) {
                arrayRec = s.split(comma);

                number = Integer.parseInt(arrayRec[0]);
                fName = arrayRec[1];
                lName = arrayRec[2];
                gender = arrayRec[3];
                date = arrayRec[4];
                contact = Integer.parseInt(arrayRec[5]);
                email = arrayRec[6];
                address = arrayRec[7];
                suburb = arrayRec[8];
                town = arrayRec[9];
                postal = Integer.parseInt(arrayRec[10]);
                courseName = arrayRec[11];
                //
                ID = arrayRec[12];
                matric = arrayRec[13];
                res = arrayRec[14];
                //
                if (number == number) {
                    System.out.print("Update the student ID document status ? {y} Yes, (n) No: ");
                    String upID = inputDevice.nextLine();
                    if (upID.equalsIgnoreCase("y")) {
                        //update
                        ID = "yes";
                    }
                    System.out.print("Update the student matric status ? {y} Yes, (n) No: ");
                    String upMatric = inputDevice.nextLine();
                    if (upMatric.equalsIgnoreCase("y")) {
                        //update
                        matric = "yes";
                    }
                    System.out.print("Update the student proof of residence ? {y} Yes, (n) No: ");
                    String upRes = inputDevice.nextLine();
                    if (upRes.equalsIgnoreCase("y")) {
                        //update
                        res = "yes";
                    }
                    OutputStream output = null;
                    try {
                        output = new BufferedOutputStream(Files.newOutputStream(filePath, APPEND));
                        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
                        s = number + comma + fName + comma + lName + comma + gender + comma + date + comma + contact + comma + email + comma + address + comma + suburb + comma + town + comma + postal + comma + courseName + comma + ID + comma + matric + comma + res;
                        writer.write(s, 0, s.length());
                        writer.newLine();
                        writer.close();
                    } catch (Exception e) {
                        System.out.println("Message: " + e);
                    }

                    System.out.println("Student has been updated successfully!!!");
                    break;
                } else {
                    System.out.println("No valid student found");
                    menuOption(lineToRemove, currentLine, m, s, comma, courseName, format, menu, number, fName, lName, gender, contact, date, email, address, suburb, town, postal, course, ID, matric, res);
                }
                s = reader.readLine();
            }
            ////edit and a place into if's
//            String ID, Name;
//        double salary;
//        int replenish;
//
//        Scanner console = new Scanner(System.in);
//        System.out.print("Enter ID : ");
//        String pID = console.nextLine();
//        System.out.print("Enter replenish salary: ");
//        replenish = console.nextInt();
//
//        File originalFile = new File("file.txt");
//        BufferedReader br = new BufferedReader(new FileReader(originalFile));
//
//        // Construct the new file that will later be renamed to the original
//        // filename.
//        File tempFile = new File("tempfile.txt");
//        PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
//
//        String line = null;
//        // Read from the original file and write to the new
//        // unless content matches data to be removed.
//        while ((line = br.readLine()) != null) {
//
//            if (line.contains(pID)) {
//                String strCurrentSalary = line.substring(line.lastIndexOf(" "), line.length());
//                if (strCurrentSalary != null || !strCurrentSalary.trim().isEmpty()) {
//                    int replenishedSalary = Integer.parseInt(strCurrentSalary.trim()) + replenish;
//                    System.out.println("replenishedSalary : " + replenishedSalary);
//                    line = line.substring(0,line.lastIndexOf(" ")) + replenishedSalary;
//                }
//
//            }
//            pw.println(line);
//            pw.flush();
//        }
//        pw.close();
//        br.close();
//
//        // Delete the original file
//        if (!originalFile.delete()) {
//            System.out.println("Could not delete file");
//            return;
//        }
//
//        // Rename the new file to the filename the original file had.
//        if (!tempFile.renameTo(originalFile))
//            System.out.println("Could not rename file");
//
//    }
//
            System.out.println("Enter (1) to launch men or any other key to exit");
            m = inputDevice.nextLine();
            if (m.equals("1")) {
                menuOption(lineToRemove, currentLine, m, s, comma, courseName, format, menu, number, fName, lName, gender, contact, date, email, address, suburb, town, postal, course, ID, matric, res);
            } else {
                System.exit(0);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Message: " + e);
        }
    }

    public static void print(String m, String s, String comma, String courseName, boolean format, int menu, int number, String fName, String lName, String gender, int contact, String date, String email, String address, String suburb, String town, int postal, int course, String ID, String matric, String res) {

        int numStudents = 0, males = 0, females = 0, software = 0, network = 0, web = 0, info = 0;

        String[] arrayRec = new String[15];
        InputStream input = null;
        Path filePath = Paths.get("F:\\students.txt"); //create a file path
        try {
            input = new BufferedInputStream(Files.newInputStream(filePath));
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            s = reader.readLine();

            while (s != null) {
                arrayRec = s.split(comma);

                number = Integer.parseInt(arrayRec[0]);
                fName = arrayRec[1];
                lName = arrayRec[2];
                gender = arrayRec[3];
                date = arrayRec[4];
                contact = Integer.parseInt(arrayRec[5]);
                email = arrayRec[6];
                address = arrayRec[7];
                suburb = arrayRec[8];
                town = arrayRec[9];
                postal = Integer.parseInt(arrayRec[10]);
                courseName = arrayRec[11];
                ID = arrayRec[12];
                matric = arrayRec[13];
                res = arrayRec[14];

                numStudents++;
                if (gender.equals("male")) {
                    males++;
                }
                if (gender.equals("female")) {
                    females++;
                }
                if (courseName.equals("Diploma in Software Development")) {
                    software++;
                }
                if (courseName.equals("Diploma in Network Communication")) {
                    network++;
                }
                if (courseName.equals("Diploma in Web Develpment")) {
                    web++;
                }
                if (courseName.equals("BCOM Information Management")) {
                    info++;
                }

                s = reader.readLine();
            }
            System.out.println("STUDENT INFORMATION \t\t\t\t COURSE INFORMATION \n*****************************************************************************\n"
                    + "TOTAL NUMBER OF STUDENTS: " + numStudents + "\t\tTOTAL NUMBER OF SOFTWARE DEVELOPMENT STUDENTS: " + software + "\n"
                    + "TOTAL NUMBER OF MALE STUDENTS: " + males + "\t\tTOTAL NUMBER OF NETWORKING STUDENTS: " + network + "\n"
                    + "TOTAL NUMBER OF FEMALE STUDENTS: " + females + "\t\tTOTAL NUMBER OF WEB DEVELOPMENT STUDENTS: " + web + "\n"
                    + "\t\t\t\t\t\tTOTAL NUMBER OF INFORMATION MANAGEMENT STUDENTS: " + info + ""
                    + "\n*****************************************************************************");
            reader.close();
        } catch (Exception e) {
            System.out.println("Message: " + e);
        }
    }

}
