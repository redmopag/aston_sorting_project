package aston.course_project.sorting.custom_classes;

import aston.course_project.sorting.Parity;

public class Book implements Comparable<Book>, Parity {
    private String author;
    private String title;
    private Integer pagesCount;

    public Book(Builder builder) {
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
        private String author;
        private String title;
        private int pagesCount;

        public Builder author(String author) {
            this.author = author;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder pagesCount(int pagesCount) {
            this.pagesCount = pagesCount;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPagesCount(int pagesCount) {
        this.pagesCount = pagesCount;
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
