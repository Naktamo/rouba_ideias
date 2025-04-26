// ConversorTemperatura.java - Versão expandida com mais unidades e interface aprimorada
import java.util.Scanner;

public class ConversorTemperatura {
    
    // Conversões de Celsius para outras unidades
    public static double celsiusParaFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }
    
    public static double celsiusParaKelvin(double celsius) {
        return celsius + 273.15;
    }
    
    // Conversões de Fahrenheit para outras unidades
    public static double fahrenheitParaCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }
    
    public static double fahrenheitParaKelvin(double fahrenheit) {
        return ((fahrenheit - 32) * 5/9) + 273.15;
    }
    
    // Conversões de Kelvin para outras unidades
    public static double kelvinParaCelsius(double kelvin) {
        return kelvin - 273.15;
    }
    
    public static double kelvinParaFahrenheit(double kelvin) {
        return ((kelvin - 273.15) * 9/5) + 32;
    }
    
    public static void exibirMenu() {
        System.out.println("\n=== CONVERSOR DE TEMPERATURA ===");
        System.out.println("1. Celsius → Fahrenheit");
        System.out.println("2. Celsius → Kelvin");
        System.out.println("3. Fahrenheit → Celsius");
        System.out.println("4. Fahrenheit → Kelvin");
        System.out.println("5. Kelvin → Celsius");
        System.out.println("6. Kelvin → Fahrenheit");
        System.out.println("7. Comparação de temperaturas");
        System.out.println("0. Sair");
        System.out.print("\nEscolha uma opção: ");
    }
    
    public static void compararTemperaturas() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n--- COMPARAÇÃO DE TEMPERATURAS ---");
        System.out.print("Digite a temperatura a ser convertida: ");
        double temperatura = scanner.nextDouble();
        
        System.out.println("Escolha a unidade dessa temperatura:");
        System.out.println("1. Celsius");
        System.out.println("2. Fahrenheit");
        System.out.println("3. Kelvin");
        
        System.out.print("Opção: ");
        int unidade = scanner.nextInt();
        
        double celsius = 0, fahrenheit = 0, kelvin = 0;
        
        // Converter para todas as unidades
        if (unidade == 1) {
            celsius = temperatura;
            fahrenheit = celsiusParaFahrenheit(temperatura);
            kelvin = celsiusParaKelvin(temperatura);
        } 
        else if (unidade == 2) {
            celsius = fahrenheitParaCelsius(temperatura);
            fahrenheit = temperatura;
            kelvin = fahrenheitParaKelvin(temperatura);
        }
        else if (unidade == 3) {
            celsius = kelvinParaCelsius(temperatura);
            fahrenheit = kelvinParaFahrenheit(temperatura);
            kelvin = temperatura;
        }
        else {
            System.out.println("Opção inválida!");
            return;
        }
        
        // Exibir tabela comparativa
        System.out.println("\n=== TABELA COMPARATIVA ===");
        System.out.printf("Celsius:    %.2f °C\n", celsius);
        System.out.printf("Fahrenheit: %.2f °F\n", fahrenheit);
        System.out.printf("Kelvin:     %.2f K\n", kelvin);
        
        // Exibir informações extras
        System.out.println("\n=== INFORMAÇÕES EXTRAS ===");
        
        if (celsius <= 0) {
            System.out.println("Água congela a essa temperatura em Celsius");
        }
        
        if (celsius >= 100) {
            System.out.println("Água ferve a essa temperatura em Celsius");
        }
        
        if (celsius > 20 && celsius < 25) {
            System.out.println("Temperatura ambiente agradável");
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean executando = true;
        
        while (executando) {
            exibirMenu();
            int opcao = scanner.nextInt();
            
            switch(opcao) {
                case 0:
                    System.out.println("Encerrando o programa...");
                    executando = false;
                    break;
                    
                case 1: // Celsius para Fahrenheit
                    System.out.print("\nDigite a temperatura em Celsius: ");
                    double celsius = scanner.nextDouble();
                    System.out.printf("%.2f °C = %.2f °F\n", celsius, celsiusParaFahrenheit(celsius));
                    break;
                    
                case 2: // Celsius para Kelvin
                    System.out.print("\nDigite a temperatura em Celsius: ");
                    celsius = scanner.nextDouble();
                    System.out.printf("%.2f °C = %.2f K\n", celsius, celsiusParaKelvin(celsius));
                    break;
                    
                case 3: // Fahrenheit para Celsius
                    System.out.print("\nDigite a temperatura em Fahrenheit: ");
                    double fahrenheit = scanner.nextDouble();
                    System.out.printf("%.2f °F = %.2f °C\n", fahrenheit, fahrenheitParaCelsius(fahrenheit));
                    break;
                    
                case 4: // Fahrenheit para Kelvin
                    System.out.print("\nDigite a temperatura em Fahrenheit: ");
                    fahrenheit = scanner.nextDouble();
                    System.out.printf("%.2f °F = %.2f K\n", fahrenheit, fahrenheitParaKelvin(fahrenheit));
                    break;
                    
                case 5: // Kelvin para Celsius
                    System.out.print("\nDigite a temperatura em Kelvin: ");
                    double kelvin = scanner.nextDouble();
                    System.out.printf("%.2f K = %.2f °C\n", kelvin, kelvinParaCelsius(kelvin));
                    break;
                    
                case 6: // Kelvin para Fahrenheit
                    System.out.print("\nDigite a temperatura em Kelvin: ");
                    kelvin = scanner.nextDouble();
                    System.out.printf("%.2f K = %.2f °F\n", kelvin, kelvinParaFahrenheit(kelvin));
                    break;
                    
                case 7: // Comparação de temperaturas
                    compararTemperaturas();
                    break;
                    
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
            
            // Pausa antes de voltar ao menu
            if (executando) {
                System.out.print("\nPressione ENTER para continuar...");
                scanner.nextLine(); // Consumir o enter da opção
                scanner.nextLine(); // Aguardar o próximo enter
            }
        }
        
        scanner.close();
    }
}
