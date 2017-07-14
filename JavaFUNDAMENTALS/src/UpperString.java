import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class UpperString {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        List<String> names = Arrays.asList(scan.nextLine().split(" "));

        names.stream()
                .map(n -> n.toUpperCase())
                .forEach(n -> System.out.print(n + " "));

    }
}
