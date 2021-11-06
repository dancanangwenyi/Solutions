package sectionA;

import javax.swing.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Create a new file called do_whilePassword.java.
 * Imagine that the password to sign in to some computer is "John". Write a
 * program that prompts the user to enter a password to log in to this
 * imaginary computer.
 * If the user enters the correct password, then notify the user and terminate
 * the program.
 * Should the user get the password incorrect three times in a row, then
 * inform the user of the current password and allow the user to set a new
 * password.
 */
public class do_whilePassword {

    public static void main ( String [] args ) {
        do_whilePassword do_while = new do_whilePassword();
        //Number of attempts
        int attempts = 1;
        String password = JOptionPane.showInputDialog("Enter password:");
        while(!password.equals("John")){
            attempts++;
            if(attempts > 3){
                do_while.setNewPassword();
            }
            password = JOptionPane.showInputDialog("Incorrect password. Please enter the password:");
        }
        JOptionPane.showMessageDialog(new JFrame()  ,"Correct Password! Login Success");
        System.exit(0);

    }

    /**
     * The password may have any number of characters between 1 and 20,
     * inclusive.
     * The password may start with an underscore "_" or any letter of the
     * alphabet.
     * The password may be any combination of upper and lower case
     * letters.
     * The password consists only of numbers, English alphabet letters, and
     * the underscore character.
     * @return true if it satisfies the conditions and false otherwise
     */
    public boolean isSatifiesPasswordRules(String password){
        int passsword_length = password.length();
        if(passsword_length > 0 && passsword_length < 21){
            String regex = "^[a-zA-Z0-9_]+$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(password);
            return  matcher.matches();
        }
        return false;
    }

    /**
     * The method used to set a new passowrd. and only exits
     * after the new password set aligns with the password rules that
     * have been set.
     *
     */
    public void setNewPassword(){
        String new_password = JOptionPane.showInputDialog("Password incorrect on three attempts.\nThe password was John. Please set a new user");
        while (!isSatifiesPasswordRules(new_password)){
            System.out.println("");
            new_password = JOptionPane.showInputDialog("Invalid password, Please try again");
        }
        JOptionPane.showMessageDialog(new JFrame()  ,"Password changed.");
        System.exit(0);
    }
}
