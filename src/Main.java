import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        String[] answer = input.split(" ");
        if (answer.length!= 6) {
            System.err.println("Неверное количество!");
            return;
        }

        String firstName = answer[1];
        String middleName = answer[2];
        String lastName = answer[0];

        LocalDate dateOfBirth;
        try {
            dateOfBirth = LocalDate.parse(answer[3]);
        } catch (DateTimeException e) {
            System.err.println("Неверный формат даты рождения!");
            return;
        }

        long phoneNumber;
        try {
            phoneNumber = Long.parseLong(answer[4]);
        } catch (NumberFormatException e) {
            System.err.println("Неверный формат номера телефона!");
            return;
        }

        String gender = answer[5];
        if (!gender.equals("f") && !gender.equals("m")) {
            System.err.println("Неверный формат пола!");
            return;
        }

        String file = lastName + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(lastName+ " " + firstName+ " " + middleName+ " " + dateOfBirth + " " + phoneNumber + " " + gender + "\n");
    } catch (IOException e) {
            System.err.println("Ошибка при записи файла!");
            throw new RuntimeException(e);
        }
    }
}