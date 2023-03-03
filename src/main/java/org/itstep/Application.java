package org.itstep;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        // demo01();
        System.out.println("Start");
//        try {
        Thread.sleep(3_000);
//        } catch (InterruptedException ex) {
//            ex.printStackTrace();
//        }
        try {
            div(1, 0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("End");
    }

    static int div(int a, int b) throws DivideByZeroException {
        if (b == 0) {
            throw new DivideByZeroException("Divide by zero");
        }
        return a / b;
    }

    private static void demo01() {
        int a;
        int b;
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter a: ");
            a = scanner.nextInt();
            System.out.print("Enter b: ");
            b = scanner.nextInt();
            System.out.println("a / b = " + (a / b));
//        } catch (Throwable ex) {
//            System.out.println("Some exception");
//        }
        } catch (InputMismatchException | ArithmeticException ex) {
//            if (ex instanceof InputMismatchException) {
//                System.out.println("Input exception");
//            }
//            if (ex instanceof ArithmeticException) {
//                System.out.println("Arithmetic exception");
//            }
            System.out.println("Input or Arithmetic exception: " + ex.getMessage());
            ex.printStackTrace();
        } catch (Throwable ex) {
            System.out.println("Other exception");
        }
//        } catch (InputMismatchException ex) {
//            System.out.println("Input exception");
//        } catch (ArithmeticException ex) {
//            System.out.println("Arithmetic exception");
//        }
        System.out.println("End program");
//        getObject(new Object());
//        getObject(1); // int -> Integer
    }

//    static void getObject(Object o) {
//
//    }

}

class DivideByZeroException extends Exception {
    public DivideByZeroException(String message) {
        super(message);
    }
}
