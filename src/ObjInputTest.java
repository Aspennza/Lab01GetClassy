//Need to:
//write javadoc for all programs
//create UML diagrams
//take screenshots

/**
 * A class for testing the functionality of the SafeInputObj class
 * @author Zoe Aspenns aspennza@mail.uc.edu
 */
public class ObjInputTest
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        //Creates a SafeInputObj that contains a scanner and comes packaged with input checking functions
        SafeInputObj sio = new SafeInputObj();

        //A String for containing the output of getNonZeroLenString
        String testString = "";
        testString = sio.getNonZeroLenString("Please enter a string");
        System.out.println("Example string: " + testString);

        //An int for containing the output of getRangedInt
        int rangedInt = 0;
        rangedInt = sio.getRangedInt("Please enter an integer", 1, 10);
        System.out.println("Example ranged integer: " + rangedInt);

        //An int for containing the output of getInt
        int testInt = 0;
        testInt = sio.getInt("Please enter an integer");
        System.out.println("Example integer: " + testInt);

        //A double for containing the output of getRangedDouble
        double rangedDouble = 0.00;
        rangedDouble = sio.getRangedDouble("Please enter a double", 1, 10);
        System.out.println("Example ranged double: " + rangedDouble);

        //A double for containing the output of getDouble
        double testDouble = 0.00;
        testDouble = sio.getDouble("Please enter a double");
        System.out.println("Example double: " + testDouble);

        //A boolean for containing the output of getYNConfirm
        boolean testBoolean = false;
        testBoolean = sio.getYNConfirm("Please enter either");
        System.out.println("Example boolean: " + testBoolean);

        //A String for containing the output of getRegExString
        String regEx = "";
        regEx = sio.getRegExString("Please enter your email address", "[a-zA-Z0-9]+@[a-zA-Z0-9]+[\\.][a-z]+");
        System.out.println("Example regEx: " + regEx);
    }
}
