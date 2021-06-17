package co.com.mini.ecommerce.Application.commons;

public class Validate {

    public static void notNull(Object value, String message) {
    if(value==null || value == "0"){
        throw new NullPointerException(message);
    }
    }
    public static void istrue (boolean condition, String message){
        if(!condition){
            throw new IllegalArgumentException(message);
        }
    }
    public static void MoreThanOne(Object value, String message){
    int Number = (Integer)value;
        if(Number <= 1 ){
        throw new IllegalArgumentException(message);
        }else if(value==null ){
            throw new NullPointerException(message);
        }
    }
    public static void characterMax (String value, String message){

        if (value.length()>100){
            throw new IllegalArgumentException(message);
        }
    }
    public static void characterMax280 (String value, String message){

        if (value.length()>280){
            throw new IllegalArgumentException(message);
        }
    }
    public static void Lowerthanzero (float value, String message ){

        if(value<0){
            throw new IllegalArgumentException(message);
        }
    }
    public static void BetweenZeroandOne (float value,String message){
        if(value<0 || value>1){

            throw new IllegalArgumentException(message);
        }
     }
    public static void QuantityLower (int value, String message){

        if(value<0){
            throw new IllegalArgumentException(message);
        }

    }
}
