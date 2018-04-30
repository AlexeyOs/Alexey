package ru.pro.exam;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by koldy on 30.03.2018.
 * задача
 * Даны два слова проверить, что они состоят из одинаковых букв
 * String
 */
public class WordVerification {
    /*
     * Счётчик совпадения символов.
     */
    private int countSame = 0;
    /*
     * Метод проверяет два массива заполненных буквами, составленные из двух слов.
     */
    public boolean verification(String str1, String str2) {
        HashMap<Integer, String> strArr1 = sendToArrayAllCharacters(str1);
        HashMap<Integer, String> strArr2 = sendToArrayAllCharacters(str2);
        checkForCoincidence(strArr1, strArr2);
        if (countSame == strArr1.size() && countSame == strArr2.size()) {
            return true;
        }
        return false;
    }
    /*
     * Проверяет на совпадение букв
     */
    private int checkForCoincidence(HashMap<Integer, String> strArr1, HashMap<Integer, String> strArr2) {
        //определяет самый длинные массив
        if (strArr1.size() > strArr2.size()) {
            for (int i = 0; i < strArr1.size(); i++) {
                if (strArr2.containsValue(strArr1.get(i))) {
                    countSame++;
                }
            }
        } else {
            for (int i = 0; i < strArr2.size(); i++) {
                if (strArr1.containsValue(strArr2.get(i))) {
                    countSame++;
                }
            }
        }
        return countSame;
    }

    /*
     * Разбивает слово по буквам и отправляет в массив
     */
    private HashMap<Integer, String> sendToArrayAllCharacters(String str) {
        HashMap<Integer, String> strArrayCharacters = new HashMap<>();
        /*
         * Переменная которая указывает, есть ли уже в массиве данная буква.
         */
        boolean alreadyExists = false;
        int index = 0;
        for (int i = 0; i < str.length();  i++) {
            if (strArrayCharacters.containsValue(str.substring(i, i + 1))) {
                alreadyExists = true;
            }
            if (!alreadyExists) {
                strArrayCharacters.put(index, str.substring(i, i + 1));
                index++;
            }
            alreadyExists = false;
        }
        return strArrayCharacters;
    }

}
