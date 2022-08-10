import java.math.BigInteger;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class Test {


    public static void main(String[] args) {
        // Create a HashMap object called capitalCities
        HashMap<String, String> capitalCities = new HashMap<String, String>();

        // Add keys and values (Country, City)
        capitalCities.put("England", "London");
        capitalCities.put("Germany", "Berlin");
        capitalCities.put("Norway", "Oslo");
        capitalCities.put("USA", "Washington DC");
        System.out.println(capitalCities);

        //capitalCities.containsKey("");
        //capitalCities.get("");

        LinkedHashMap<String, String> lhm = new LinkedHashMap<String, String>();


        lhm.keySet();

        Set<Integer> linkedHashSet = new LinkedHashSet<>();


        linkedHashSet.add(1);
        linkedHashSet.add(1);

        //ystem.out.println(linkedHashSet.contains(2));

        //System.out.println(solution("Sun", 0));//Sun
        //System.out.println(solution("Sun", 37));//Tue

        //
        System.out.println(solution("1000000000001111010101111000001111010101111") + "  " + swwwolution("1000000000001111010101111000001111010101111"));//7
        System.out.println(Integer.parseInt("1111010101111",2));//7
        //System.out.println(Integer.parseInt("00010",2));//7
        //System.out.println(Integer.parseInt("0001",2));//7


    }

    public static int solution(String S) {

        if(S.length() == 0) return 0;

        int operations = 0;
        int index = 0;

        while(index < S.length() && S.charAt(index++) == '0');
        int len = S.length() - index;
        for (int i=len; i >= 0; i--){
            operations += S.charAt(i) == '1'? 2: 1;
        }
        return operations;
    }

    private static int find(char charAt) {
        if(charAt == '0') return 1;
        if(charAt == '1') return 2;
        return 0;
    }

    public static int swwwolution(String S) {
        int operations = 0;
        try{

            Long number = Long.parseLong(S, 2);
            while (number !=0){
                if(number%2 == 0){
                    number = number/2;
                } else {
                    number = number-1;
                }
                operations++;
            }
        } catch (Exception e){

        }

        return operations;
    }

    public static String[] dayOfWeeks = new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
    public static String  solution(String S, int K) {

        int i = 0;

        for(; i<7; i++){
            if(dayOfWeeks[i].equals(S)){
                break;
            }
        }
        int index = (K + i)%7;
        return dayOfWeeks[index];
    }
}
