/**
 *
 *  @author Święcicki Grzegorz S20978
 *
 */

package zad3;


import zad2.MyFunction;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
  public static void main(String[] args) {

    MyFunction<String, List<String>> flines = x -> Files.readAllLines(Paths.get(x));

    Function<List<String>,String> join = x -> String.join("",x);

    Function<String,List<Integer>> collectInts = x -> {
      List <Integer> list = new ArrayList<>();
      Pattern p = Pattern.compile("\\d+");
      Matcher m = p.matcher(x);
      while (m.find()) {
        list.add(Integer.valueOf(m.group()));
      }
      return list;
    };

    Function<List<Integer>,Integer> sum = x -> {
      int result = 0;
      for (Integer el : x){
        result += el;
      }
      return result;
    };

    String fname = System.getProperty("user.home") + "/LamComFile.txt"; 
    InputConverter<String> fileConv = new InputConverter<>(fname);
    List<String> lines = fileConv.convertBy(flines);
    String text = fileConv.convertBy(flines, join);
    List<Integer> ints = fileConv.convertBy(flines, join, collectInts);
    Integer sumints = fileConv.convertBy(flines, join, collectInts, sum);

    System.out.println(lines);
    System.out.println(text);
    System.out.println(ints);
    System.out.println(sumints);

    List<String> arglist = Arrays.asList(args);
    InputConverter<List<String>> slistConv = new InputConverter<>(arglist);  
    sumints = slistConv.convertBy(join, collectInts, sum);
    System.out.println(sumints);

    // Przy powierzchownej implementacji
    // następujący fragment:
    slistConv.convertBy(collectInts, sum); // [1] spowoduje powstanie wyjątku ClassCastException

    // Zadania badawcze:
    // jak temu zaradzić w fazie kompilacji programu, tak by kompilator oznaczył [1] jako błąd
    // - wymaga odpowiedniej definicji klasy InputConverter, wszelkie modyfikacje klasy Main są też dozwolone, 
    // ale niekonieczne (a nawet niepotrzebne)  
  }
}
