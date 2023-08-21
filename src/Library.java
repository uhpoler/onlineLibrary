

//абстрактний клас
abstract public class Library implements Cloneable {

    public abstract void show();

    public abstract void showByAuthor();

    public abstract void addNote(String note);

    public abstract void showNotes() throws Exception;


    //статичний метод
    public static void aboutProgram() {
        System.out.println();
        System.out.println(String.format("%" + 112 + "s", "ЦЕ ПРОГРАМА ЯКА СИМУЛЮЄ БІБЛІОТЕКУ, В ЯКІЙ ВИ МОЖЕТЕ ВИКОНУВАТИ ПЕВНІ ДІЇ З ЖУРНАЛАМИ ТА КНИГАМИ"));
    }


}


