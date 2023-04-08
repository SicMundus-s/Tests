package KataAcademy;

import java.util.TreeMap;

class Converter {

    public static String intToRoman(int number){
        TreeMap<Integer, String> arabianKeyMap = new TreeMap<>();
        arabianKeyMap.put(1000, "M");
        arabianKeyMap.put(900, "CM");
        arabianKeyMap.put(500, "D");
        arabianKeyMap.put(400, "CD");
        arabianKeyMap.put(100, "C");
        arabianKeyMap.put(90, "XC");
        arabianKeyMap.put(50, "L");
        arabianKeyMap.put(40, "XL");
        arabianKeyMap.put(10, "X");
        arabianKeyMap.put(9, "IX");
        arabianKeyMap.put(5, "V");
        arabianKeyMap.put(4, "IV");
        arabianKeyMap.put(1, "I");
        arabianKeyMap.put(0, "в римской системе нет нуля:)");

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