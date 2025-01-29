import java.util.*;

//Есть список из строк, который состоит из букв а, b, c.
//Например "aaaa", "acb", "ababababa" и тд.
//Цена а = 3, b = 2, c = 1
//
//Нужно найти среди массива строк ту, сумма букв в которой максимальная.
//При этом, если сумма двух строк равна, то больше та, в которой число символов меньше
//Если записей, сумма которых равна и длина равна несколько вывести все эти записи
//
//Найти результат для набора строк "aaaa", "bbbb", "cccc", "abab", "abcabc", "aaccaab", "aabaab"

public class Main {
    public static void main(String[] args) {
        String[] inputs = new String[]{"aaaa", "bbbb", "cccc", "abab", "abcabc", "aaccaab", "aabaab"};
        foo(inputs);
    }

    public static void foo(String[] inputs) {
        Map<String, Integer> map = new HashMap<>();
        for (String e : inputs) {
            map.put(e, calcValueOfString(e));
        }

        int maxValue = map.values().stream().max(Integer::compare).get();
        Map<String, Integer> mapMaxValues = new HashMap<>();
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (maxValue == e.getValue()) {
                mapMaxValues.put(e.getKey(), e.getValue());
            }
        }

        int maxLength = 0;
        for (Map.Entry<String, Integer> e : mapMaxValues.entrySet()) {
            if (maxLength < e.getKey().length()) {
                maxLength = e.getKey().length();
            }
        }

        soutRes(mapMaxValues, maxLength);
    }

    public static int calcValueOfString(String s) {
        int value = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'a': {
                    value += 3;
                    break;
                }
                case 'b': {
                    value += 2;
                    break;
                }
                case 'c': {
                    value += 1;
                    break;
                }
                default: {
                    return -1;
                }
            }
        }
        return value;
    }

    public static void soutRes(Map<String,Integer> map, int maxLength)
    {
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getKey().length() == maxLength) {
                System.out.println(e.getKey());
            }
        }
    }
}