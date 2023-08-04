public class Book extends Library{

    //атрибути
    private String title;
    private Author author;
    private Year year;

    //конструктор за замовчуванням
    public Book(){
        this.title="";
        this.author=null;
        this.year=null;
    }

    //основний конструктор
    public Book(String title, Author author, Year year){
        this.title=title;
        this.author=author;
        this.year=year;
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

    }

    @Override
    public boolean isAvailable() {
        return false;
    }

    @Override
    public boolean isInstanseOf() {
        return false;
    }
}
