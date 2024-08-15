package aston.course_project.sorting.custom_classes;

import aston.course_project.sorting.Parity;
import aston.course_project.sorting.exceptions.InvalidArgumentException;

public class Book implements Comparable<Book>, Parity {
    private final String author;
    private final String title;
    private final Integer pagesCount;

    private Book(Builder builder) {
        this.author = builder.author;
        this.title = builder.title;
        this.pagesCount = builder.pagesCount;
    }

    @Override
    public int compareTo(Book otherBook) {
        int result = this.author.compareTo(otherBook.author);
        if (result == 0) {
            result = this.title.compareTo(otherBook.title);
            if (result == 0) {
                result = this.pagesCount.compareTo(otherBook.pagesCount);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Book: Title - " + title + ", Author - " + author + ", Count pages - " + pagesCount;
    }

    @Override
    public boolean isOdd() {
        return pagesCount % 2 != 0;
    }

    public static class Builder {
        private final String author;
        private final String title;
        private final int pagesCount;

        public Builder(String author, String title, int pagesCount) throws InvalidArgumentException {
            if(author.isEmpty()){
                throw new InvalidArgumentException("Поле автор должно быть заполнено");
            } else if(title.isEmpty()){
                throw new InvalidArgumentException("Поле название должно быть заполнено");
            } else if(pagesCount <= 0){
                throw new InvalidArgumentException("Поле кол-во страниц не должно быть меньше или равно нулю");
            }

            this.author = author;
            this.title = title;
            this.pagesCount = pagesCount;
        }

        public Book build() {
            return new Book(this);
        }
    }

    public String getAuthor() {
        return author;
    }


    public String getTitle() {
        return title;
    }

    public int getPagesCount() {
        return pagesCount;
    }

}
