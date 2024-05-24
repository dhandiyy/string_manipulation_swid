import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        String inputString = "coding is fun";
        String[] inputStringArray = {"Abc", "bCd"};

        Map<Character, Integer> jumlahHuruf = numberOne(inputString);
        System.out.println(jumlahHuruf);

        String numberTwo = numberTwo(inputStringArray);
        System.out.println(numberTwo);

    }

    public static Map<Character, Integer> numberOne(String input){

        Map<Character, Integer> result = new HashMap<>();

        for(char character : input.toLowerCase().toCharArray()){
            if (Character.isLetter(character)){
                result.put(character, result.getOrDefault(character,0) + 1);
            }
        }

        return result;
    }


    public static String numberTwo(String[] input){

        Map<Character, Integer> result = new HashMap<>();

        for(String value : input){
            for(char character : value.toCharArray()){
                if(Character.isLetter(character)){
                    result.put(character, result.getOrDefault(character, 0) + 1);
                }
            }
        }
        List<Map.Entry<Character, Integer>> resultList= new ArrayList<>(result.entrySet());

        resultList.sort((e1, e2) -> {
            int countComparison = e2.getValue().compareTo(e1.getValue());
            if (countComparison == 0) {
                return e1.getKey().compareTo(e2.getKey());
            }
            return countComparison;
        });

        StringBuilder resultString = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : resultList) {
            resultString.append(entry.getKey());
        }
        return resultString.toString();
    }
}
