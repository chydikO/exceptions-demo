package org.itstep.classtask;

import java.util.Scanner;

/**
 * Необхідно реалізвуати можливість реєстрації користувача.
 * <p>
 * Для цього потрібно в класі створити статичинй метод registration(), який повинен повертати об'єкт типу User
 * Клас User зберігає логін, email та пароль користувача.
 * <p>
 * В методі registration() реалізувати консольний ввод логіну, email та паролю.
 * При цьому потрібно перевірити, що email відповідає формату
 * Пароль запросити двічі.
 * <p>
 * У випадку, якщо email не відповідає формату потрібно викинути перевіряєме виключення InvalidEmialException
 * Якщо паролі не будуть співпадати, то викинути НЕ перевіряєме виключення ConfirmPasswordException
 * <p>
 * Привести приклад застосування мтоду в методі main()
 */
public class App {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String emailPattern = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[]A-Za-z]{2,4}\\b";


    public static void main(String[] args) {
        try {
            System.out.println("Registrations->" + registration());
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
    }

    private static User registration() throws Exception {
        System.out.println("Enter you user name:\t");
        String login = scanner.nextLine();


        System.out.println("Enter you email:\t");
        String email = scanner.nextLine();

        if (!email.matches(emailPattern)) {
            throw new InvalidEmailException("Error input email");
        }

        String password = getPassword();
        return new User(login, email, password);
    }

    private static String getPassword() throws ConfirmPasswordException {
        System.out.println("Enter you password:\t");
        String password = scanner.nextLine();

        System.out.println("ReEnter you password:\t");
        String password2 = scanner.nextLine();
        if (!password.equals(password2)) {
            throw new ConfirmPasswordException("Error input password");
        }
        return password;
    }
}
