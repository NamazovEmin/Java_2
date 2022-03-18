package Collection;

import java.util.HashMap;
import java.util.Map;

public class Phonebook {
    public static void main(String[] args) {
        HashMap<String , String> fonebook = new HashMap();
        String surname = "Головин";
        addToFonebook(fonebook);
        getFromFonebook(fonebook, surname);

    }

    public static void addToFonebook(HashMap fonebook){
        fonebook.put("89267033362", "Головин");
        fonebook.put("89267033352", "Головин");
        fonebook.put("89267033355", "Намазов");
        fonebook.put("89267011155", "Чикина");

    }
    public static void getFromFonebook(HashMap fonebook, String surname){
        fonebook.forEach((key, value) -> {
            if (value == surname){
                System.out.println(key);
            }
        });
    }

}
