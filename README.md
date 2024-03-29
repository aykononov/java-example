## Java - Алгоритмы и полезные примеры

<details><summary>Алгоритмы на Java ...</summary><blockquote>

<details Сортировка выбором ><summary>Сортировка выбором.</summary>

```java
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
```

[AlgorithmSelectionSort.java](./src/algorithms/AlgorithmSelectionSort.java "https://github.com/aykononov/java-example/blob/master/src/algorithms/AlgorithmSelectionSort.java")

</details>

<details Пузырьковая ><summary>Пузырьковая сортировка.</summary>

Сортировка пузырьком — один из самых известных алгоритмов сортировки. Здесь нужно последовательно сравнивать значения
соседних элементов и менять числа местами, если предыдущее оказывается больше последующего. Таким образом элементы с
большими значениями оказываются в конце списка, а с меньшими остаются в начале.

Этот алгоритм считается учебным и почти не применяется на практике из-за низкой эффективности: он медленно работает на
тестах, в которых маленькие элементы (их называют «черепахами») стоят в конце массива. Однако на нём основаны многие
другие методы, например, шейкерная сортировка и сортировка расчёской.

![image info](./src/algorithms/bubbleSort.gif)

![image info](./src/algorithms/bubbleSortO.jpg)

```java
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
    private static void bubbleSort(int[] intArrays) {

        for (int i = 0; i < intArrays.length; i++) {
            for (int j = i + 1; j < intArrays.length; j++) {
                if (intArrays[i] > intArrays[j]) {
                    int temp = arrays[j];
                    intArrays[j] = intArrays[i];
                    intArrays[i] = temp;
                }
            }
        }
    }
}

/* -----------------------------------------------
Пузырьковая сортировка.
Исходный массив: [1, 7, 6, 12, 7, 7, 6, 8, 15, 17]
Отсортированный: [1, 6, 6, 7, 7, 7, 8, 12, 15, 17]

*/
```

[AlgorithmBubbleSort.java](./src/algorithms/AlgorithmBubbleSort.java "https://github.com/aykononov/java-example/blob/master/src/algorithms/AlgorithmBubbleSort.java")

</details>

<details Перемешиванием ><summary>Сортировка перемешиванием (Шейкерная сортировка).</summary>

Шейкерная сортировка отличается от пузырьковой тем, что она двунаправленная: алгоритм перемещается сначала слева
направо, затем справа налево.

![image info](./src/algorithms/shakerSort.gif)

![image info](./src/algorithms/shakerSortO.jpg)

```java
package algorithms;

import java.util.Arrays;

public class AlgorithmShakerSort {

    public static void main(String[] args) {
        final int LEN = 10;

        int[] arrays = newArrsRandom(LEN);
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
     * Метод реализует алгоритм Шейкерной сортировки с аргументом типа целочисленный массив
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
```

[AlgorithmShakerSort.java](./src/algorithms/AlgorithmShakerSort.java "https://github.com/aykononov/java-example/blob/master/src/algorithms/AlgorithmShakerSort.java")

</details>

<details Быстрая ><summary>Быстрая сортировка.</summary>

"Быстрая сортировка", хоть и была разработана более 40 лет назад, является наиболее широко применяемым и одним их
самых эффективных алгоритмов.

Метод основан на подходе "разделяй-и-властвуй" :

1. Сначала из массива выбирается опорный элемент a[p] (любой лемент массива),
2. Затем все элементы a[i] сравниваются с опорным и меньшие перемещаются влево, а большие вправо.
3. Получим массив из двух подмассивов, где элементы левого будут меньше или равны элемнтам
   правого:

        a[i] <= a[p] >= a[i]

4. А дальше рекурсивно применяем первые два шага к подмассивам слева и справа от опорного значения.

![image info](./src/algorithms/quickSort.gif)

![image info](./src/algorithms/quickSortO.jpg)

```java
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
```

