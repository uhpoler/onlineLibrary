//імплементація клонуючого інтерфейсу
public class Author implements Cloneable{
    private String fullName;

    public Author(){
        this.fullName="";
    }
    public Author(String fullName){
        this.fullName=fullName;
    }

    public String getFullName() {return fullName;}
    public void setFullName(String title){this.fullName=fullName;}

    @Override
    public String toString() {
        return fullName;
    }
}
