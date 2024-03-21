public class Main {
    public static void main(String[] args) throws InterruptedException {

        PasswordGenerator passwordGenerator = new PasswordGenerator();
        String generatedPassword = passwordGenerator.generatePassword();
        System.out.println("Your random password is: " + generatedPassword);
    }
}
