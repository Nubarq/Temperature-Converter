import java.util.Scanner;


public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            displayMenu();
            int choice = scanner.nextInt();

            if (choice == 3) {
                running = false;
                System.out.println("Exiting the temperature converter.");
                continue;
            }

            System.out.print("Enter the temperature: ");
            double temperature = scanner.nextDouble();

            double convertedTemperature = performConversion(choice, temperature);
            displayResult(choice, temperature, convertedTemperature);
        }

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\nSelect a conversion:");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    private static double performConversion(int choice, double temperature) {
        switch (choice) {
            case 1:
                return celsiusToFahrenheit(temperature);
            case 2:
                return fahrenheitToCelsius(temperature);
            default:
                throw new IllegalArgumentException("Invalid choice. Please select a valid option.");
        }
    }

    private static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    private static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    private static void displayResult(int choice, double originalTemperature, double convertedTemperature) {
        String fromUnit = (choice == 1) ? "Celsius" : "Fahrenheit";
        String toUnit = (choice == 1) ? "Fahrenheit" : "Celsius";

        System.out.printf("%.2f° %s is equal to %.2f° %s%n",
                originalTemperature, fromUnit, convertedTemperature, toUnit);
    }
}
