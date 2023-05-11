package utility;

public class BankAccountValidator {

    public static boolean isValidBankAccount(String accountNumber) {
        // Remove any whitespace or dashes from the account number
        String cleanedAccountNumber = accountNumber.replaceAll("\\s|-", "");

        // Ensure the account number is numeric
        if (!cleanedAccountNumber.matches("\\d+")) {
            return false;
        }

        // Check if the account number length is within a valid range
        if (cleanedAccountNumber.length() < 7 || cleanedAccountNumber.length() > 14) {
            return false;
        }

        return true;
    }
}

