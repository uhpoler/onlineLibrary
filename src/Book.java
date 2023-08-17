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
    public void setAuthor(Author author){this.author=author;}
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
        System.out.println("Книги автора " + author.getFullName() + ":");
        //використання equals
        if (author.equals(this.getAuthor())) {
            this.show(); // Викликаємо метод show() для поточної книги
        }
    }


    //overloading
    @Override
    public void addNote(String note){
        notes.add(note);
        System.out.println("String notes have been added");
    }

    //overloading
    public void addNote(String[] noteArray) {
        notes.addAll(Arrays.asList(noteArray));
    }


    @Override
    public void showNotes() {
        if (notes.isEmpty()) {
            System.out.println("Немає нотаток для цієї книги.");
        } else {
            System.out.println("Нотатки для книги '" + getTitle() + "':");
            for (String note : notes) {
                System.out.println("- " + note);
            }
        }
    }


}



