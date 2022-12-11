class Calculate {
    public static int getArabResult(int calculateValueOne, int calculateValueTwo, char mathematicalOperation) {
        int arabicResult = 0;
        if (mathematicalOperation == '+') {
            arabicResult = calculateValueOne + calculateValueTwo;
            return arabicResult;
        }
        if (mathematicalOperation == '-') {
            arabicResult = calculateValueOne - calculateValueTwo;
            return arabicResult;
        }
        if (mathematicalOperation == '*') {
            arabicResult = calculateValueOne * calculateValueTwo;
            return arabicResult;
        }
        if (mathematicalOperation == '/') {
            arabicResult = calculateValueOne / calculateValueTwo;
            return arabicResult;
        }
        return arabicResult;
    }
}
