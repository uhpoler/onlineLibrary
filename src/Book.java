import java.util.ArrayList;
import java.util.Arrays;

public class Book extends Library{

    //атрибути
    private String title;
    private Author author;
    private Year year;
    private Genre bookType;
    private ArrayList<String> notes;

    //використання final
    final int MAX_VALUE = 100;

    //використання enum
    enum Genre{
        SCIENCEFICTION,
        MYSTERY,
        HORROR,
        FANTASY,
        HISTORICALFICTION
    }

    //конструктор за замовчуванням
    public Book(){
        this.title="";
        this.author=null;
        this.year=null;
        this.bookType=null;
        notes = new ArrayList<>();
    }

    //основний конструктор
    public Book(String title, Author author, Year year, Genre bookType){
        this.title=title;
        this.author=author;
        this.year=year;
        this.bookType=bookType;
        notes = new ArrayList<>();
    }

    public Book(String title, String author, int year, Genre bookType){
        this.title=title;
        this.author=new Author(author);
        this.year=new Year(year);
        this.bookType=bookType;
        notes = new ArrayList<>();
    }

    public Book(String title, Author author, int year, Genre bookType){
        this.title=title;
        this.author=author;
        this.year=new Year(year);
        this.bookType=bookType;
        notes = new ArrayList<>();
    }

    public Book(String title, String author, Year year, Genre bookType){
        this.title=title;
        this.author=new Author(author);
        this.year=year;
        this.bookType=bookType;
        notes = new ArrayList<>();
    }

    //конструктор копіювання
    public Book(Book other){
        this.title=other.title;
        this.author=other.author;
        this.year=other.year;
        this.bookType=other.bookType;
        notes = new ArrayList<>();
    }

    public Book copy(){
        return  new Book(this);
    }


    //гетери сетери
    public String getTitle() {return title;}
    public void setTitle(String title){this.title=title;}
    public Author getAuthor() {return author;}
    public void setAuthor(String author){this.author=new Author(author);}
    public Year getYear() {return year;}
    public void setYear(int year) {this.year = new Year(year);}
    public Genre getGenre() {return bookType;}
    public void setGenre(Genre bookType) {this.bookType = bookType;}


    //клонування об'єктів
    public Book clone() throws CloneNotSupportedException {
        Book clonedBook = (Book) super.clone();  // Call the Object's clone method

        // Clone the ArrayList notes
        clonedBook.notes = new ArrayList<>(notes);

        return clonedBook;
    }


    @Override
    public void show(){
        //lambda functions
        String genreStr = switch (bookType) {
            case SCIENCEFICTION -> "Science fiction";
            case MYSTERY -> "Mystery";
            case HORROR -> "Horror";
            case FANTASY -> "Fantasy";
            case HISTORICALFICTION -> "Historical Fiction";


        };
        System.out.println("Назва: " + getTitle() + " Автор: " + getAuthor() + " Рік: " + getYear() + " Жанр: " + genreStr);

    }



    @Override
    public void showByAuthor() {
        //використання equals
        if (author.equals(this.getAuthor())) {
            this.show();
        }
    }


    //overloading
    @Override
    public void addNote(String note){
        notes.add(note);
        System.out.println("Коментар додано");
    }

    //overloading
    public void addNote(String[] noteArray) {
        notes.addAll(Arrays.asList(noteArray));
        System.out.println("Масив коментарів додано");
    }


    @Override
    public void showNotes() throws Exception {
        if (notes.isEmpty()) {
            throw new Exception("Немає нотаток для цієї книги.");
        } else {
            System.out.println("Нотатки для книги '" + getTitle() + "':");
            for (String note : notes) {
                System.out.println("- " + note);
            }
        }
    }

    public static void printGenres() {
        System.out.println("Список жанрів:");
        for (Book.Genre genre : Book.Genre.values()) {
            System.out.println(genre);
        }
    }

}



