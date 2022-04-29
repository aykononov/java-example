package algorithms;

import java.util.Arrays;

public class ShakerSortExample {
    public static void main(String[] args) {
        int[] arrays = newArrsRandom(10);
        System.out.println("Шейкерная сортировка.");
        System.out.println("Исходный массив: " + Arrays.toString(arrays));
        System.out.println("Отсортированный: " + Arrays.toString(shakerSort(arrays)));
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
     * Метод Шейкерной сортировки с аргументом типа целочисленный массив
     */
    private static int[] shakerSort(int[] A) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i <= A.length - 2; i++) {
                if (A[i] > A[i + 1]) {
                    //проверяем, находятся ли два элемента в нерпавильном порядке
                    int temp = A[i];
                    A[i] = A[i + 1];
                    A[i + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                //здесь мы можем выйти из внешнего цикла, если обменов не произошло
                break;
            }
            swapped = false;
            for (int i = A.length - 2; i >= 0; i--) {
                if (A[i] > A[i + 1]) {
                    int temp = A[i];
                    A[i] = A[i + 1];
                    A[i + 1] = temp;
                    swapped = true;
                }
            }
            //если никакие элементы не были заменены, то список отсортирован
        } while (swapped);

        return A;
    }
}

/* --------------------------------------------------

Шейкерная сортировка.
Исходный массив: [6, 10, 2, 9, 6, 6, 10, 9, 17, 18]
Отсортированный: [2, 6, 6, 6, 9, 9, 10, 10, 17, 18]

 */