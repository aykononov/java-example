package algorithms;

import java.util.Arrays;

public class AlgorithmSelectionSort {

    public static void main(String[] args) {
        final int LEN = 10;
        int[] arrays = genarateIntArrays(LEN);

        System.out.println("Cортировка выбором.");
        System.out.println("Исходный массив: " + Arrays.toString(arrays));

        selectionSort(arrays);

        System.out.println("Отсортированный: " + Arrays.toString(arrays));
    }

    /**
     * Метод меняет местами элементы в индексах i и j
     */
    private static void swapElements(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * Метод находит индекс с наименьшим значением,
     * начиная с индекса при запуске (включительно)
     * и двигаясь к концу массива.
     */
    private static int indexLowest(int[] array, int start) {
        int lowIndex = start;
        for (int i = start; i < array.length; i++) {
            if (array[i] < array[lowIndex]) {
                lowIndex = i;
            }
        }
        return lowIndex;
    }

    /**
     * Метод сортирует элементы (на месте) с помощью сортировки выбором
     */
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int j = indexLowest(array, i);
            swapElements(array, i, j);
        }
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
}

/* -----------------------------------

Cортировка выбором.
Исходный массив: [5, 3, 9, 12, 6, 7, 8, 14, 17, 10]
Отсортированный: [3, 5, 6, 7, 8, 9, 10, 12, 14, 17]

*/