[AlgorithmQuickSort.java](./src/algorithms/AlgorithmQuickSort.java "https://github.com/aykononov/java-example/blob/master/src/algorithms/AlgorithmQuickSort.java")

</details>

<details Линейный ><summary>Линенйный (Последовательный) поиск...</summary>

*Последовательный поиск (Sequential Search)*, называемый также *линейным поиском*, является самым простым из всех
алгоритмов поиска. Это метод поиска одного
значения t в коллекции С "в лоб". Он находит t, начиная с первого элемента коллекции и исследуя каждый последующий
элемент до тех пор, пока не просмотрит всю
коллекцию или пока соответствующий элемент не будет найден.

**Наилучший случай: O(1); средний и наихудший случаи: О(n)**

```java
package algorithms;

import java.util.Arrays;

// Последовательный поиск значения в неупорядоченном массиве (используя цикл foreach)
class SearchBruteForce {

    // Метод генерации неупорядоченного массива с указанием размерности в параметре
    private static int[] newArrsRandom(int len) {
        int[] arrRandom = new int[len];
        for (int i = 0; i < arrRandom.length; i++) {
            arrRandom[i] = (int) (i + Math.random() * 10);
        }
        return arrRandom;
    }

    // Метод линейного (последовательного) поиска
    private static boolean getSearch(int[] inArrs, int n) {
        for (int i = 0; i < inArrs.length; i++) {
            if (n == inArrs[i]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
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
```

[SearchBruteForce - Линенйный поиск](./src/algorithms/SearchBruteForce.java)

</details>

<details Бинарный><summary>Бинарный (двоичный) поиск...</summary>

*Бинарный (двоичный) поиск* обеспечивает лучшую производительность, чем *последовательный поиск*, поскольку работает с
коллекцией, элементы которой уже *отсортированы*.

**Наилучший случай: O(1); средний и наихудший случаи: O(log n)**

[SearchBinary - Бинарный поиск](./src/algorithms/SearchBinary.java)

</details>

<details Поиск дубликатов><summary>Поиск дубликатов...</summary>

Поиск дубликатов в массиве методом простого перебора всех элементов можно реализовать двумя вложенными циклами.

**Временная сложность - O(n²), пространственная сложность — O(1).**

[SearchSimpleDuplicate - Найти первый дубликат в массиве простым перебором](./src/algorithms/SearchSimpleDuplicate.java)

</details>

<details Пузырьковая сортировка строк><summary>Пузырьковая сортировка строк...</summary>

Реализация алгоритма Пузырьковой сортирвки для объектов типа String.

[SortBoobleString - Пример Пузырьковой сортировки строк](./src/algorithms/SortBoobleString.java)

</details>

<details ФАКТОРИАЛ><summary>Определение ФАКТОРИАЛА (используя рекурсию)...</summary>

*Факториал натурального числа n* определяется, как произведение всех натуральных чисел от 1 до n включительно.

[FactorialUsingRecursion - Определение ФАКТОРИАЛА (используя рекурсию)](./src/algorithms/FactorialUsingRecursion.java)

</details>

<details ФАКТОРИАЛ лямда><summary>Определение ФАКТОРИАЛА (используя Лямбда-выражение)...</summary>

Пример программы, где блочное Лямбда-выражение применяется для вычисления и возврата факториала целочисленного значения.

[FactorialUsingLambda - Определение ФАКТОРИАЛА (используя Лямбда-выражение)](./src/algorithms/FactorialUsingLambda.java)

</details>

<details Реверс><summary>Реверс строки в обратном порядке (используя Лямбда-выражение)...</summary>

В данном примере программы, блочное Лямбда-выражение изменяет строку на обратный порядок следования символов в этой
строке.

[ReverseStringUsingLambda - Реверс строки в обратном порядке (используя Лямбда-выражение)](./src/algorithms/ReverseStringUsingLambda.java)

</details>

<details Палиндром><summary>Палиндром...</summary>

Палиндромом считаются слова, фразы или числа, которые одинаково читаются слева направо и справа налево.

