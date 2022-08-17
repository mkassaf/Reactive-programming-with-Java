import java.util.*;
import java.util.stream.Collectors;

public class ReconstructItinerary {

    public static void main(String[] args) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();

        pQueue.add(5);
        pQueue.add(1);
        System.out.println(pQueue);
        pQueue.add(2);
        System.out.println(pQueue);
        pQueue.add(6);
        pQueue.add(3);
        while (!pQueue.isEmpty()) {
            System.out.println(pQueue.poll());
        }

    }

    LinkedList<String > result;

    public List<String> findItinerary(List<List<String>> tickets) {

        result=new LinkedList<>();
        HashMap<String, LinkedList<String>> map=new HashMap<>();
        for (List<String> ticket:tickets){

            String src= ticket.get(0);
            map.putIfAbsent(src, new LinkedList<>());
            map.get(src).add(ticket.get(1));
        }
        map.forEach((key,value)-> Collections.sort(value));
        String start = "JFK";
        findItinerary(start, map);

        return result;
    }

    private void findItinerary(String start, HashMap<String, LinkedList<String>> map) {
        if (map.containsKey(start)){
            LinkedList<String> desList = map.get(start);
            while (!desList.isEmpty()){
                String destination= desList.pollFirst();
                findItinerary(destination, map);
            }
        }
        result.offerFirst(start);
    }


    /*

["JFK","AXA","TIA","AUA","AXA","AUA","ADL","EZE","TIA","ADL","EZE","ADL","ANU","AUA","ANU","EZE","ANU","JFK","AXA","EZE","HBA"]
["JFK","AXA","AUA","ADL","ANU","AUA","ANU","EZE","ADL","EZE","ANU","JFK","AXA","EZE","TIA","AUA","AXA","TIA","ADL","EZE","HBA"]


     */


}
