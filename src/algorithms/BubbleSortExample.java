package algorithms;

import java.util.Arrays;

public class BubbleSortExample {

    public static void main(String[] args) {
        int[] arrays = genarateIntArrays(10);
        System.out.println("Пузырьковая сортировка.");
        System.out.println("Исходный массив: " + Arrays.toString(arrays));
        System.out.println("Отсортированный: " + Arrays.toString(bubbleSort(arrays)));
    }

    /**
     * Метод генерации неупорядоченного массива с указанием размерности в аргументе
     */
    private static int[] genarateIntArrays(int len) {
        int[] arrRandom = new int[len];
        for (int i = 0; i < arrRandom.length; i++) {
            arrRandom[i] = (int) (i + Math.random() * 10);
        }
        return arrRandom;
    }

    /**
     * Метод сортировки Пузырьком с аргументом типа целочисленный массив
     */
    private static int[] bubbleSort(int[] intArrays) {
        int k;
        for (int i = 0; i < intArrays.length; i++) {
            for (int j = i + 1; j < intArrays.length; j++) {
                if (intArrays[i] > intArrays[j]) {
                    k = intArrays[j];
                    intArrays[j] = intArrays[i];
                    intArrays[i] = k;
                }
            }
        }
        return intArrays;
    }
}
/* --------------------------------------------------

Пузырьковая сортировка.
Исходный массив: [1, 7, 6, 12, 7, 7, 6, 8, 15, 17]
Отсортированный: [1, 6, 6, 7, 7, 7, 8, 12, 15, 17]

 */