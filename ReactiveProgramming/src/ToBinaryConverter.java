public class ToBinaryConverter {

    public static void main(String[] args) {
        toBinary(20);
        toBinary(1041);
        toBinary(7);
    }
    public static void toBinary(int decimal){
        int max = -1;
        int count = 0;
        boolean foundOne = false;
        while(decimal > 0){
            if(decimal%2 == 0){
                count++;
            } else {
                if(foundOne && max < count){
                    max = count;
                }
                count = 0;
                foundOne = true;
            };
            decimal = decimal/2;
        }

        System.out.println("Max " + max);//new line
    }

}
