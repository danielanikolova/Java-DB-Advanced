import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChangeToUppercase {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String text = scan.nextLine();

        String pattern = "<upcase>([A-Za-z0-9\\s.,!?\\t]+)<\\/upcase>";

        Pattern r = Pattern.compile(pattern);

        Matcher toUpper = r.matcher(text);

        while (toUpper.find()){
            text = text.replaceAll(toUpper.group(0), toUpper.group(1).toUpperCase());
        }

        System.out.println(text);


    }

}
