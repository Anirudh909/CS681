package edu.umb.cs681.hw17;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PVI {
    public List<List<String>> PVI(){
        try(Stream<String> lines = Files.lines(Path.of("pvi.csv"))){
            List<List<String>> matrix = lines.map(line -> {
                return Stream.of( line.split(",") ).map(value->value.substring(0, value.length()))
                        .collect( Collectors.toList() ); }).collect( Collectors.toList());
            return matrix;
        } catch (IOException ex) {}
        return null;
    }
    public static void main(String[] args) throws IOException {

      PVI pvi = new PVI();
      List<List<String>> matrix = pvi.PVI();

      ArrayList<Double> massPvi = new ArrayList<>();
      for(int i = 1; i < matrix.size(); i++){
          if(matrix.get(i).get(3).contains("Massachusetts")) {
              String pviString = matrix.get(i).get(0);
              double pviValue = Double.parseDouble(pviString.substring(1, pviString.length() - 1));
              massPvi.add(pviValue);
          }
      }

      double averagePvi = massPvi.stream().parallel().reduce(new double[2], (result, pviAvg) ->{
          double average = ((result[0] * result[1]) + pviAvg)/(result[0]+1);
          result[0]++;
          result[1] = average;
          return result;},(finalResult, intermediateResult) -> finalResult)[1];
      System.out.println("Average PVI values of Mass counties: " + averagePvi);
  }
}
