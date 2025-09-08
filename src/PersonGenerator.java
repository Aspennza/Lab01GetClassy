import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

//Need to:
//write javadoc for all programs
//create UML diagrams
//take screenshots

/**
 * Creates Person objects containing personal data, then writes them to a CSV file.
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
public class PersonGenerator
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        //This ArrayList stores Person objects created from the field data entered by the user
        ArrayList<Person> people = new ArrayList<>();

        //This Scanner takes all user input
        Scanner in = new Scanner(System.in);

        //This file holds the current directory
        File workingDirectory = new File(System.getProperty("user.dir"));

        //This Path holds the current directory concatenated with the location of the text file that will be created
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\PersonTestData.txt");

        //This boolean holds the true/false value that determines if the user continues or stops entering records
        boolean done = false;

        //This String holds the comma-separated format of the data held in each Person object
        String csv = "";

        //This String holds the 6-digit ID of each person record input by the user
        String ID = "";

        //This String holds the first name of each person input by the user
        String firstName = "";

        //This String holds the last name of each person input by the user
        String lastName = "";

        //This String holds the title (Mr., Ms., Esq., etc.) of each person input by the user
        String title = "";

        //This int holds the birth year of each person input by the user
        int YOB = 0;

        //This algorithm collects data from the user and creates Person objects containing that data until the user indicates they are done creating records
        do {
            ID = SafeInput.getNonZeroLenString(in, "Please enter the ID for your record [6 digits]");
            firstName = SafeInput.getNonZeroLenString(in, "Please enter the first name for your record");
            lastName = SafeInput.getNonZeroLenString(in, "Please enter the last name for your record");
            title = SafeInput.getNonZeroLenString(in, "Please enter the title for your record");
            YOB = SafeInput.getRangedInt(in, "Please enter the year of birth for your record [4 digits]", 1940, 2010);

            Person person = new Person(ID, firstName, lastName, title, YOB);
            people.add(person);

            done = SafeInput.getYNConfirm(in, "Have you finished entering records?");
        }while(!done);

        //This algorithm checks for potential exceptions thrown by the file writer
        try
        {
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            //This algorithm takes each Person object, converts it to a CSV String, and writes it to a file
            for(Person p : people)
            {
                csv = p.toCSV();

                writer.write(csv, 0, csv.length());
                writer.newLine();
            }
            writer.close();
            System.out.println("\nData file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}