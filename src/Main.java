import java.util.Scanner;

/*
Создайте метод, который просит пользователя ввести email. Email считается корректным, если:
в нем не менее 5 символов,
есть символ ‘@’, он не должен быть первым или последним
Создайте свой NotCorrectEmailFormatException
Если пользователь ввел некорректную строку метод должен выкидывать  NotCorrectEmailFormatException.
В main сделайте обработку Exception
 */
public class Main {
    public static void main(String[] args) {
        boolean validEmailEntered = false;
        Scanner scanner = new Scanner(System.in);

        while (!validEmailEntered) {
            try { System.out.print("Введіть ваш email: ");
                String email = getEmailFromUser(scanner);
                System.out.println("Введений email: " + email);
                validEmailEntered = true;
            } catch (RuntimeException e) {
                System.out.println("Помилка: " + e.getMessage());
                System.out.println("Спробуйте ще раз.");
            }
        }

    }
    public static String getEmailFromUser(Scanner scanner){
        String email = scanner.nextLine();

        if (email == null || email.isEmpty()) {
            throw new NotCorrectEmailFormatException ("Email не може бути порожнім.");
        }
        if (email.length()<5){
            throw new NotCorrectEmailFormatException("Email повинен містити не менше 5 символів.");

        }
        if (!email.contains("@")){
            throw new NotCorrectEmailFormatException("Email повинен містити символ '@'.");

        }

        int atIndex = email.indexOf('@');
        if (atIndex <= 0 || atIndex >= email.length() - 1) {
            throw new NotCorrectEmailFormatException("Символ '@' не повинен бути першим або останнім у email.");
        }
      return email;

    }
}