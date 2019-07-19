import java.io.*;
import java.util.*;

public class WorkWithFile {
    private final static String path = "/Users/antonvoloshyn/Desktop/FS.txt";

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Map<String, String> word = new HashMap<>();
        word.put("line", "Anton");
        word.put("Line", "LOL");
//        System.out.println(replacer(word));
//        fileContentMerger(word);
        System.out.println(checkWord("LOL"));
    }


    private static String replacer(Map<String, String> map) {
        String stringFile = "";
        String stroka = "";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){


            while ((stringFile = bufferedReader.readLine()) != null) {
                stroka += stringFile + "\n";
            }
            for (String s : map.keySet()) {
                String key = s;
                stroka = stroka.replaceAll(key, map.get(key));
            }

            FileWriter fileWriter = new FileWriter(path);
            fileWriter.write(stroka);
            fileWriter.flush();

            bufferedReader.close();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return stroka;
    }

    private static File fileContentMerger(Map<String, String> map) throws IOException {

        String stringFile = "";
        String stroka = "";
        String stringOld = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

            while ((stringFile = bufferedReader.readLine()) != null) {
                stringOld += stringFile + "\n";
                stroka += stringFile + "\n";
            }
            for (String s : map.keySet()) {
                String key = s;
                stroka = stroka.replaceAll(key, map.get(key));
            }

            FileWriter fileWriter = new FileWriter(path);
            fileWriter.write(stringOld);
            fileWriter.write(stroka);
            fileWriter.flush();

            bufferedReader.close();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new File(path);
    }

    private static int checkWord(String word) {
        String stringFile = "";
        String stroka = "";
        int count = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

            while ((stringFile = bufferedReader.readLine()) != null) {
                for (String s : stringFile.split(" ")) {
                    if (s.equalsIgnoreCase(word)) {
                        count++;
                    }
                }
            }

            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return count;
    }
}


//        Создать метод, который заменяет слова в файле (File) и возвращает строку (String) с заменёнными значениями.
//        String replacer(Map map)

// Map Key a Value
///Users/antonvoloshyn/Text