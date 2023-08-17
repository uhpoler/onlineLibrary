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
    }

    //основний конструктор
    public Magazine(String title, Author author, Year year){
        this.title=title;
        this.author=author;
        this.year=year;
    }

    //конструктор копіювання
    public Magazine(Magazine other){
        this.title=other.title;
        this.author=other.author;
        this.year=other.year;
    }

    public Magazine copy(){
        return  new Magazine(this);
    }

    //гетери сетери
    public String getTitle() {return title;}
    public void setTitle(String title){this.title=title;}
    public Author getAuthor() {return author;}
    public void setAuthor(Author author){this.author=author;}
    public Year getYear() {return year;}
    public void setYear(Year year){this.year=year;}



    @Override
    public void show() {
        System.out.println("Назва: " + getTitle() + " Автор: " + getAuthor() + " Рік: " + getYear());
    }

    @Override
    public void showByAuthor() {
        System.out.println("Журнали автора " + author.getFullName() + ":");
        //використання equals
        if (author.equals(this.getAuthor())) {
            this.show();
        }
    }


    //overloading
    @Override
    public void addNote(String note){
        notes.add(note);
        System.out.println("Notes have been added");
    }

    //overloading
    public void addNote(String[] noteArray) {
        notes.addAll(Arrays.asList(noteArray));
    }


    @Override
    public void showNotes() {
        if (notes.isEmpty()) {
            System.out.println("Немає нотаток для цього журналу.");
        } else {
            System.out.println("Нотатки для журналу '" + getTitle() + "':");
            for (String note : notes) {
                System.out.println("- " + note);
            }
        }
    }




}
