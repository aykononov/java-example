package algorithms;

import java.util.Arrays;

public class AlgorithmQuickSort {

    public static void main(String[] args) {
        final int LEN = 10;
        int[] arrays = genarateIntArrays(LEN);
        final int LOW = 0;
        final int HIGH = arrays.length - 1;

        System.out.println("Быстрая сортировка.");
        System.out.println("Исходный массив: " + Arrays.toString(arrays));

        quickSort(arrays, LOW, HIGH);

        System.out.println("Отсортированный: " + Arrays.toString(arrays));

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
     * Метод реализует алгоритм Быстрой сортировки
     */
    private static void quickSort(int[] array, int low, int high) {
        int i = low;
        int j = high;

        if (array.length == 0 || i >= j) return;

        int pivot = array[i + (j - i) / 2]; // выбираем опорный элемент

        // Разделим на подмассивы
        while (i <= j) {
            while (array[i] < pivot) i++;
            while (array[j] > pivot) j--;

            // Поменяем местами элементы
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        // Вызов рекурсии для сортировки подмассивов
        if (low < j) quickSort(array, low, j);
        if (high > i) quickSort(array, i, high);
    }
}

/* -------------------------------------------------

Быстрая сортировка.
Исходный массив: [3, 6, 9, 11, 4, 14, 9, 11, 13, 12]
Отсортированный: [3, 4, 6, 9, 9, 11, 11, 12, 13, 14]

 */