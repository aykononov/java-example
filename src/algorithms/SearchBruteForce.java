package algorithms;

import java.util.Arrays;

// Последовательный поиск значения в неупорядоченном массиве (используя цикл foreach)
class SearchBruteForce {

    // Метод генерации неупорядоченного массива с указанием размерности в параметре
    private static int[] newArrsRandom (int len) {
        int[] arrRandom = new int[len];
        for (int i = 0; i < arrRandom.length; i++) {
             arrRandom[i] = (int) (i + Math.random() * 10);
        }
        return arrRandom;
    }

    // Метод линейного (последовательного) поиска
    private static boolean getSearch (int[] inArrs, int n) {
        for (int i = 0; i < inArrs.length; i++) {
            if (n == inArrs[i]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        System.out.println("Создаем массив и выполняем поиск.");
        int[] arrs = newArrsRandom(10);
        System.out.println("    Исходный массив: " + Arrays.toString(arrs));
        System.out.println("Поиск значения  (5): " + getSearch(arrs, 5));
        System.out.println("Поиск значения (20): " + getSearch(arrs, 20));
    }
}
/* ------------------------------------------------
Создаем массив и выполняем поиск.
    Исходный массив: [8, 1, 6, 10, 5, 7, 7, 16, 10, 13]
Поиск значения  (5): true
Поиск значения (20): false
 */