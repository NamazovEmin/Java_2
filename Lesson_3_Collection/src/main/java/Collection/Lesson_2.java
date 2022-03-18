package Collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Lesson_2 {
    public static void main(String[] args) {
        String[] array = {"Тигр", "Собка","Крыса", "Хомяк","Слон", "Жираф","Бизон", "Буйвол","Мамонт", "Тигр","Гепард", "Ягуар","Анаконда", "Барс","Лев", "Макака","Арангутанг"};
        Set<String> newName = new HashSet<>(Arrays.asList(array));
        System.out.println(newName);
        for( int i = 0; i < array.length; i++){
            int result = 0;
            for (int y = 0; y < array.length; y++){
                if (array[i] == array[y]){
                    result = result +1;
                }
            }
            System.out.println("Слово " + array[i] + " встречается " + result + " раз");
        }

    }


}
