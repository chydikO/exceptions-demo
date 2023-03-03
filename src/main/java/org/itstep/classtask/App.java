package org.itstep.classtask;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Необхідно реалізвуати можливість реєстрації користувача.
 *
 * Для цього потрібно в класі створити статичинй метод registration(), який повинен повертати об'єкт типу User
 * Клас User зберігає логін, email та пароль користувача.
 *
 * В методі registration() реалізувати консольний ввод логіну, email та паролю.
 * При цьому потрібно перевірити, що email відповідає формату
 * Пароль запросити двічі.
 *
 * У випадку, якщо email не відповідає формату потрібно викинути перевіряєме виключення InvalidEmialException
 * Якщо паролі не будуть співпадати, то викинути НЕ перевіряєме виключення ConfirmPasswordException
 *
 * Привести приклад застосування мтоду в методі main()
 */
public class App {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Pattern p = Pattern.compile("\\b[A-Za-z0-9._%+-]+@[A-Aa-z0-9.-]+\\.[]A-Za-z]{2,4}\\b");


    public static void main(String[] args) {
        registration();
    }

    private static User registration() {
        System.out.println("Enter you user name:\t");
        String login = scanner.nextLine();

        try {
            System.out.println("Enter you email:\t");
            String email = scanner.nextLine();
        } catch (InvalidEmailException e) {

        }


        System.out.println("Enter you password:\t");
        String password = scanner.nextLine();



        Matcher m = p.matcher(email);

        while (m.find()) {
            System.out.print("m.start:\t" + m.start() + "\nm.group()\t" + m.group());
        }

        return new User(login, email, password);
    }
}
