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

/* -------------------------------------------

Получить список файлов в директории: src/main/java/files/
..
ListFiles.java

 */