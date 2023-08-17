import java.util.ArrayList;
import java.util.List;

//абстрактний клас
abstract public class Library implements Cloneable {

    public abstract void show();

    public abstract void showByAuthor();

    public abstract void addNote(String note);

    public abstract void showNotes();


    //статичний метод
    public static void aboutProgram() {
        System.out.println("це програма");
    }

}


