public class ObjInputTest
{
    public static void main(String[] args)
    {
        SafeInputObj sio = new SafeInputObj();

        String testString = "";
        testString = sio.getNonZeroLenString("Please enter a string");
        System.out.println("Example string: " + testString);

        int rangedInt = 0;
        rangedInt = sio.getRangedInt("Please enter an integer", 1, 10);
        System.out.println("Example ranged integer: " + rangedInt);

        int testInt = 0;
        testInt = sio.getInt("Please enter an integer");
        System.out.println("Example integer: " + testInt);

        double rangedDouble = 0.00;
        rangedDouble = sio.getRangedDouble("Please enter a double", 1, 10);
        System.out.println("Example ranged double: " + rangedDouble);

        double testDouble = 0.00;
        testDouble = sio.getDouble("Please enter a double");
        System.out.println("Example double: " + testDouble);

        boolean testBoolean = false;
        testBoolean = sio.getYNConfirm("Please enter either");
        System.out.println("Example boolean: " + testBoolean);

        String regEx = "";
        regEx = sio.getRegExString("Please enter your email address", "[a-zA-Z0-9]+@[a-zA-Z0-9]+[\\.][a-z]+");
        System.out.println("Example regEx: " + regEx);
    }
}
