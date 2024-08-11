package aston.course_project.sorting.FillArraysOptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class RandomIntegersOption implements ArrayFillOption {

    public static List<? super Number> getRandomDiceNumber(int numberOfElements) {
        List<? super Number> list = new ArrayList<>();

        for (int i = 0; i < numberOfElements; i++) {
            list.add((int)(Math.random() * 1000));
//            list.add((Math.random() * 1000)); For double
        }
        return list;
    }

    @Override
    public <K> List<K> fillArray() throws Exception {
        System.out.println("Введите количество элементов:");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();

        List<K> listOfNumbers = new ArrayList<>((Collection<? extends K>) getRandomDiceNumber(x));

        return listOfNumbers;
    }
}