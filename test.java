import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your birthday in format dd/MM: ");
        String birthdayInString = scanner.nextLine();
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM");
        LocalDate birthdayThisYear = LocalDate.parse(birthdayInString + "/" + now.getYear(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        if (birthdayThisYear.isBefore(now) || birthdayThisYear.isEqual(now)) {
            birthdayThisYear = birthdayThisYear.plusYears(1);
        }

        long daysUntilBirthday = ChronoUnit.DAYS.between(now, birthdayThisYear);
        System.out.println("There are " + daysUntilBirthday + " days until your next birthday.");

        scanner.close();
    }
}