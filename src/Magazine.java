import java.util.ArrayList;
import java.util.Arrays;

public class Magazine extends Library{

    //атрибути
    private String title;
    private Author author;
    private Year year;
    private ArrayList<String> notes;

    //конструктор за замовчуванням
    public Magazine(){
        this.title="";
        this.author=null;
        this.year=null;
        notes = new ArrayList<>();
    }

    //основний конструктор
    public Magazine(String title, Author author, Year year){
        this.title=title;
        this.author=author;
        this.year=year;
        notes = new ArrayList<>();
    }

    public Magazine(String title, String author, int year){
        this.title=title;
        this.author=new Author(author);
        this.year=new Year(year);
        notes = new ArrayList<>();
    }

    public Magazine(String title, Author author, int year){
        this.title=title;
        this.author=author;
        this.year=new Year(year);
        notes = new ArrayList<>();
    }

    //конструктор копіювання
    public Magazine(Magazine other){
        this.title=other.title;
        this.author=other.author;
        this.year=other.year;
        notes = new ArrayList<>();
    }

    public Magazine copy(){
        return  new Magazine(this);
    }

    //гетери сетери
    public String getTitle() {return title;}
    public void setTitle(String title){this.title=title;}
    public Author getAuthor() {return author;}
    public void setAuthor(String author){this.author=new Author(author);}
    public Year getYear() {return year;}
    public void setYear(int year) {this.year = new Year(year);}



    @Override
    public void show() {
        System.out.println("Назва: " + getTitle() + " Автор: " + getAuthor() + " Рік: " + getYear());
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
            throw new Exception("Немає нотаток для цього журналу.");
        } else {
            System.out.println("Нотатки для журналу '" + getTitle() + "':");
            for (String note : notes) {
                System.out.println("- " + note);
            }
        }
    }




}
