import java.util.Scanner;

public class PasswordGenerator {
    private Scanner scanner;
    private boolean containUpperLetters;
    private boolean containLowerLetters;
    private boolean containNumbers;
    private boolean containSymbols;

    public PasswordGenerator(){
        containUpperLetters = false;
        containLowerLetters = false;
        containNumbers = false;
        containSymbols = false;
        scanner = new Scanner(System.in);
    }

    public String generatePassword() throws InterruptedException {
        int length = getValidLength();
        obtainCriteriaPreferences();
        ensureAtLeastOneCriteria();

        Generator generator = new Generator(length, containUpperLetters
                , containLowerLetters, containNumbers, containSymbols);
        return generator.generate();
    }

    private int getValidLength() throws InterruptedException {
        String inputLength;
        boolean isValid;
        int length = 0;
        do {
            System.out.print("Enter the length of the password you want to generate (min 12 characters): ");
            inputLength = scanner.nextLine();
            isValid = inputLength.matches("\\d+");
            if (isValid) {
                length = Integer.parseInt(inputLength);
                if (length < 12) {
                    System.err.println("The length must be at least 12 characters.");
                    Thread.sleep(150);
                    isValid = false;
                }
            } else {
                System.err.println("Wrong input for length. Check it and try again!");
                Thread.sleep(150);
            }
        } while (!isValid);

        return length;
    }

    private void obtainCriteriaPreferences() throws InterruptedException {
        containUpperLetters = getUserPreference("upper letters");
        containLowerLetters = getUserPreference("lower letters");
        containNumbers = getUserPreference("numbers");
        containSymbols = getUserPreference("symbols");
    }

    private boolean getUserPreference(String criteria) throws InterruptedException {
        String input;
        do {
            System.out.printf("Do you want your password to contain %s (y/n): ", criteria);
            input = scanner.nextLine().trim().toLowerCase();
        } while (!isInputOfCriteriaCorrect(input));
        return input.equals("y");
    }

    private void ensureAtLeastOneCriteria() throws InterruptedException {
        while (!(containUpperLetters || containLowerLetters || containNumbers || containSymbols)) {
            System.err.println("You cannot generate a password without any criteria. Please select at least one.");
            Thread.sleep(150);
            obtainCriteriaPreferences();
        }
    }

    private boolean isInputOfCriteriaCorrect(String input) throws InterruptedException {
        if (!(input.equals("y") || input.equals("n"))) {
            System.err.println("Wrong input! Use (y) or (n)!");
            Thread.sleep(150);
            return false;
        }
        return true;
    }
}
