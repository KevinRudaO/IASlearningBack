package co.com.mini.ecommerce.Application.commons;

public class StringUtils {

    public static boolean AntNon (String value){

        String trimmed =value.trim();
        return trimmed.length()>0;

    }

    public static boolean nonBlank (int value){
        String var=Integer.toString(value);
        String trimmed =var.trim();
        return trimmed.length()>0;
    }
}
