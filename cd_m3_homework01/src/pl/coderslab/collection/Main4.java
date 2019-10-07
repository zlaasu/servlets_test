package pl.coderslab.collection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main4 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("assets/people.csv"));
        List<Person> personList= new ArrayList<>();
        Map<Integer, List<Person>> peopleByAge = new HashMap<>();

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] split = line.split(",");
            if (isEmail(split[0]) && isOnlyLetters(split[1]) && isOnlyLetters(split[2]) && isOnlyNumber(split[3]) && isOnlyLetters(split[4])) {
                personList.add(new Person(split[1], split[2], Integer.valueOf(split[3]), split[4]));
            }
        }

        for (int i = 0; i < personList.size(); i++) {
            List<Person> personListByAge = peopleByAge.get(personList.get(i).getAge());
//            if (personListByAge == null) {
//                personListByAge = (List<Person>) personList.get(i);
//            } else {
//                personListByAge.add(personList.get(i));
//            }
//            personListByAge.add(personList.get(i));
            peopleByAge.put(personList.get(i).getAge(), personListByAge);
        }
    }

    private static boolean isEmail (String string) {
        String reg = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
        return string.matches(reg);
    }

    private static boolean isOnlyLetters (String string) {
        String reg = "^[a-zA-Z]+$";
        return string.matches(reg);
    }

    private static boolean isOnlyNumber (String string) {
        String reg = "^[0-9]+$";
        return string.matches(reg);
    }


}


