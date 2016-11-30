package demo.views;

public class ViewHelper {

    public static Object null2empty(Object s) {
        if (s == null) {
            return "";
        }
        return s;
    }
}
