package aston.course_project.sorting.work_with_array;

import aston.course_project.sorting.fill_array.ArrayFactory;
import aston.course_project.sorting.custom_classes.Book;
import aston.course_project.sorting.custom_classes.Car;
import aston.course_project.sorting.custom_classes.Vegetable;
import aston.course_project.sorting.exceptions.InvalidArgumentException;
import aston.course_project.sorting.sort_strategy.SortStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class WorkWithArray {
    private ArrayFactory arrayFactory;
    private String classType;
    private String path;

    List<Book> books;
    List<Car> cars;
    List<Vegetable> vegetables;

    private final BinarySearch binarySearch = new BinarySearch();

    public void setArrayFactory(ArrayFactory arrayFactory){
        this.arrayFactory = arrayFactory;
    }

    public void setPath(String path){
        this.path = path;
    }

    public void setClassType(String classType){
        this.classType = classType;
    }

    public String getClassType() {return classType;}

    private void setClasTypeForFileInput() throws IOException {
        if(classType == null && path != null) {
            try (BufferedReader reader = Files.newBufferedReader(Paths.get(path))) {
                classType = reader.readLine().toLowerCase();
            }
        }
    }

    public void setList(int arrayLength) throws IOException, InvalidArgumentException {
        if(arrayFactory == null){
            throw new InvalidArgumentException("Вариант заполнения массива не задан");
        }

        setClasTypeForFileInput();

        switch (classType){
            case "car":
                cars = arrayFactory.fillArray(arrayLength);
                break;
            case "book":
                books = arrayFactory.fillArray(arrayLength);
                break;
            case "vegetable":
                vegetables = arrayFactory.fillArray(arrayLength);
                break;
            default:
                throw new InvalidArgumentException("Указанный класс " + classType + " не поддерживается");
        }
    }

    public <T> List<T> getList(){
        return switch (classType) {
            case "car" -> (List<T>) cars;
            case "book" -> (List<T>) books;
            case "vegetable" -> (List<T>) vegetables;
            default -> null;
        };
    }

    public void sortArray(SortStrategy sortStrategy) throws InvalidArgumentException {
        if(sortStrategy != null){
            sortStrategy.sort(getList());
        } else{
            throw new InvalidArgumentException("Сортировка не выбрана");
        }
    }

    public <T> Object binarySearch(T key){
        int index = binarySearch.binarySearch(getList(), key);
        if(index != -1) {
            return getList().get(index);
        } else {
            return null;
        }
    }
}