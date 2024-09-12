//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) {
        inputDataUser("kokojambo", "1234qwER", "1234qwER");

    }

    public static void inputDataUser(String login, String password, String confirmPassword) {
        String regexLogin = "^[a-z0-9_]{0,20}$";
        Pattern patternLogin = Pattern.compile(regexLogin);
        Matcher matcherLogin = patternLogin.matcher(login);


        String regexPassword = "^[a-zA-Z0-9_]{0,20}$";
        Pattern patternPassword = Pattern.compile(regexPassword);
        Matcher matcherPassword = patternPassword.matcher(password);


        try {
            if (!matcherLogin.matches()) {
                throw new WrongLoginException();
            }if(!matcherPassword.matches()) {
                throw new WrongPasswordException();
            }
            if(!password.equals(confirmPassword)) {
                throw new WrongPasswordException();
            }

        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Ошибка " + e.getMessage());
        }
    }
}