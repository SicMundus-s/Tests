import java.util.Scanner;


public class Main {

    private final static String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    private final static String[] arabic = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите выражение(пример: 1 + 2 или I + II):");
        String input = in.nextLine();
        System.out.println(calc(input));
    }

    public static String calc(String input) {

        int calculateValueOne = -1;
        int calculateValueTwo = -1;
        boolean isFlagCheckingWhichNumberSystemAndTrueWheEqualToRoman = false; // Флаг не очень хорошая практика. ToDo: По возможности избавиться от него.

        String str1 = input.replaceAll(" ", "");

        int index = -1;
        char mathematicalOperation = MathematicalOperation.getMathematicalOperation(str1);

        if (mathematicalOperation == '?') {
            try {
                throw new MathematicalOperationException("throws Exception //т.к. строка не является математической операцией");
            } catch (MathematicalOperationException e){
                System.out.println(e.getMessage());
                System.exit(0);
            }

        } else {
            index = str1.indexOf(mathematicalOperation);
        }

        // Пробегаемся по массивам арабский и римский чисел, и находим совпадение с пользовательским вводом
        String variable1str = str1.substring(0, index);
        for (int i = 0; i < roman.length; i++) {
            String variableForCompare = roman[i];
            if (variable1str.equalsIgnoreCase(variableForCompare)) {
                calculateValueOne = i + 1;
                isFlagCheckingWhichNumberSystemAndTrueWheEqualToRoman = true;
                break;
            }
        }
        for (int i = 0; i < arabic.length; i++) {
            String variableForCompare = arabic[i];
            if (variable1str.equalsIgnoreCase(variableForCompare)) {
                calculateValueOne = i + 1;
                isFlagCheckingWhichNumberSystemAndTrueWheEqualToRoman = false;
                break;
            }
        }
        if (calculateValueOne == -1) {
            try {
                throw new MathematicalConditionsException("throws Exception //т.к. формат математической операции не удовлетворяет заданию" +
                                                          " - два операнда и один оператор EXC (+, -, /, *)");
            } catch (MathematicalConditionsException e){
                System.out.println(e.getMessage());
                System.exit(0);
            }
        }


        // Выполняем те же операции для второй переменной с учетом того, что она может быть в другой системе счисления(Используем flag)
        String variable2str = str1.substring(index + 1);
        for (int i = 0; i < roman.length; i++) {
            String variableForCompare = roman[i];
            if (variable2str.equalsIgnoreCase(variableForCompare)) {
                if (!isFlagCheckingWhichNumberSystemAndTrueWheEqualToRoman) {
                    try {
                        throw new NumberSystemsException("throws Exception //т.к. используются одновременно разные системы счисления");
                    } catch (NumberSystemsException e){
                        System.out.println(e.getMessage());
                        System.exit(0);
                    }
                }
                calculateValueTwo = i + 1;
            }
        }
        for (int i = 0; i < arabic.length; i++) {
            String variableForCompare = arabic[i];
            if (variable2str.equalsIgnoreCase(variableForCompare)) {
                if (isFlagCheckingWhichNumberSystemAndTrueWheEqualToRoman) {
                    try {
                        throw new NumberSystemsException("throws Exception //т.к. используются одновременно разные системы счисления");
                    } catch (NumberSystemsException e){
                        System.out.println(e.getMessage());
                        System.exit(0);
                    }
                }
                calculateValueTwo = i + 1;
            }
        }
        if (calculateValueTwo == -1) {
            try {
                throw new MathematicalConditionsException("throws Exception //т.к. формат математической операции не удовлетворяет заданию" +
                                                          " - два операнда и один оператор EXC (+, -, /, *)");
            } catch (MathematicalConditionsException e){
                System.out.println(e.getMessage());
                System.exit(0);
            }
        }



        int arabicResult = Calculate.getArabResult(calculateValueOne, calculateValueTwo, mathematicalOperation);
        String result = "";
        if (isFlagCheckingWhichNumberSystemAndTrueWheEqualToRoman && arabicResult > 0) {
            result = Converter.intToRoman(arabicResult);
        } else if (!isFlagCheckingWhichNumberSystemAndTrueWheEqualToRoman) {
            result = String.valueOf(arabicResult);
        } else if (arabicResult < 0) {
            try {
                throw new NegativeNumberException("throws Exception //т.к. в римской системе нет отрицательных чисел");
            } catch (NegativeNumberException e){
                System.out.println(e.getMessage());
                System.exit(0);
            }
        }
        return result;

    }
}