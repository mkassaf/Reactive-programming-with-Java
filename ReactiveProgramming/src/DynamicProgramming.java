package com.company;

import java.util.*;

public class DynamicProgramming {

public static void main(String[] args) {

        /*
        ArrayList<String> wordBank = new ArrayList<>();
        wordBank.add("a");
        wordBank.add("aaa");
        wordBank.add("aa");
        wordBank.add("aaaaaaa");
        wordBank.add("aaaaaaaaaa");
        wordBank.add("aaaaaaaaaaaaa");
        wordBank.add("purpl");
        System.out.println(constructFromWorkBank(wordBank, "aaaaaaaaaaaaaaaaaaaaaaaaaa", new HashMap<>()));
        */


       // int [] array = new int[]{1,2,5,25};
        //System.out.println(bestSum(array, 100));



        // Print and display the updated List
        System.out.println("canConstruct " + canConstruct(new String[]{"ab", "abc", "cd", "def", "abcd"}, "abcdef"));
        System.out.println("countConstruct " + countConstruct(new String[]{"ab", "abc", "cd", "c", "d", "def", "abcdef", "e", "f"}, "abcdef"));
        System.out.println("allConstruct " + allConstruct(new String[]{"ab", "abc", "cd", "c", "d", "def", "abcdef", "e", "f"}, "abcdef"));
    }

    public static ArrayList<ArrayList<String>> allConstruct(String[] words, String target){
        ArrayList<ArrayList<String>> [] db = new ArrayList[target.length() + 1];
        db[0] = new ArrayList<>();
        db[0].add(new ArrayList<>());
        for (int i=0; i < db.length; i++){
            for (String word: words ) {
                int index = word.length()+ i;
                if(index <= target.length() && target.substring(i, index).equals(word)){
                    ArrayList<ArrayList<String>> tmpList = new ArrayList<>();
                    db[i].forEach(list -> {
                        ArrayList<String> tmp = new ArrayList<>();
                        list.forEach(elemnt ->{
                            tmp.add(elemnt);
                        });
                        tmp.add(word);
                        tmpList.add(tmp);
                    });

                    if(db[index] == null) {
                        db[index] = tmpList;
                    } else {
                        tmpList.forEach( list -> {
                            db[index].add(list);
                        });
                    }

                }
            }
        }
        return db[target.length()];
    }
    public static int countConstruct(String[] words, String target){
        int[] db = new int[target.length() + 1];
        db[0] = 1;
        for (int i=0; i < db.length; i++){
            for (String word: words ) {
                int index = word.length()+ i;
                if(index <= target.length() && target.substring(i, index).equals(word)){
                    db[index] += db[i];
                }
            }
        }
        return db[target.length()];
    }

    public static boolean canConstruct(String[] words, String target){
        boolean[] db = new boolean[target.length() + 1];
        db[0] = true;
        for (int i=0; i < db.length; i++){
            if (db[i]){
                for (String word: words ) {
                    int index = word.length()+ i;
                    if(index <= target.length() && target.substring(i, index).equals(word)){
                        db[index] = true;
                    }
                }
            }
        }
        return db[target.length()];
    }

    public static ArrayList<Integer> bestSum(int[] number, int target){
        ArrayList<Integer>[] db = new ArrayList[target + 1];
        db[0] = new ArrayList<>();

        for(int i=0; i <= target; i++){
            if(db[i] != null){
                for (int num : number){
                    int index =i + num;
                    if(index < db.length ){
                        ArrayList<Integer> tmp =new ArrayList<>();
                        db[i].stream().forEach(el -> tmp.add(el));
                        tmp.add(num);
                        if(db[i + num] == null || db[i + num].size() > tmp.size())
                            db[i + num] = tmp;
                    }

                }
            }
        }
        return db[target];


    }

    public static boolean canSum( int[] number, int target){
        boolean[] db = new boolean[target + 1];
        db[0] = true;

        for(int i=0; i <= target; i++){
             if(db[i] == true){
                 for (int num : number){
                     int index =i + num;
                     if(index < db.length )
                        db[i + num] = true;
                 }
             }
        }
        return db[target];


    }
    public static double gridTraveler( int row, int col){
        double [][]db = new double[row+1][col+1];
        db[1][1] = 1;
        for (int i=1; i <= col; i++){
            db[i][1] = 1;
        }
        for (int j=1; j<= row; j++){
            db[1][j] = 1;
        }
        for (int i=2; i<= row; i++){
            for (int j=2; j <= col; j++){
               db[i][j] = db[i][j-1] + db[i-1][j];
            }
        }

        return db[row][col];
    }
    public static double gridTraveler( int row, int col, HashMap<String, Double> memo){
        if(row <= 0 || col <= 0) return 0;
        if(row == 1 && col == 1) return 1;

        double total = 0;
        total = total + gridTraveler(row -1, col);
        total = total +  gridTraveler(row , col-1);

        return total;
    }

    public static double fib(double number){
        double prev = 1;
        double current = 1;
        double total = 1;
        for (int i=2; i < number; i++){
            total = (prev + current);
            prev = current;
            current = total;
        }
        return total;

    }

    public static ArrayList<ArrayList<String>> constructFromWorkBank(ArrayList<String> words, String target, HashMap<String, ArrayList<ArrayList<String>>> memo) {
        ArrayList<ArrayList<String>> fResult = new ArrayList<>();
        if(target.isEmpty()) {
            fResult.add(new ArrayList<>());
        }
        if (memo.containsKey(target)) return memo.get(target);
        words.forEach( word -> {
            if(target.startsWith(word)){
                ArrayList<ArrayList<String>> result = constructFromWorkBank(words, target.substring(word.length()), memo);
                result.forEach( list -> {
                    ArrayList<String> re = new ArrayList<>();
                    re.add(word);
                    list.forEach( r -> re.add(r));
                    fResult.add(re);
                });
            }
        });
        memo.put(target, fResult);
        return fResult;
    }
    public static String encode(String input){
       // ; 4A3B2C1D2A
        String result = "";
        int count = 0;
        Character prev = input.charAt(0);
        for (Character ch: input.toCharArray()) {
            if(ch != prev){

                result += count + "" + prev;
                prev = ch;
                count = 1;
            } else {
                count++;
            }
        }
        result += count + "" + prev;
        return result;


    }

    public static int trap(int[] height) {
        int total = 0;

        boolean isNotDone = true;
        boolean pref = false;
        while(isNotDone){
            int tmp = 0;
            isNotDone = false;
            for(int i=0; i< height.length; i++){

                if(height[i] > 0){
                    pref = true;
                    total = total + tmp;
                    tmp = 0;
                    isNotDone = true;
                }else if(height[i] <= 0){
                    pref = false;
                    tmp++;
                }

                height[i]--;

            }
        }
        return total;
    }


    public static ArrayList<Integer>  solution(ArrayList<Integer> number, int tragret, HashMap<Integer, ArrayList<Integer>> memo) {
        if(memo.containsKey(tragret)) return memo.get(tragret);
        if(tragret == 0) return new ArrayList<>();
        if(tragret < 0) return null;
        ArrayList<Integer> shortest = null;
        for (Integer num: number) {
            int reminder = tragret - num;
            ArrayList<Integer> result = solution(number, reminder, memo);
            if(result != null){
                result.add(num);
                if(shortest == null  || result.size() < shortest.size()){
                    for (Integer r: shortest) {
                        shortest.remove(r);
                    }
                }
            }

        }
        memo.put(tragret , shortest);

        return shortest;
    }


}
