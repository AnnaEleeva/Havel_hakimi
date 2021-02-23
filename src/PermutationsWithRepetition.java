import java.util.Arrays;


public class PermutationsWithRepetition {
    private Integer[] source;
    private int variationLength;

    public PermutationsWithRepetition(Integer[] source, int variationLength) {
        this.source = source;
        this.variationLength = variationLength;
    }

    public Integer[][] getVariations() {
        int srcLength = source.length; //4
        int permutations = (int) Math.pow(srcLength, variationLength);//2 в 3 =8 (1,2)

        Integer[][] table = new Integer[permutations][variationLength]; //8 строк по 3 числа

        for (int i = 0; i < variationLength; i++) { //цикл от 0 до 3 (0 1 2)
            int t2 = (int) Math.pow(srcLength, i); //2 в 0, 2 в 1, 2 в 2 (1,2,4)
            for (int p1 = 0; p1 < permutations;) { //от 0 до 8 заполняем 8 строк
                for (int al = 0; al < srcLength; al++) { //от 0 до 2
                    for (int p2 = 0; p2 < t2; p2++) {
                        table[p1][i] = source[al];
                        System.out.println("p1 "+p1);
                        System.out.println("i "+i);
                        System.out.println("table [p1] "+Arrays.toString(table[p1]));
                        p1++;
                    }
                }
            }
        }
        System.out.println("");
        return table;
    }

    public static void main(String[] args) {
       PermutationsWithRepetition gen = new PermutationsWithRepetition(
                new Integer[]{1, 2, 3, 4},
                4);

        Object[][] variations = gen.getVariations();
        int i=0;
        for (Object[] s : variations) {

            System.out.println(i+" "+Arrays.toString(s));
            i=i+1;
        }
       // myPermutation(4);
    }

    public  static void myPermutation(int countVertex){
        int univeralVertexPow=countVertex-1;
        Integer [] arr=new Integer[countVertex-1];
        //arr[0]=n;

        for(int i=0;i<countVertex-1;i++){
            arr[i]=countVertex-2; //pow vertex
        }
        System.out.println("future start pows "+Arrays.toString(arr));

        Integer [] source=new Integer[countVertex-2];
        //arr[0]=n;


        for(int i=0;i<countVertex-2;i++){
            source[i]=countVertex-2-i;
        }
        System.out.println("source "+Arrays.toString(source));
        System.out.println("");

        Integer[] tempArr=arr;
        for (int i = source.length;i > 1; i--) {
            for (int al = 0; al < source.length; al++) {

                tempArr[i] = source[al]; //i =source.length
                System.out.println("tempArr " + Arrays.toString(tempArr));


            }
            System.out.println("");
        }




    }
}