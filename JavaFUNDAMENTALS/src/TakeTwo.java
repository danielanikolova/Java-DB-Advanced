import sun.swing.BakedArrayList;

import java.util.*;

public class TakeTwo {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] nums = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();


        Arrays.stream(nums)
                .filter(n -> n>=10 && n<=20)
                .distinct()
                .limit(2)
                .forEach(n -> System.out.print(n));

    }



}
