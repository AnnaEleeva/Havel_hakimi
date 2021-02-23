import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
      //  Havel_Hakimi hh = new Havel_Hakimi();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(reader.readLine());
        int countGoodGraphs=0;
        long m = System.currentTimeMillis();
     /*   Integer [] source=new Integer[n-2];
        //arr[0]=n;


        for(int i=0;i<n-2;i++){
            source[i]=n-2-i;
        }
        System.out.println(Arrays.toString(source));
        System.out.println("");*/
        Integer [] arr=new Integer[n-1];
        for(int i=0;i<n-1;i++){
            arr[i]=n-2; //pow vertex
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("");

      //  PermutationsWithRepetition gen = new PermutationsWithRepetition(arr, n-1);

      //  Integer[][] variations = gen.getVariations();
        int i=0;
        int sumGood=0;
    /*    for (Integer[] s : variations) {

           // System.out.println(i+" "+Arrays.toString(s));
            ArrayList<Integer> arrWithUniversalVertex=new ArrayList<>();
            Collections.addAll(arrWithUniversalVertex, s);
            arrWithUniversalVertex.add(0,n-1);
            printList(arrWithUniversalVertex);
            boolean isGood=Havel_Hakimi.performHavelHakimi(arrWithUniversalVertex);
            if(isGood) sumGood++;
            System.out.println(isGood);
            i=i+1;
        }*/
        System.out.println("sum Good for one vertex: "+sumGood);
        System.out.println("answer: "+(sumGood*n));
        System.out.print((double) (System.currentTimeMillis() - m));


    }
    public static void printList(ArrayList<Integer> arrayList){
        for(int i=0;i<arrayList.size();i++){
            System.out.print(arrayList.get(i)+" ");
        }
        System.out.println();
    }
}
