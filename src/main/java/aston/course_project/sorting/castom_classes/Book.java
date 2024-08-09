package aston.course_project.sorting.castom_classes;

public class Book {
    private String author;
    private String title;
    private int numberPages;

    public Book(String author, String title, int numberPages) {
        this.author = author;
        this.title = title;
        this.numberPages = numberPages;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNumberPages(int numberPages) {
        this.numberPages = numberPages;
    }

    public String getAuthor() {
        return author;
    }


    public String getTitle() {
        return title;
    }

    public int getNumberPages() {
        return numberPages;
    }

}
