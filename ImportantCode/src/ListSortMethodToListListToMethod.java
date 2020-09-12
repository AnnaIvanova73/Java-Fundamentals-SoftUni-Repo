import java.lang.reflect.Array;
import java.util.*;

public class ListSortMethodToListListToMethod {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> words = new ArrayList<>();
        words.add("Gabrovo");
        words.add("Sofia");
        words.add("Burgas");
        words.add("i az");

        //Сортира се в лексигографски ред, не азбучен. Малките букви се водят по - късно от големите букви. Сравнява ASSCI кодовете
        //Сортиране за Лист
        Collections.sort(words);
        Collections.reverse(words);

        Collections.sort(words, (a,b) -> a.toLowerCase().compareTo(b.toLowerCase()));//default поведение на метода

        Collections.sort(words, (a,b) -> a.compareTo(b));//default поведение на метода
        Collections.sort(words, Comparator.naturalOrder());//default поведение на метода


        Collections.sort(words, (a,b) -> b.compareTo(a));// в обратен ред
        Collections.sort(words, (a,b) -> a.substring(0,3).compareTo(b.substring(0,3)));// по първите три символа;
        Collections.sort(words, (a,b) -> Character.compare(a.charAt(a.length()-1),(b.charAt(b.length()-1))));// по последните символи;

        words.sort(Comparator.naturalOrder());//default поведение на метода
        Collections.sort(words, String::compareTo);//lambda метод референция

        words.sort((a, b) -> b.compareTo(a));// в обратен ред
        words.sort((a, b) -> a.substring(0, 3).compareTo(b.substring(0, 3)));// по първите три символа;
        words.sort((a, b) -> Character.compare(a.charAt(a.length() - 1), (b.charAt(b.length() - 1))));// по последните символи;

        //За Масиви

        int[] arr = new int[]{5,2,3,1};
        Arrays.sort(arr);

        String[] wordss = new String[]{"Gabrovo", "Sofia", "Burgas", "i az"};
        Collections.sort(Arrays.asList(wordss)); // работи директно върху масива не създава нов лист, промените отиват на метода


        // Масив в Лист
        String[] wordsThird = new String[]{"Gabrovo", "Sofia", "Burgas", "i az"};


        List<String> wordsList = Arrays.asList(wordsThird);// не могат да се модифицират елементите
        List<String> wordsAsList = new ArrayList<>(Arrays.asList(wordsThird)); // елементите могат да се модифицират

        //Лист в Масив
        List <String> names = new ArrayList<>();
        names.add("Anna");
        names.add("Something");
        names.add("Djvu");
        String[] wordsArr = names.toArray(new String[names.size()]);


    }
}
