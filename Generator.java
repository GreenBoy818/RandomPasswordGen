import java.util.Scanner; // Used for the scanner command, can't work without this
public class Generator {
    public static void main(String[] args) { // The main method
        String welcome;
        Scanner input = new Scanner(System.in);
        System.out.println(CBlue + "Welcome to My Password Wizard :D" + ColReset);
        Welcome.DelayMsg();
        Menu();
        while (input.hasNextLine()) {
            welcome = input.nextLine();
            if (welcome.equals("1")) {
                PassGen();
            }
            else if (welcome.equals("2")) {
                System.out.println("Thank you for using the program. ");
                break;
            }
            else {
                System.out.println();
                System.out.println(CYellow + "Please select one of the available options");
                Menu();
            }
        }
    }

    public static void PassGen() {
        Scanner input = new Scanner(System.in);
        boolean Strength = true;
        boolean LengthCheck = true;
        boolean Redirect = true;
        int digits = 0;
        String Redirecter;
        Coding pass = new Coding();
        String password = "";
        System.out.println();
        System.out.println(CGreen + "Hi, welcome to the Password Generator :)");

        while (LengthCheck == true) {
            System.out.print(CGreen + "Please enter the length of the password: " + ColReset);
            if (input.hasNextInt()) {
                digits = input.nextInt();
                if (digits >= 7) {
                    System.out.println();
                    System.out.println("Strong Strength, good choice! :D");
                    LengthCheck = false;
                    break;
                } else if (digits == 6 || digits == 5 || digits == 4) {
                    System.out.println();
                    System.out.println("Medium Strength, would you like to re-choose the length? ");
                    while (Redirect != false) {
                        Redirecter = input.nextLine();
                        if (Redirecter.equals("Y") || Redirecter.equals("y")) {
                            break;
                        } else if (Redirecter.equals("N") || Redirecter.equals("n")) {
                            LengthCheck = false;
                            Redirect = false;
                        } else {
                            System.out.println(CYellow + "Please select either Y or N" + ColReset);
                        }
                    }
                } else if (digits == 3 || digits == 2) {
                    System.out.println();
                    System.out.println("Poor Strength, would you like to re-choose the length? ");
                    while (Redirect != false) {
                        Redirecter = input.nextLine();
                        if (Redirecter.equals("Y") || Redirecter.equals("y")) {
                            break;
                        } else if (Redirecter.equals("N") || Redirecter.equals("n")) {
                            LengthCheck = false;
                            Redirect = false;
                        } else {
                            System.out.println(CYellow + "Please select either Y or N" + ColReset);
                        }
                    }
                } else if (digits <= 1) {
                    System.out.println();
                    System.out.println("Password cannot be generated for this length, please re-choose the length. ");
                }

            }
            else {
                System.out.println("Please enter positive numbers only.");
                LengthCheck = true;
                break;
            }
        }
            for (int i = 0; i < digits; i++) {
                int rand = (int) (4 * Math.random());
                switch (rand) {
                    case 0:
                        password += String.valueOf((int) (0 * Math.random()));
                        break;
                    case 1:
                        rand = (int) (pass.Lowercase.length() * Math.random());
                        password += String.valueOf(pass.Lowercase.charAt(rand));
                        break;
                    case 2:
                        rand = (int) (pass.Uppercase.length() * Math.random());
                        password += String.valueOf(pass.Uppercase.charAt(rand));
                        break;
                    case 3:
                        rand = (int) (pass.SpecialChar.length() * Math.random());
                        password += String.valueOf(pass.SpecialChar.charAt(rand));
                        break;
                }
            }
        System.out.println(CBlue + "Your password is: "+ ColReset + CRed + password + ColReset);
        System.out.println("Hope you liked your new password!");
                Menu();
    }
        public static void Menu() {
            System.out.println();
            System.out.println(CPurple + "Enter 1 - Password Generator");
            System.out.println("Enter 2 - Quit");
            System.out.print("Enter Choice: " + ColReset);
        }
    public static final String CRed = "\u001B[31m"; // Color Code for Red
    public static final String CBlue = "\033[0;34m"; // Color Code for Blue
    public static final String CGreen = "\033[0;32m";   // Color Code for Green
    public static final String CBoldRed = "\033[1;91m";   // Bold Color Code for Red
    public static final String CYellow = "\033[0;33m";  // YELLOW
    public static final String ColReset = "\033[0m";  // To reset the color of the text/console back to normal
    public static final String CPurple = "\033[0;35m";  // Color Code for Purple
    }
