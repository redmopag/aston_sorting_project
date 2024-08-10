package aston.course_project.sorting.FillArraysOptions;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class FillArrayFromFileOption implements ArrayFillOption {

    @Override
    public <K> List<K> fillArray() throws Exception {
        List<K> list = new ArrayList<>();

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            while(true) {
                list.add((K) ois.readObject());
            }
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
