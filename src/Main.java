import br.com.coin.converter.models.ApiSearch;
import br.com.coin.converter.models.ConvertionAndValidation;
import br.com.coin.converter.models.Operation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int option = 1;
        String base = "BRL";
        String convert = "USD";
        double value;
        ConvertionAndValidation convertionAndValidation = new ConvertionAndValidation();
        List<Operation> operations = new ArrayList<>();

        while (option > 0 && option < 12) {
            System.out.println(convertionAndValidation.baseMessage());
            option = reader.nextInt();

            if (option == 11) {
                if (operations.isEmpty()) {
                    System.out.println("Nenhuma operação realizada, até o momento.");
                } else {
                    System.out.println("Operações realizadas:");
                    System.out.println(operations);
                }
            } else if (option != 12) {
                System.out.println("Digite o valor que deseja converter:");
                value = reader.nextDouble();
                var convertionResult = convertionAndValidation.convertAndValidate(option, base, convert, value);
                Operation currentOperation = new Operation(convertionResult);
                operations.add(currentOperation);
                System.out.println(convertionResult);
            } else {
                System.out.println("Até a próxima!");
            }
        }
    }
}
