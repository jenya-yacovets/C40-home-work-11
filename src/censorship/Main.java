package censorship;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        List<String> blackList = Files.readAllLines(Paths.get("black_list.txt"));

        String text = Files.readString(Paths.get("text.txt"));
        List<String> textList = Arrays.asList(text.split("\\."));

        int countFind = 0;
        List<String> findStr = new ArrayList<>();

        // цикл по предложениям
        for(String str : textList) {
            str = str.toLowerCase();
            List<String> strList = Arrays.asList(str.trim().split(" "));

            // цикл по словам из предложния
            for (String oneStr : strList) {

                // цикл по словам из blackList
                for(String blackStr : blackList) {
                    if (oneStr.indexOf(blackStr.trim().toLowerCase()) != -1) {
                        countFind++;
                        findStr.add(str);
                    }
                }
            }
        }

        if (countFind > 0) {
            System.out.println("Найдено " + countFind + " слов из черного списка");
            System.out.println("\nПредложения в которых есть недопустимые слова:");
            System.out.println(findStr);
        } else {
            System.out.println("Текст прошел на проверку");
        }
    }
}
