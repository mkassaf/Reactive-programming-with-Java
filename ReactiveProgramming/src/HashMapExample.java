import java.util.HashMap;

public class HashMapExample {

    enum Numbers {
        ONE, TWO,THREE,FOUR,FIVE
    }
    public static void main(String[] args) {
        HashMap<String, Integer> workToNum = new HashMap<>();
        workToNum.put(Numbers.ONE.name(), 1);
        workToNum.put(Numbers.TWO.name(), 2);
        workToNum.put(Numbers.THREE.name(), 3);
        workToNum.put(Numbers.FOUR.name(), 4);
        workToNum.put(Numbers.FIVE.name(), 5);

        System.out.println(workToNum);

        System.out.println(workToNum.values());
        System.out.println(workToNum.keySet());

        System.out.println(workToNum.remove(Numbers.FOUR.name()));

        System.out.println(workToNum);




    }
}
