package aston.course_project.sorting.custom_classes;

public class Book {
    private String author;
    private String title;
    private int pagesCount;

    public Book(Builder builder) {
        this.author = builder.author;
        this.title = builder.title;
        this.pagesCount = builder.pagesCount;
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
