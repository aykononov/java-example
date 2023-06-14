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

public class FindDuplicateWords {
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

/*
Исходный массив строк
[Привет #Питер, У нас хорошая #Погода а у вас, В #Москва идет дождь, В #Питер светит солнце, Привет #Москва]
1. Найти слова с хэштегом # и перевести в нижний регистр
[#питер, #погода, #москва, #питер, #москва]
2. Найти повторяющиеся слова и отсортировать
[#москва, #питер]
3. Выводим первое по алфавиту
#москва
 */