import java.util.Scanner;

public class Exer02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe um número para verificar se pertence à sequência de Fibonacci: ");
        int numero = scanner.nextInt();
        
        int a = 0;
        int b = 1;
        int fib = 0;
    
        boolean pertence = false;
        
        while (fib <= numero) {
            if (fib == numero) {
                pertence = true;
                break;
            }

            fib = a + b;
            a = b;
            b = fib;
        }
        
        if (pertence) {
            System.out.println("O número " + numero + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println("O número " + numero + " não pertence à sequência de Fibonacci.");
        }

        scanner.close();
    }
}