[Palindrom - Пример проверяет, является ли строка Палиндромом](./src/algorithms/Palindrom.java)
</details>

</blockquote></details>

---

<details Поиск повторяющихся слов><summary>Поиск повторяющихся слов ...</summary>

```java

package duplicate;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
/*
13.06.2023 17:24:17
На входе коллекция строк: "Привет #Москва" "Привет #Питер" "У нас хорошая #Погода а у вас" "В #Москва идет дождь" "В #Питер светит солнце"
Требуется: Найти самое популярное слово с хештегом #. Регистр не учитывать (нижний). 
           Если найдено несколько, то выводим первое в алфавитном порядке.
 */

public class FindDuplicate2 {
   public static void main(String[] args) {
      List<String> sorces = List.of("Привет #Питер",
              "У нас хорошая #Погода а у вас",
              "В #Москва идет дождь",
              "В #Питер светит солнце",
              "Привет #Москва");
      System.out.println("Исходный массив строк");
      System.out.println(Arrays.toString(sorces.toArray()));

      List<String> found = sorces.stream()
              .map(e -> e.split(" "))
              .flatMap(strings -> Arrays.stream(strings).filter(s -> s.startsWith("#")))
              .map(String::toLowerCase)
              .collect(Collectors.toList());
      System.out.println("1. Найти слова с хэштегом # и перевести в нижний регистр");
      System.out.println(found);

      Set<String> duplicate = found.stream()
              .filter(i -> Collections.frequency(found, i) > 1)
              .sorted()
              .collect(Collectors.toCollection(LinkedHashSet::new));
      System.out.println("2. Найти повторяющиеся слова и отсортировать");
      System.out.println(duplicate);

      String result = duplicate.stream().findFirst().orElse(null);
      System.out.println("3. Выводим первое по алфавиту");
      System.out.println(result);
   }
}

/* Вывод в консоль:
Исходный массив строк
[Привет #Питер, У нас хорошая #Погода а у вас, В #Москва идет дождь, В #Питер светит солнце, Привет #Москва]
1. Найти слова с хэштегом # и перевести в нижний регистр
[#питер, #погода, #москва, #питер, #москва]
2. Найти повторяющиеся слова и отсортировать
[#москва, #питер]
3. Выводим первое по алфавиту
#москва
 */

```

[FindDuplicateWords.java](./src/duplicate/FindDuplicateWords.java "https://github.com/aykononov/JavaExamples/tree/main/src/duplicate/FindDuplicateWords.java")

</details>

<details Получить список файлов><summary>Получить список файлов в директории ...</summary>

```java

package files;

import java.io.File;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Пример выводит все файлы в указанной директории + фильтр.
// Фильтрация коллекций с использованием нескольких критериев.

public class ListFiles {

    public static void main(String[] args) {
        String dir = "./src/files/";
        System.out.println("Получить список файлов в директории: " + dir + "\n..");
        for (String file : listFilesUsingJavaIO(dir)) {
            System.out.println(file);
        }
    }

    private static Set<String> listFilesUsingJavaIO(String dir) {
        return Stream.of(new File(dir).listFiles())
                .filter(file -> !file.isDirectory() &&  // фильтр: файл не является директорий
                        file.getName().startsWith("L")) // фильтр: имя файла начинается с "L"
                .map(File::getName)
                .collect(Collectors.toSet());
    }

}

/* Вывод в консоль:

Получить список файлов в директории: src/main/java/files/
..
ListFiles.java

 */

```

[ListFiles.java](./src/files/ListFiles.java "https://github.com/aykononov/JavaExamples/tree/main/src/files/ListFiles.java")

</details>

<details Читаем и записываем в текстовый файл><summary>Читаем и записываем в текстовый файл (Телефонная книга) ...</summary>

