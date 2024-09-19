package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FactoryUtil {

    public static <T> List<T> GenerateObjects(Class<T> className, Integer number) {
        List<T> objects = new ArrayList<>();
        try {
            for (int i = 0; i < number; i++) {
                objects.add(className.getDeclaredConstructor().newInstance());
            }
        }catch (Exception e){
            Arrays.asList(e.getStackTrace()).forEach(System.err::println);
            System.exit(0);
        }
        return objects;
    }

    public static <T> List<T> getDistinctRandomElements(List<T> list, int numberOfElements) {
        if (numberOfElements > list.size()) {
            throw new IllegalArgumentException("Not enough elements to choose from!");
        }

        // Create a copy of the original list to avoid modifying it
        List<T> copyOfList = new ArrayList<>(list);

        // Shuffle the copy
        Collections.shuffle(copyOfList);

        // Return the first 'numberOfElements' distinct elements
        return copyOfList.subList(0, numberOfElements);
    }

}