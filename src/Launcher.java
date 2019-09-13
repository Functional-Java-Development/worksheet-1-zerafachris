import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.lang.Math.abs;


public class Launcher {

    public static int getRandomInteger(final int value) {
        return (int) (100000.0 * Math.random());
    }

//    public static List<Integer> IntegerFactors(final int number) {
//        List<Integer> factors = new ArrayList<Integer>();
//        for (int i = 1; i <= number; ++i) {
//            if (number % i == 0) {
//                factors.add(i);
//            }
//        }
//        return factors;
//    }

    public static void main(String[] args) {
//        Question 1:
        final var randomPositiveIntegers = new Integer[100];
        Arrays.setAll(randomPositiveIntegers, Launcher::getRandomInteger);

        final Comparator<Integer> shortCompare = (o1, o2) -> {
            final var o1Length = o1.toString().length();
            final var o2Length = o2.toString().length();
            if (o1Length == o2Length) {
                return o2.compareTo(o1);
            }
            return Integer.compare(o1, o2);
        };

        Arrays.sort(randomPositiveIntegers, shortCompare);
        final var arrayOut = Arrays.toString(randomPositiveIntegers);

        System.out.println("\nQuestion 1:");
        System.out.println(arrayOut);


//        Question 2:
        final var filteredList = new FilteredList<Integer>(elem -> elem % 2 == 1);


        filteredList.add(1);
        filteredList.add(1);
        ;
        filteredList.addFirst(7);
        filteredList.addLast(5);
        //        filteredList.add(2)
        filteredList.push(9);
        filteredList.offerFirst(11);
        filteredList.offer(13);
        filteredList.offerLast(15);

        ArrayList<Integer> col1 = new ArrayList<>();
        col1.add(21);
        col1.add(23);
        col1.add(25);
        col1.add(27);
        filteredList.addAll(col1);

        ArrayList<Integer> col2 = new ArrayList<>();
        col1.add(32);
        col1.add(33);
        col1.add(35);
        col1.add(37);
        filteredList.addAll(col2);

        System.out.println("\nQuestion 2:");
        System.out.println(filteredList);

//        Question 3:
        System.out.println("\nQuestion 3:");
        final var advancedFilteredList = new AdvancedFilteredList<Integer>((list, element) -> {
            if (list.stream().noneMatch(elem -> abs(element) % elem == 0)) {
                return abs(element);
            }
            throw new IllegalArgumentException(String.format("Element %s should not be added to the list", element));
        }
        );


//        advancedFilteredList.add(81);
//        advancedFilteredList.add(9);
//        advancedFilteredList.add(27);
//        advancedFilteredList.addFirst(-5);
//        advancedFilteredList.addLast(14);
        advancedFilteredList.addAll(List.of(81,9,27,-5,14,15, 3, -6));


        System.out.println(advancedFilteredList);
//        System.out.println(IntegerFactors(10));
    }


}
