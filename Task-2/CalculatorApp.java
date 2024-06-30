import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1, num2, result = 0;
        char operator;
        
        System.out.println("Welcome to the Calculator App!");

        try {
                        System.out.print("Enter the first number: ");
            num1 = scanner.nextDouble();

                      System.out.print("Enter the operator (+, -, *, /): ");
            operator = scanner.next().charAt(0);

            
            System.out.print("Enter the second number: ");
            num2 = scanner.nextDouble();

            
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        throw new ArithmeticException("Division by zero is not allowed.");
                    }
                    result = num1 / num2;
                    break;
                default:
                    System.out.println("Invalid operator.");
                    return;
            }

            
            System.out.println("The result is: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter numeric values and a valid operator.");
        } finally {
            scanner.close();
        }
    }
}