```java
/* Простая база данных телефонных номеров, построенная на основе
   чтения и записи текстового файла со списком свойств.  */

import javax.imageio.IIOException;
import java.io.*;
import java.util.Properties;

public class PhoneBookFromTextFile {
    public static void main(String[] args) throws IOException {
        Properties ht = new Properties();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name, number;
        FileInputStream fin = null;
        boolean changed = false;

        // Попытаться открыть файл phonebook.dat
        try {
            fin = new FileInputStream("src/main/java/package02/phonebook.dat");
        } catch (FileNotFoundException e) {
            // игнорировать отсутствующий файл
        }

        // Если телефонная книга уже существует, загрузить существующие телефонные номера.
        try {
            if (fin != null) {
                ht.load(fin);
                fin.close();
            }
        } catch (IIOException e) {
            System.out.println("Oшибкa чтения файла.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // разрешить пользователю вводить новые имена и номера телефонов абонентов
        do {
            System.out.println("Добавить контакт ('exit' для завершения).\n ввeдитe имя: ");
            name = br.readLine();
            if (name.equals("exit")) continue;
            System.out.println("Bвeдитe номер: ");
            number = br.readLine();
            ht.put(name, number);
            changed = true;
        } while (!name.equals("exit"));

        // сохранить телефонную книгу, если она изменилась
        if (changed) {
            FileOutputStream fout = new FileOutputStream("src/main/java/package02/phonebook.dat");
            ht.store(fout, "Телефонная книга");
            fout.close();
        }

        //искать номер по имени абонента
        do {
            System.out.println("Поиск контакта по имени ('exit' для завершения).\n ввeдитe имя: ");
            name = br.readLine();
            if (name.equals("exit")) continue;
            number = (String) ht.get(name);
            System.out.println("Контакт: " + name + ", " + number);
        } while (!name.equals("exit"));
    }
}
/* Вывод в консоль:
Добавить контакт ('exit' для завершения).
 ввeдитe имя:
alex
Bвeдитe номер:
111
Добавить контакт ('exit' для завершения).
 ввeдитe имя:
elen
Bвeдитe номер:
222
Добавить контакт ('exit' для завершения).
 ввeдитe имя:
exit
Поиск контакта по имени ('exit' для завершения).
 ввeдитe имя:
alex
Контакт: alex, 111
Поиск контакта по имени ('exit' для завершения).
 ввeдитe имя:
exit

 */
```

[PhoneBookFromTextFile.java](./src/package02/PhoneBookFromTextFile.java "https://github.com/aykononov/JavaExamples/tree/main/src/package02/PhoneBookFromTextFile.java")

</details>

<details Пример многопоточного приложения><summary>Пример многопоточного приложения с применением класса Phaser ...</summary>

```java
/* Пример многопоточного приложения с применением класса Phaser.

Класс Phaser синхронизирует потоки - он определяет объект синхронизации,
который ждет, пока не завершится определенная фаза.
Далее Phaser переходит к следующей стадии или фазе и снова ожидает ее завершения.
*/

import java.util.concurrent.Phaser;

class PhaseThread implements Runnable {
    Phaser phaser;
    String name;

    PhaseThread(Phaser phaser, String name) {
        this.phaser = phaser;
        this.name = name;

        // регистрирует текущий поток как участника
        phaser.register();
    }

    public void run() {
        System.out.println(this.name + " выполняет фазу " + phaser.getPhase());
        phaser.arriveAndAwaitAdvance(); // сообщает, что Первая фаза достигнута
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(this.name + " выполняет фазу " + phaser.getPhase());
        phaser.arriveAndAwaitAdvance(); // сообщает, что Вторая фаза достигнута
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(this.name + " выполняет фазу " + phaser.getPhase());
        phaser.arriveAndDeregister(); // сообщает о Завершении фаз и удаляет с регистрации объект
    }
}

class MultithreadingUsingPhaser {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(1); // число 1 - главный поток
        new Thread(new PhaseThread(phaser, "PhaserThread 1")).start();
        new Thread(new PhaseThread(phaser, "PhaserThread 2")).start();
        new Thread(new PhaseThread(phaser, "PhaserThread 3")).start();

        // ожидаем завершения фазы 0
        int phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");

        // ожидаем завершения фазы 1
        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");

        // ожидаем завершения фазы 2
        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");

        phaser.arriveAndDeregister();
    }
}

/* Вывод в консоль:
PhaserThread 2 выполняет фазу 0
PhaserThread 3 выполняет фазу 0
PhaserThread 1 выполняет фазу 0
Фаза 0 завершена
PhaserThread 1 выполняет фазу 1
PhaserThread 3 выполняет фазу 1
PhaserThread 2 выполняет фазу 1
Фаза 1 завершена
PhaserThread 2 выполняет фазу 2
PhaserThread 1 выполняет фазу 2
PhaserThread 3 выполняет фазу 2
Фаза 2 завершена
 */
```

