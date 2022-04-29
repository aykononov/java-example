package algorithms;

import java.util.Arrays;

class SearchBinary {
    // Метод создает сортированный массив
    static private int[] newArrSort (int len) {
        int[] arrSort = new int[len];
        for (int i = 0; i < arrSort.length; i++) {
            arrSort[i] = i;
        }
        return arrSort;
    }

    // Метод Бинарного поиска с входящими параметрами
    static private boolean getSearchInArr (int[] inArrs, int n) {
        int first = 0;
        int last = inArrs.length - 1;
        int i;
        while (first <= last) {
            i = (first + last) / 2;
            if (n < inArrs[i]) {
                last = i - 1;
            } else if (n > inArrs[i]) {
                first = i + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Создаем массив и выполняем поиск.");
        int[] arrs = newArrSort(10);
        System.out.println("   Исходный  массив: " + Arrays.toString(arrs));
        System.out.println("Поиск значения  (3): " + getSearchInArr(arrs, 3));
        System.out.println("Поиск значения (10): " + getSearchInArr(arrs, 10));
    }
}
/* ------------------------------------------------
Создаем массив и выполняем поиск.
   Исходный  массив: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
Поиск значения  (3): true
Поиск значения (10): false
 */