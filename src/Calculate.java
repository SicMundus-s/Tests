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
            //проверка делени€ на 0
            if (calculateValueTwo == 0) {
                System.out.println("Ќа ноль делить мы не умеем, программа завершает свою работу");
                System.exit(0);
            }
            arabicResult = (calculateValueOne - (calculateValueOne % calculateValueTwo)) / calculateValueTwo;
        }
        return arabicResult;
    }
}
