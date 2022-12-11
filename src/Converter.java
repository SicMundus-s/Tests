import java.util.TreeMap;

class Converter {

    public static String intToRoman(int number){
        TreeMap<Integer, String> arabianKeyMap = new TreeMap<>();
        arabianKeyMap.put(10, "X");
        arabianKeyMap.put(9, "IX");
        arabianKeyMap.put(5, "V");
        arabianKeyMap.put(4, "IV");
        arabianKeyMap.put(1, "I");

        StringBuilder roman = new StringBuilder();
        int arabianKey;
        do {
            arabianKey = arabianKeyMap.floorKey(number); // Возвращает наибольший ключ, меньший или равный данному
            roman.append(arabianKeyMap.get(arabianKey));
            number -= arabianKey;
        } while (number != 0);
        return roman.toString();
    }
}