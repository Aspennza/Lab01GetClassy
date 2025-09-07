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
        ArrayList<Person> people = new ArrayList<>();

        Scanner in = new Scanner(System.in);

        File workingDirectory = new File(System.getProperty("user.dir"));

        Path file = Paths.get(workingDirectory.getPath() + "\\src\\PersonTestData.txt");

        boolean done = false;

        String csv = "";

        String ID = "";

        String firstName = "";

        String lastName = "";

        String title = "";

        int YOB = 0;

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

        try
        {
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

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