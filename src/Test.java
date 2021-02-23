import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Test {

    static int universalVertexPow =0;
    static int sum=0;
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(reader.readLine());
        if(n==1) {
            System.out.println(1);
            return;
        }
        universalVertexPow=n-1;
        long m = System.currentTimeMillis();
        long m2 = System.currentTimeMillis();
        int [] arr=new int[n-1];
        for(int i=0;i<n-1;i++){
            arr[i]=n-2; //pow vertex
        }
      //  System.out.println(Arrays.toString(arr));
        Test x = new Test();
        x.generatePermutations(arr);
        System.out.println("sum*n "+(sum*n)%1000000007);
        System.out.println("sum "+sum);
        System.out.print((double) (System.currentTimeMillis() - m));
    }

    private void generatePermutations(int[] intervals) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        LinkedList<Integer> linkedList=new LinkedList<>();

        generatePermutations(intervals, 0,0, linkedList);
    }

    private void generatePermutations(int[] intervals, int intpos,
                                      Integer lastPerm,LinkedList<Integer>linkedList) {

        if (intpos == intervals.length)
        {  return;}

        for (int i = 1; i <= intervals[intpos]; i++) {
            if (intpos == intervals.length - 1) {
             //   System.out.print(universalVertexPow +lastPerm + i + " ");
             //  String[] str=(universalVertexPow +lastPerm + i).split("");


               // System.out.println(i);
               // arrayList.clear();
               // arrayList.add(i);
               // arrayList.add(0,universalVertexPow);
                linkedList.addLast(i);
                linkedList.addFirst(universalVertexPow);
               /* for(int k=0;k<arrayList.size();k++){
                    System.out.print(arrayList.get(k));
                }*/
            //   System.out.print(" ");
          //      System.out.println("lastPerm "+lastPerm);
                if ((lastPerm + universalVertexPow + i) % 2 == 0) {
                   // System.out.println(Havel_Hakimi.performHavelHakimi(arrayList));
                    //if (Havel_Hakimi.performHavelHakimi(arrayList)) sum++;
                    if(performHavelHakimi(linkedList)){ sum++;
                        for(Integer e:linkedList) System.out.print(e+ " ");
                        System.out.println();

                    }

                }
               // System.out.println( Havel_Hakimi.performHavelHakimi(arrayList));
               // arrayList.remove(0);
               // arrayList.remove(arrayList.size()-1);
                linkedList.removeFirst();
                linkedList.removeLast();

            }
           // arrayList.add(i);
            linkedList.addLast(i);
            generatePermutations(intervals, intpos + 1, lastPerm + i,linkedList);
           // arrayList.remove(arrayList.size()-1);
            linkedList.removeLast();
        }
    }
 /*   public static int sumPow(ArrayList<Integer> arrPow){
        int sumPow=0;
        for(int)
    }*/

    public static boolean performHavelHakimi(LinkedList<Integer> sequence) {
        LinkedList<Integer> list = new LinkedList<>();
        for (Integer c : sequence) {
            if (c != 0) {
                list.add(c);
            }
        }
        sequence = list;
        if (sequence.size() == 0) {
            return true;
        }
     /*   LinkedList<Integer> result = new LinkedList<>();
        for (Integer integer : sequence) {
            result.add(integer);
        }
        result.sort((n1, n2) -> Integer.compare(n2, n1));*/
        sequence.sort((n1, n2) -> Integer.compare(n2, n1));


        // sequence = (LinkedList<Integer>) result;
        //  Integer x = sequence.remove(0);
        Integer x = sequence.removeFirst();
        if (x > sequence.size()) {
            return false;
        }
     /*   for (int i = 0; i < x; i++) {
            sequence.set(i, sequence.get(i) - 1);

        }*/
        ListIterator<Integer> iterator = sequence.listIterator();
        for(int i=0;i<x;i++){
            Integer next = iterator.next();
            iterator.set(next-1);
        }


        return (performHavelHakimi(sequence));


    }
}