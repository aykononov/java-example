package algorithms;

import java.util.Arrays;

public class AlgorithmBubbleSort {

    public static void main(String[] args) {
        final int LEN = 10;
        int[] arrays = genarateIntArrays(LEN);

        System.out.println("Пузырьковая сортировка.");
        System.out.println("Исходный массив: " + Arrays.toString(arrays));

        bubbleSort(arrays);

        System.out.println("Отсортированный: " + Arrays.toString(arrays));
    }

    /**
     * Метод генерации неупорядоченного массива с указанием размерности в аргументе
     */
    private static int[] genarateIntArrays(int len) {
        if (len < 0) return new int[0];

        int[] arrRandom = new int[len];
        for (int i = 0; i < arrRandom.length; i++) {
            arrRandom[i] = (int) (i + Math.random() * 10);
        }
        return arrRandom;
    }

    /**
     * Метод реализует алгоритм сортировки Пузырьком
     */
    private static void bubbleSort(int[] arrays) {

        for (int i = 0; i < arrays.length; i++) {
            for (int j = i + 1; j < arrays.length; j++) {
                if (arrays[i] > arrays[j]) {
                    int temp = arrays[j];
                    arrays[j] = arrays[i];
                    arrays[i] = temp;
                }
            }
        }
    }
}

/* --------------------------------------------------

Пузырьковая сортировка.
Исходный массив: [1, 7, 6, 12, 7, 7, 6, 8, 15, 17]
Отсортированный: [1, 6, 6, 7, 7, 7, 8, 12, 15, 17]

 */