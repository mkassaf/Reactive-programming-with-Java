import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class ValidArrangementOfPairs {


    public static void main(String[] args) {
        int[][] array2 = {{8,5},{8,7},{0,8},{0,5},{7,0},{5,0},{0,7},{8,0},{7,8}};
        //[[8,0],[0,7],[7,8],[8,7],[7,0],[0,5],[5,0],[0,8],[8,5]]
        int[][] array = {{17,18},{18,10},{10,18}};
        ValidArrangementOfPairs o = new ValidArrangementOfPairs();
        int[][] res = o.validArrangement(array2);
        for (int[] re : res) {
            System.out.print( "[");
            for (int r : re){
                System.out.print(r + ",");
            }
            System.out.print( "]");

        }

    }


    public int[][] validArrangement(int[][] pairs) {

        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        for (int[] pair : pairs){
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.add(pair[0]);
            tmp.add(pair[1]);
            input.add(tmp);
        }
        ArrayList<ArrayList<Integer>> result = validArrangement(input);
        int[][] array = new int[result.size()][2];
        for (int i=0; i< result.size(); i++){
            array[i][0] = result.get(i).get(0);
            array[i][1] = result.get(i).get(1);
        }
        return array;
    }

    public ArrayList<ArrayList<Integer>> validArrangement(ArrayList<ArrayList<Integer>> pairs) {
        if (pairs.size() == 1){
            return pairs;
        }
        ArrayList<ArrayList<Integer>> result = null;
        for (ArrayList<Integer> pair : pairs){
            ArrayList<ArrayList<Integer>> innerResult = validArrangement(pair, pairs, new HashMap<>());
            if (innerResult != null && (result == null || result.size() < innerResult.size())){
                result = innerResult;
            }
        }
        return result;

    }

    private ArrayList<ArrayList<Integer>> validArrangement(ArrayList<Integer> pair, ArrayList<ArrayList<Integer>> pairs, HashMap<String,ArrayList<ArrayList<Integer>>> memo) {
        if (pairs.size() == 0){
            return null;
        }

        String key = pair.get(0) + "" + pair.get(1);
        if (memo.containsKey(key)){
            return memo.get(key);
        }
        ArrayList<ArrayList<Integer>> copy = new ArrayList<>();
        pairs.forEach( element -> {
            if(element != pair){
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(element.get(0));
                tmp.add(element.get(1));
                copy.add(tmp);
            }
        });
        ArrayList<ArrayList<Integer>> result = null;
        ArrayList<ArrayList<Integer>> innerResult = null;
        for(int i=0; i< copy.size(); i++) {
            ArrayList<Integer> nextPair = copy.get(i);
            if (pair.get(1).equals(nextPair.get(0))) {

                innerResult = validArrangement(nextPair, copy, memo);
                if (innerResult == null){
                    innerResult = new ArrayList<>();
                }
                if (result == null || innerResult.size()+1 > result.size()){
                    result = innerResult;
                }
            }
        }
        if (result == null ){
            result = new ArrayList<>();

        }
        result.add(0, pair);
        memo.put(key, result);
        return result;

    }
}

/*
[[856,705],[705,75],[75,547],[547,798],[798,838],[838,141],[141,547],[547,229],[229,699],[699,229],[229,458],[458,905],[905,458],[458,175],[175,705],[705,545],[545,826],[826,699],[699,458],[458,356],[356,578],[578,229],[229,838],[838,826],[826,483],[483,856],[856,141],[141,856],[856,92],[92,398],[398,586],[586,141],[141,132],[132,262],[262,838],[838,699],[699,157],[157,458],[458,92],[92,974],[974,15],[15,157],[157,489],[489,928],[928,157],[157,671],[671,156],[156,838],[156,671],[671,928],[928,771],[771,545],[545,132],[132,229],[229,856],[856,586],[586,398],[398,771],[771,141],[141,838],[838,671],[671,92],[92,458],[458,15],[15,141],[141,819],[819,537],[537,586],[586,92],[92,798],[798,15],[15,856],[856,157],[157,856],[856,798],[798,826],[826,905],[905,175],[175,473],[473,175],[175,141],[141,905],[905,974],[974,928],[928,671],[671,75],[75,262],[262,457],[457,398],[398,175],[175,856],[856,545],[545,15],[15,771],[771,905],[905,838],[838,356],[838,974],[974,473],[473,262],[262,458],[458,928],[928,229],[229,157],[157,928],[928,356],[356,124],[124,356],[356,489],[356,157],[157,771],[771,92],[92,132],[132,798],[798,262],[262,771],[771,928],[928,75],[75,974],[974,905],[905,699],[699,928],[928,141],[141,458],[458,974],[974,157],[157,75],[75,578],[578,892],[892,157],[157,15],[15,458],[458,157],[157,92],[92,819],[819,124],[124,537],[537,905],[905,826],[826,92],[92,537],[537,974],[974,578],[578,473],[473,398],[398,928],[928,705],[705,458],[458,547],[547,141],[141,262],[262,974],[974,489],[489,547],[547,175],[175,892],[892,586],[586,856]]
[[156,838],[838,356],[356,489],[489,547],[547,141],[141,262],[262,974],[974,489],[489,928],[928,705],[705,458],[458,547],[547,175],[175,892],[892,586],[586,856],[856,705],[705,545],[545,15],[15,458],[458,157],[157,92],[92,537],[537,905],[905,826],[826,92],[92,819],[819,124],[124,537],[537,974],[974,578],[578,473],[473,398],[398,928],[928,141],[141,458],[458,974],[974,157],[157,15],[15,771],[771,928],[928,75],[75,578],[578,892],[892,157],[157,75],[75,974],[974,905],[905,699],[699,928],[928,356],[356,157],[157,771],[771,92],[92,132],[132,798],[798,262],[262,771],[771,905],[905,838],[838,974],[974,473],[473,262],[262,458],[458,928],[928,229],[229,157],[157,928],[928,671],[671,75],[75,262],[262,457],[457,398],[398,175],[175,856],[856,545],[545,132],[132,229],[229,856],[856,798],[798,826],[826,905],[905,974],[974,928],[928,771],[771,141],[141,905],[905,175],[175,141],[141,819],[819,537],[537,586],[586,92],[92,798],[798,15],[15,856],[856,157],[157,856],[856,586],[586,398],[398,771],[771,545],[545,826],[826,483],[483,856],[856,92],[92,458],[458,15],[15,141],[141,838],[838,671],[671,92],[92,974],[974,15],[15,157],[157,671],[671,156],[156,671],[671,928],[928,157],[157,458],[458,92],[92,398],[398,586],[586,141],[141,132],[132,262],[262,838],[838,699],[699,458],[458,356],[356,124],[124,356],[356,578],[578,229],[229,838],[838,826],[826,699],[699,229],[229,458],[458,905],[905,458],[458,175],[175,473],[473,175],[175,705],[705,75],[75,547],[547,798],[798,838],[838,141],[141,856],[856,141],[141,547],[547,229],[229,699],[699,157],[157,489]]



 */
