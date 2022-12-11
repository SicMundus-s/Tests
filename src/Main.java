import java.util.Scanner;


public class Main {

    private final static String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    private final static String[] arabic = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите выражение(пример: 1 + 2 или I + II), ноль не является верным фарматом ввода");
        String input = in.nextLine();
        System.out.println(calc(input));
    }

    public static String calc(String input) {

        int calculateValueOne = -1;
        int calculateValueTwo = -1;
        boolean isFlagCheckingWhichNumberSystemAndTrueWhenEqualToRoman = false; // Флаг не очень хорошая практика.

        String str = input.replaceAll(" ", "");

        int index = -1;
        char mathematicalOperation = MathematicalOperation.getMathematicalOperation(str);

        if (mathematicalOperation == '?') {
            try {
                throw new MathematicalOperationException("throws Exception //т.к. строка не является математической операцией");
            } catch (MathematicalOperationException e){
                System.out.println(e.getMessage());
                System.exit(0);
            }

        } else {
            index = str.indexOf(mathematicalOperation);
        }

        // Пробегаемся по массивам арабским и римсим чиселам, и находим совпадение с пользовательским вводом
        String calculateValueOneStr = str.substring(0, index);
        for (int i = 0; i < roman.length; i++) {
            String romanTempForEquals = roman[i];
            if (calculateValueOneStr.equalsIgnoreCase(romanTempForEquals)) {
                calculateValueOne = i + 1;
                isFlagCheckingWhichNumberSystemAndTrueWhenEqualToRoman = true;
                break;
            }
        }
        for (int i = 0; i < arabic.length; i++) {
            String arabicTempForEquals = arabic[i];
            if (calculateValueOneStr.equalsIgnoreCase(arabicTempForEquals)) {
                calculateValueOne = i + 1;
                isFlagCheckingWhichNumberSystemAndTrueWhenEqualToRoman = false;
                break;
            }
        }
        checkInputCondition(calculateValueOne);


        // Выполняем те же операции для второй переменной с учетом того, что она может быть в другой системе счисления(Используем flag)
        String calculateValueTwoStr = str.substring(index + 1);

        for (int i = 0; i < roman.length; i++) {
            String romanTempForEquals = roman[i];
            if (calculateValueTwoStr.equalsIgnoreCase(romanTempForEquals)) {
                if (!isFlagCheckingWhichNumberSystemAndTrueWhenEqualToRoman) {
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
            String arabicTempForEquals = arabic[i];
            if (calculateValueTwoStr.equalsIgnoreCase(arabicTempForEquals)) {
                if (isFlagCheckingWhichNumberSystemAndTrueWhenEqualToRoman) {
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

        checkInputCondition(calculateValueTwo);



        int arabicResult = Calculate.getArabResult(calculateValueOne, calculateValueTwo, mathematicalOperation);
        String result = "";
        if (isFlagCheckingWhichNumberSystemAndTrueWhenEqualToRoman && arabicResult >= 0) {
            result = Converter.intToRoman(arabicResult);
        } else if (!isFlagCheckingWhichNumberSystemAndTrueWhenEqualToRoman) {
            result = String.valueOf(arabicResult);
        } else {
            try {
                throw new NegativeNumberException("throws Exception //т.к. в римской системе нет отрицательных чисел");
            } catch (NegativeNumberException e){
                System.out.println(e.getMessage());
                System.exit(0);
            }
        }
        return result;

    }

    public static void checkInputCondition(int calculateValue) {
        if (calculateValue == -1) {
            try {
                throw new MathematicalConditionsException("throws Exception //т.к. формат математической операции не удовлетворяет заданию" +
                        " - два операнда и один оператор (+, -, /, *)");
            } catch (MathematicalConditionsException e){
                System.out.println(e.getMessage());
                System.exit(0);
            }
        }
    }
}