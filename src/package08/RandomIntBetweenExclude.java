package package08;

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
        List<Integer> excludeList = stream(exclude).collect(toList());
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
        List<Integer> excludeList = stream(exclude).collect(toList());
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
