
import java.util.*;

interface CalculatorInterface {
    int sum(int a, int b);
    int minus(int a, int b);
    int multiple(int a, int b);
    int division(int a, int b);
}

class Calculator implements CalculatorInterface {
    public int sum(int a, int b)
    {
        return a + b;
    }
    public int minus(int a, int b) {
        return a - b;
    }
    public int multiple(int a, int b) {
        return a * b;
    }
    public int division(int a, int b) {
        return a / b;
    }
}

class UserInterface {
    private Scanner scanner;
    private Calculator calculator;

    UserInterface() {
        scanner = new Scanner(System.in);
        calculator = new Calculator();
    }

    void printDisplay() {
        System.out.println("연산을 고르세요");
        System.out.println("1. 덧셈");
        System.out.println("2. 뺄셈");
        System.out.println("3. 곱셈");
        System.out.println("4. 나눗셈");
        System.out.println("5. 종료");
    }

    void run() {
        while(true) {
            printDisplay();
            int choice = scanner.nextInt();

            if(choice == 5) {
                System.out.println("계산 종료");
                break;
            }

            System.out.print("숫자를 입력하세요:");
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            try {
                int result = 0;
                switch(choice) {
                    case 1:
                        result = calculator.sum(a, b);
                        break;
                    case 2:
                        result = calculator.minus(a, b);
                        break;
                    case 3:
                        result = calculator.multiple(a, b);
                        break;
                    case 4:
                        result = calculator.division(a, b);
                        break;
                }
                System.out.println("결과값: " + result);
            } catch (ArithmeticException e) {
                System.out.println("에러: " + e.getMessage());
            }
        }
    }
}

public class JavaMiniCalculator {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.run();
    }
}

