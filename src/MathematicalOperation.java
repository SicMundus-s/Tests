class MathematicalOperation {

    // Ищем нужный символ в строке. indexOf() возвращает индекс первого вхождения символа в строке
    public static char getMathematicalOperation(String str1) {

        char mathematicalOperation = '?';

        int index = str1.indexOf("+");

        if (index > -1) {
            mathematicalOperation = '+';
        }

        if (index == -1) {
            index = str1.indexOf("-");
            if (index > -1) {
                mathematicalOperation = '-';
            }
        }

        if (index == -1) {
            index = str1.indexOf("/");
            if (index > -1) {
                mathematicalOperation = '/';
            }
        }

        if (index == -1) {
            index = str1.indexOf("*");
            if (index > -1) {
                mathematicalOperation = '*';
            }
        }
        return mathematicalOperation;
    }
}