[MultithreadingUsingPhaser.java](./src/package03/MultithreadingUsingPhaser.java "https://github.com/aykononov/JavaExamples/tree/main/src/package03/PhaseThreadDemo.java")

</details>

<details Получить текущую метку времени><summary>Получить текущую метку времени ...</summary>

```java
/* Получить текущую метку времени */

import java.sql.Timestamp;

public class GetCurrentTimestamp {
    public static void main(String[] args) {
        System.out.println(new Timestamp(System.currentTimeMillis()));
    }
}

/* Вывод в консоль:
2020-11-25 15:36:10.581
 */
```

[GetCurrentTimestamp.java](./src/package04/GetCurrentTimestamp.java "https://github.com/aykononov/JavaExamples/tree/main/src/package04/GetCurrentTimestamp.java")

</details>

<details Мониторинг файлов><summary>Мониторинг файлов с использованием службы наблюдения ...</summary>

```java
package package05;

/* Мониторинг файлов с использованием службы наблюдения.
 *  WatchService - Служба наблюдения, которая отслеживает зарегистрированные объекты на предмет изменений и событий. */

import java.io.IOException;
import java.nio.file.*;

class WatcherServiceExample {
    public static void main(String[] args) {

        try (WatchService watchService = FileSystems.getDefault().newWatchService()) {
            Path path = Paths.get("src/main/java/package05");
            path.register(watchService,
                    StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_DELETE,
                    StandardWatchEventKinds.ENTRY_MODIFY);
            WatchKey key;
            while ((key = watchService.take()) != null) {
                for (WatchEvent<?> event : key.pollEvents()) {
                    System.out.println(path + ": " + event.kind() + ": " + event.context());
                }
                key.reset();
            }
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}

/* Вывод в консоль:
src\main\java\package05: ENTRY_CREATE: a.txt
src\main\java\package05: ENTRY_MODIFY: a.txt
src\main\java\package05: ENTRY_DELETE: a.txt

 */
```

[WatcherServiceExample.java](./src/package05/WatcherServiceExample.java "https://github.com/aykononov/JavaExamples/tree/main/src/package05/WatcherServiceExample.java")

</details>

<details Перебор строки><summary>Перебор строки в цикле ...</summary>

```java
/* Перебор строки в цикле по символам. */
public class StringForEach {
    public static void main(String[] args) {
        String str = "Hello Java";
        System.out.print("Перебор строки в цикле: ");
        for (char c : str.toCharArray()) {
            System.out.print(c + " ");
        }
    }
}

/* Вывод в консоль:
Перебор строки в цикле: H e l l o   J a v a 
 */
```

[StringForEach.java](./src/package06/StringForEach.java "https://github.com/aykononov/JavaExamples/tree/main/src/package06/StringForEach.java")

</details>

<details Переворот строки><summary>Переворот строки ...</summary>

```java
/* Переворот строки. */
public class StringReverse {
    public static void main(String[] args) {
        String str = "Hello Java";
        System.out.print("Переворот строки: ");
        for (int i = str.length() - 1; i >= 0; i--) {
            System.out.print(str.charAt(i));
        }
    }
}

/* Вывод в консоль:
Переворот строки: avaJ olleH
 */
```

