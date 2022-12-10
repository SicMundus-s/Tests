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
            //�������� ������� �� 0
            if (calculateValueTwo == 0) {
                System.out.println("�� ���� ������ �� �� �����, ��������� ��������� ���� ������");
                System.exit(0);
            }
            arabicResult = (calculateValueOne - (calculateValueOne % calculateValueTwo)) / calculateValueTwo;
        }
        return arabicResult;
    }
}
