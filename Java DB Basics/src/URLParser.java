import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLParser {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String url = scan.nextLine();

        String protocol = "";
        String server = "";
        String resource = "";

        String patternProtocol = "(([a-z]+)(:\\/\\/))";

        Pattern r = Pattern.compile(patternProtocol);

        Matcher prot = r.matcher(url);

        if (prot.find()){
            protocol = prot.group(2);
        }

        String patternServer = "www.[a-z]+.[a-z]+";

        Pattern k = Pattern.compile(patternServer);

        Matcher serv = k.matcher(url);

        if (serv.find()){
            server = serv.group(0);
        }

        String patternResource = "(\\/{2}[a-zA-Z0-9]+).[a-zA-Z0-9]+.[a-zA-Z0-9]+\\/([a-zA-Z0-9\\/]+)";

        Pattern l = Pattern.compile(patternResource);

        Matcher res = l.matcher(url);

        if (res.find()){
            resource = res.group(2);
        }
        char sign = '"';

        System.out.printf("[protocol] = " +  sign +"%s" + sign, protocol );
        System.out.println();
        System.out.printf("[server] = " +  sign +"%s" + sign, server );
        System.out.println();
        System.out.printf("[resource] = " +  sign +"%s" + sign, resource );
        System.out.println();


    }

}