[StringReverse.java](./src/package06/StringReverse.java "https://github.com/aykononov/JavaExamples/tree/main/src/package06/StringReverse.java")

</details>

<details Найти все числа кратные 9-ти><summary>Найти все числа кратные 9-ти ...</summary>

```java
// Найти все числа кратные 9-ти.
public class ForContionue {
    public static void main(String[] args) {
        for (int i = 0; i < 82; i++) {
            // Оператор деления по модулю % - возвращает остаток от деления.
            if (i % 9 == 0) System.out.print(i + " ");
        }
    }
}

/* Вывод в консоль:
0 9 18 27 36 45 54 63 72 81 
 */
```

[ForContionue.java](./src/package07/ForContionue.java "https://github.com/aykononov/JavaExamples/tree/main/src/package07/ForContionue.java")

</details>

<details Склонение слов><summary>Склонение слов в зависимости от количества ...</summary>

```java
package package07;

// Склонение слов в зависимости от количества.
public class Declination {

    public static void main(String[] args) {
        System.out.println("1 " + getDeclination(1));
        System.out.println("2 " + getDeclination(2));
        System.out.println("5 " + getDeclination(5));
        System.out.println("21 " + getDeclination(21));
        System.out.println("52 " + getDeclination(52));
        System.out.println("105 " + getDeclination(105));
    }

    public static String getDeclination(int count) {
        String one = "день";
        String tow = "дня";
        String five = "дней";

        if (count > 100) count %= 100;
        if (count > 20) count %= 10;
        switch (count) {
            case 1:
                return one;
            case 2:
            case 3:
            case 4:
                return tow;
            default:
                return five;
        }
    }

}

/* Вывод в консоль:
1 день
2 дня
5 дней
21 день
52 дня
105 дней
 */
```

[Declination.java](./src/package07/Declination.java "https://github.com/aykononov/JavaExamples/tree/main/src/package07/Declination.java")

</details>

<details Генерация случайного числа><summary>Генерация случайного числа</summary>

```java
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Random;

/**
 * Генерация случайного числа
 */
public class RandomIntBetweenExclude {
    public static void main(String[] args) {
        System.out.println("Генерация случайного числа, исключая диапазон чисел:");
        System.out.print(nextIntExclude(1, 2, 3, 4, 5) + " ");

        System.out.println("\n");

        System.out.println("Генерация случайного числа в диапазоне min и max, исключая диапазон чисел:");
        System.out.print(nextIntBetweenExclude(7, 10, 9, 10) + " ");
    }

    // Генерация случайного числа, исключая диапазон чисел
    public static Integer nextIntExclude(final Integer... exclude) {
        int result = new Random().nextInt();
        if (exclude.length == 0) {
            return result;
        }
        List < IntegerexcludeList = stream(exclude).collect(toList());
        while (excludeList.contains(result)) {
            result++;
        }
        return result;
    }

    // Генерация случайного числа в диапазоне min и max, исключая диапазон чисел
    public static Integer nextIntBetweenExclude(final Integer min, final Integer max, final Integer... exclude) {
        int random = new Random().nextInt(max - min + 1) + min;
        int result = random;
        if (exclude.length == 0) {
            return result;
        }
        List < IntegerexcludeList = stream(exclude).collect(toList());
        if (!excludeList.contains(result) && result >= min && result <= max) {
            return result;
        }
        while (result++ != max) {
            if (!excludeList.contains(result)) {
                return result;
            }
        }
        result = random;
        while (result-- != min) {
            if (!excludeList.contains(result)) {
                return result;
            }
        }
        throw new IllegalArgumentException("Все числа из диапазона в списке на исключение!");
    }
}

```

[RandomIntBetweenExclude.java](./src/package08/RandomIntBetweenExclude.java "https://github.com/aykononov/JavaExamples/tree/main/src/package08/RandomIntBetweenExclude.java")

</details>