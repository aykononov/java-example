package algorithms;

import java.util.Arrays;

public class AlgorithmShakerSort {
    public static void main(String[] args) {
        final int LEN = 10;
        int[] arrays = newArrsRandom(LEN);

        System.out.println("Шейкерная сортировка.");
        System.out.println("Исходный массив: " + Arrays.toString(arrays));

        shakerSort(arrays);

        System.out.println("Отсортированный: " + Arrays.toString(arrays));
    }

    /**
     * Метод генерации неупорядоченного массива с указанием размерности в аргументе
     */
    private static int[] newArrsRandom(int len) {
        int[] arrRandom = new int[len];
        for (int i = 0; i < arrRandom.length; i++) {
            arrRandom[i] = (int) (i + Math.random() * 10);
        }
        return arrRandom;
    }

    /**
     * Метод реализует алгоритм Шейкерной сортировки
     */
    private static void shakerSort(int[] arrays) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i <= arrays.length - 2; i++) {
                if (arrays[i] > arrays[i + 1]) {
                    //проверяем, находятся ли два элемента в нерпавильном порядке
                    int temp = arrays[i];
                    arrays[i] = arrays[i + 1];
                    arrays[i + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                //здесь мы можем выйти из внешнего цикла, если обменов не произошло
                break;
            }
            swapped = false;
            for (int i = arrays.length - 2; i >= 0; i--) {
                if (arrays[i] > arrays[i + 1]) {
                    int temp = arrays[i];
                    arrays[i] = arrays[i + 1];
                    arrays[i + 1] = temp;
                    swapped = true;
                }
            }
            //если никакие элементы не были заменены, то список отсортирован
        } while (swapped);
    }
}

/* --------------------------------------------------

Шейкерная сортировка.
Исходный массив: [6, 10, 2, 9, 6, 6, 10, 9, 17, 18]
Отсортированный: [2, 6, 6, 6, 9, 9, 10, 10, 17, 18]

 */