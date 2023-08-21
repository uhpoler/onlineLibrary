import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {

        Scanner scanner = new Scanner(System.in);

        //використання статичного методу
        Library.aboutProgram();

        System.out.println(centerText("Що ти обереш? Книги чи журнали? (натисни 1 або 2)"));
        String booksOrMagazines = scanner.nextLine();

        try {
            if (Objects.equals(booksOrMagazines, "1")) {
                //------------дії з книгами--------------------

                ArrayList<Book> library = new ArrayList<>(); //колекція книг

                System.out.println(centerText("Вітаю! Тепер Ви на полиці з книгами! Яка дія буде наступною?"));
                System.out.println(menuCenterText("1 Додати книгу власноруч"));
                System.out.println(menuCenterText("2 Пошук книги за назвою"));
                System.out.println(menuCenterText("3 Пошук книги за автором"));
                System.out.println(menuCenterText("4 Вилучити книгу з бібліотеки"));
                System.out.println(menuCenterText("5 Клонувати книгу"));
                System.out.println(menuCenterText("6 Додати коментар до книги"));
                System.out.println(menuCenterText("7 Вивести список жанрів"));
                System.out.println(menuCenterText("8 Вивести всі наявні книги"));

                System.out.println(centerText("АВТОМАТИЧНИЙ РЕЖИМ ПРОГРАМИ"));
                System.out.println();

                //11111111111111111111111111111111111111111111111111111111111111111111111111111111111111
                //додавання книги1 за допомогою окремого створення об'єктів класів Автор та Рік, використання конструктору
                Author author1 = new Author("Tana French");
                Year year1 = new Year(2007);
                Book book1 = new Book("In the woods", author1, year1, Book.Genre.MYSTERY);
                library.add(book1);

                //додавання книги2 за допомогою сетерів
                Book book2 = new Book();
                book2.setTitle("Last unicorn");
                book2.setAuthor("Peter Beagle");
                book2.setYear(1968);
                book2.setGenre(Book.Genre.FANTASY);
                library.add(book2);

                //додавання книги3 за допомогою одного конструктора (ще одна книга одного ж автора)
                Book book3 = new Book("The secret place", author1, 2010, Book.Genre.SCIENCEFICTION);
                library.add(book3);

                Book book4 = new Book("The pillars of the earth", "Ken Follett", 1989, Book.Genre.HISTORICALFICTION);
                library.add(book4);
                Book book5 = new Book("Ghost Story", "Peter Straub", 1979, Book.Genre.HORROR);
                library.add(book5);

                System.out.println("1 Всі 5 книг додано:");
                printLibraryContents(library);

                //222222222222222222222222222222222222222222222222222222222222222222222222222222222222222
                System.out.println("2 Хочу знайти книгу з назвою \"Last unicorn\"");

                boolean bookFound = false;
                for (Book book : library) {
                    if (book.getTitle().equalsIgnoreCase("Last unicorn")) {
                        bookFound = true;
                        System.out.println("Книга знайдена у колекції.");
                        book.show();
                    }
                }
                if (!bookFound) {
                    throw new Exception("Книга не знайдена");
                }
                System.out.println();

                //3333333333333333333333333333333333333333333333333333333333333333333333333333333333333333
                System.out.println("3 Хочу побачити всі книги автора \"Tana French\"");

                boolean authorFound = false;
                for (Book book : library) {
                    if (book.getAuthor().getFullName().equalsIgnoreCase("Tana French")) {
                        authorFound = true;
                        book.showByAuthor();
                    }
                }
                if (!authorFound) {
                    throw new Exception("Автор не знайдений");
                }
                System.out.println();

                //4444444444444444444444444444444444444444444444444444444444444444444444444444444444444444
                System.out.println("4 Хочу вилучити  \"Ghost Story\" з бібліотеки");

                printLibraryContents(library);

                System.out.println("Книга \"Ghost Story\" вилучена");
                library.removeIf(book -> book.getTitle().equalsIgnoreCase("Ghost Story"));

                printLibraryContents(library);

                //5555555555555555555555555555555555555555555555555555555555555555555555555555555555555555
                System.out.println("5 Хочу клонувати книгу  \"The pillars of the earth\"");


                Book book6 = book4.clone();
                library.add(book6);

                printLibraryContents(library);

                //66666666666666666666666666666666666666666666666666666666666666666666666666666666666666666
                System.out.println("6 Хочу додати коментар до книги  \"In the woods\"");

                for (Book book : library) {
                    if (book.getTitle().equalsIgnoreCase("In the woods")) {
                        book.addNote("Цікава інформація для нотаток");
                        book.showNotes();
                    }
                }
                System.out.println();

                System.out.println("6 Хочу додати масив коментарів до книги  \"The secret place\"");
                for (Book book : library) {
                    if (book.getTitle().equalsIgnoreCase("The secret place")) {
                        String[] notesArray = {"Нотатка 1", "Нотатка 2", "Нотатка 3"};
                        book.addNote(notesArray);
                        book.showNotes();
                    }
                }
                System.out.println();

                //7777777777777777777777777777777777777777777777777777777777777777777777777777777777777777
                System.out.println("7 Хочу подивитись список жанрів");
                Book.printGenres();
                System.out.println();

                //8888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
                System.out.println("8 Хочу вивести список всіх книг");
                printLibraryContents(library);


            } else if (Objects.equals(booksOrMagazines, "2")) {
                //------------дії з журналами--------------------
                ArrayList<Magazine> library = new ArrayList<>(); //колекція журналів

                System.out.println(centerText("Вітаю! Тепер Ви на полиці з журналами! Яка дія буде наступною?"));
                System.out.println(menuCenterText("1 Додати журнал власноруч"));
                System.out.println(menuCenterText("2 Пошук журналу за назвою"));
                System.out.println(menuCenterText("3 Пошук журналу за автором"));
                System.out.println(menuCenterText("4 Вилучити журнал з бібліотеки"));
                System.out.println(menuCenterText("5 Додати коментар до книги"));
                System.out.println(menuCenterText("6 Вивести всі наявні книги"));

                System.out.println(centerText("АВТОМАТИЧНИЙ РЕЖИМ ПРОГРАМИ"));
                System.out.println();


                //11111111111111111111111111111111111111111111111111111111111111111111111111111111111111
                //додавання журналу1 за допомогою окремого створення об'єктів класів Автор та Рік, використання конструктору
                Author author1 = new Author("Vann Kennet");
                Year year1 = new Year(2003);
                Magazine magazine1 = new Magazine("Good wine", author1, year1);
                library.add(magazine1);

                //додавання журналу2 за допомогою сетерів
                Magazine magazine2 = new Magazine();
                magazine2.setTitle("Kinfolk");
                magazine2.setAuthor("Mike Beagle");
                magazine2.setYear(1998);
                library.add(magazine2);

                //додавання журналу3 за допомогою одного конструктора (ще одна книга одного ж автора)
                Magazine magazine3 = new Magazine("VOX", author1, 2020);
                library.add(magazine3);

                Magazine magazine4 = new Magazine("Harper's Bazaar", "Ken Follett", 1789);
                library.add(magazine4);
                Magazine magazine5 = new Magazine("National Geographic", "Peter Straub", 1849);
                library.add(magazine5);

                System.out.println("1 Всі 5 журналів додано:");
                for (Magazine magazine : library) {
                    magazine.show();
                }
                System.out.println();

                //222222222222222222222222222222222222222222222222222222222222222222222222222222222222222
                System.out.println("2 Хочу знайти журнал з назвою \"Good wine\"");

                for (Magazine magazine : library) {
                    if (magazine.getTitle().equalsIgnoreCase("Good wine")) {
                        System.out.println("Журнал знайдений у колекції.");
                        magazine.show();
                    }
                }
                System.out.println();

                //3333333333333333333333333333333333333333333333333333333333333333333333333333333333333333
                System.out.println("3 Хочу побачити всі журнали автора \"Vann Kennet\"");

                for (Magazine magazine : library) {
                    if (magazine.getAuthor().getFullName().equalsIgnoreCase("Vann Kennet")) {
                        magazine.showByAuthor();
                    }
                }
                System.out.println();

                //4444444444444444444444444444444444444444444444444444444444444444444444444444444444444444
                System.out.println("4 Хочу вилучити  \"VOX\" з бібліотеки");

                printLibraryMagazineContents(library);

                System.out.println("Книга \"VOX\" вилучена");
                library.removeIf(magazine -> magazine.getTitle().equalsIgnoreCase("VOX"));

                printLibraryMagazineContents(library);

                //55555555555555555555555555555555555555555555555555555555555555555555555555555555555555555
                System.out.println("5 Хочу додати коментар до журналу  \"Harper's Bazaar\"");

                for (Magazine magazine : library) {
                    if (magazine.getTitle().equalsIgnoreCase("Harper's Bazaar")) {
                        magazine.addNote("Цікава інформація для нотаток");
                        magazine.showNotes();
                    }
                }
                System.out.println();

                System.out.println("5 Хочу додати масив коментарів до журналу  \"National Geographic\"");
                for (Magazine magazine : library) {
                    if (magazine.getTitle().equalsIgnoreCase("National Geographic")) {
                        String[] notesArray = {"Нотатка 1", "Нотатка 2", "Нотатка 3"};
                        magazine.addNote(notesArray);
                        magazine.showNotes();
                    }
                }
                System.out.println();

                //666666666666666666666666666666666666666666666666666666666666666666666666666666666666666
                System.out.println("6 Хочу вивести список всіх журналів");
                printLibraryMagazineContents(library);

            }else {
                throw new Exception("Ви ввели неправильне число");

            }

        }catch (CloneNotSupportedException e){
            System.out.println("Помилка клонування об'єкта: " + e.getMessage());
            e.printStackTrace();
        }catch (Exception e) {
            System.out.println("Виникла помилка: " + e.getMessage());
        }




    }

    public static String centerText(String text) {
        int consoleWidth = 120;
        int padding = (consoleWidth - text.length()) / 2;
        String centeredText = String.format("%" + (padding + text.length()) + "s", text);
        return centeredText;
    }

    public static String menuCenterText(String text) {
        int padding = 45;
        String centeredText = String.format("%" + (padding + text.length()) + "s", text);
        return centeredText;
    }

    public static void printLibraryContents(ArrayList<Book> library) {
        System.out.println("Наразі в бібліотеці така кількість книг:");
        for (Book book : library) {
            book.show();
        }
        System.out.println();
    }

    public static void printLibraryMagazineContents(ArrayList<Magazine> library) {
        System.out.println("Наразі в бібліотеці така кількість журналів:");
        for (Magazine magazine : library) {
            magazine.show();
        }
        System.out.println();
    }
}
