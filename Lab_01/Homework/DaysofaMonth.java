// Ex 6.4
import java.util.Scanner;
public class DaysofaMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String month;
        int year;

        while (true) {
            System.out.print("Enter the month (E.g: January, Jan, Jan., or number): ");
            month = scanner.nextLine().trim();
            if (!isValidMonth(month)) {
                System.out.println("Invalid month. Please try again.");
                continue;
            }

            System.out.print("Enter the year (E.g: 1999): ");
            String yearInput = scanner.nextLine().trim();
            if (!isValidYear(yearInput)) {
                System.out.println("Invalid year. Please enter a non-negative integer.");
                continue;
            }

            year = Integer.parseInt(yearInput);
            break;
        }

        boolean isLeapYear = isLeapYear(year);
        int days = getDaysofaMonth(month, isLeapYear);

        System.out.println("The number of days in " + month + " of " + year + " is: " + days);
    }

    // Kiem tra nam nhuan
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    private static int getDaysofaMonth(String month, boolean isLeapYear) {
        month = month.toLowerCase();
        switch (month) {
            case "january":
            case "jan":
            case "jan.":
            case "1":
                return 31;
            case "february":
            case "feb":
            case "feb.":
            case "2":
                return isLeapYear ? 29 : 28;
            case "march":
            case "mar":
            case "mar.":
            case "3":
                return 31;
            case "april":
            case "apr":
            case "apr.":
            case "4":
                return 30;
            case "may":
            case "5":
                return 31;
            case "june":
            case "jun":
            case "6":
                return 30;
            case "july":
            case "jul":
            case "7":
                return 31;
            case "august":
            case "aug":
            case "aug.":
            case "8":
                return 31;
            case "september":
            case "sep":
            case "sept.":
            case "9":
                return 30;
            case "october":
            case "oct":
            case "oct.":
            case "10":
                return 31;
            case "november":
            case "nov":
            case "nov.":
            case "11":
                return 30;
            case "december":
            case "dec":
            case "dec.":
            case "12":
                return 31;
            default:
                return -1; 
        }
    }

    // Kiem tra dau vao thang
    private static boolean isValidMonth(String month) {
        month = month.toLowerCase();
        String[] validMonths = {"january", "jan", "jan.", "1", "february", "feb", "feb.", "2",
                                "march", "mar", "mar.", "3", "april", "apr", "apr.", "4",
                                "may", "5", "june", "jun", "6", "july", "jul", "7",
                                "august", "aug", "aug.", "8", "september", "sep", "sept.", "9",
                                "october", "oct", "oct.", "10", "november", "nov", "nov.", "11",
                                "december", "dec", "dec.", "12"};
        for (String validMonth : validMonths) {
            if (validMonth.equals(month)) {
                return true;
            }
        }
        return false;
    }

    // Kiem tra dau vao nam
    private static boolean isValidYear(String year) {
        try {
            int parsedYear = Integer.parseInt(year);
            return parsedYear >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}       