class Calculate {
    public static int getArabResult(int calculateValueOne, int calculateValueTwo, char mathematicalOperation) {
        int arabicResult = 0;
        if (mathematicalOperation == '+') {
            arabicResult = calculateValueOne + calculateValueTwo;
        }
        if (mathematicalOperation == '-') {
            arabicResult = calculateValueOne - calculateValueTwo;
        }
        if (mathematicalOperation == '*') {
            arabicResult = calculateValueOne * calculateValueTwo;
        }
        if (mathematicalOperation == '/') {
            if (calculateValueTwo == 0) {
                System.out.println("Ошибка! Деление на ноль!");
                System.exit(0);
            }
            arabicResult = calculateValueOne / calculateValueTwo;
        }
        return arabicResult;
    }
}
