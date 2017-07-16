package Telephony;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements CallingOther, BrowsingWorldWide{
    String number;
    String site;

    public Smartphone(String number, String site) {
        this.number = number;
        this.site = site;
    }

    public String getNumber() {
        return this.number = number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Smartphone() {
        super();
    }

    @Override
    public void callOther(String number) {
        this.number = number;

        if (!number.matches("[0-9]*")){
            System.out.printf("Invalid number!\n");
        }
        else {

            System.out.printf("Calling... %s\n", number);
        }
    }

    @Override
    public void browseWorldWide(String site) {
        this.site = site;

        if (site.matches("[^0-9]*")){
            System.out.printf("Browsing: %s!\n", site);

        }
        else {
            System.out.printf("Invalid URL!\n");
        }
    }
}
