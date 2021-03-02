package pt.uab.sm;

import pt.uab.sm.model.Book;
import pt.uab.sm.model.Category;
import pt.uab.sm.model.User;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    public static List<User> users = new ArrayList<>();
    public static List<Book> books = new ArrayList<>();
    public static User user;
    public static Scanner sc = new Scanner(System.in);

    /**
     * Carrega para memoria os users a partir do ficheiro users.txt. As caracteristicas dos users estão separadas por espaços em branco
     * @throws URISyntaxException
     * @throws IOException
     */
    public static void loaaUsers() throws URISyntaxException, IOException {
        String fileName = "users.txt";

        Files.lines(Paths.get(ClassLoader.getSystemResource(fileName).toURI())).forEach(line -> {
            String[] data = line.split(" ");
            users.add( new User(data[0], data[1], data[2], Integer.parseInt(data[3])) );
        });

    }

    /**
     * Carrega para memoria os livros a partir do ficheiro books.txt. As caracteristicas dos livros estão separadas por ;
     * @return
     * @throws URISyntaxException
     * @throws IOException
     */
    public static boolean loaaBooks() throws URISyntaxException, IOException {
        String fileName = "books.txt";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);

        Files.lines(Paths.get(ClassLoader.getSystemResource(fileName).toURI())).forEach(line -> {
            String[] data = line.split(";");
            LocalDate date = LocalDate.parse(data[5].trim(), formatter);
            books.add( new Book(data[0].trim(), data[1].trim(), data[2].trim(), Category.valueOf(data[3].trim()), data[4].trim(), date) );
        });

        return true;
    }

    /**
     * Lista de livros
     */
    public static void showBooks() {
        System.out.println("\n\n\n*** Livros ****\n");
        for (Book book : books) {
            System.out.println(book.toString());
        }
    }

    /**
     * Listar destaques
     */
    public static void showHighlights() {
        user.getFavorites().forEach(
                book -> System.out.println(book.toString())
        );
    }

    public static Book searchBook(String idxBook) {
        for(Book book: books) {
            if(book.getId().equals(idxBook))
                return book;
        }
        return null;
    }

    public static boolean purcharseBook(String idxBook) {
        Book book = searchBook(idxBook);
        if(book != null) {
            System.out.println("Compra efectuada!");
            return user.getPurchasing().add(book);
        } else {
            System.out.println("Id não encontrado!");
            return false;
        }
    }

    /**
     * Login
     * @throws IOException
     * @throws URISyntaxException
     */
    public static void login() throws IOException, URISyntaxException {
        boolean isLogin = false;

        loaaUsers();

        System.out.println("Insira os dados para entrar no sistema:\n\n");
        while(!isLogin) {
            System.out.println("Username: ");
            String username = sc.nextLine();
            System.out.println("\n\nPassword: ");
            String password = sc.nextLine();

            user = users.stream()
                    .filter(u -> username.equals((u.getUsername())) && password.equals(u.getPassword()))
                    .findAny()
                    .orElse(null);

            if(user != null){
                System.out.println("Login efectuado com sucesso!");
                break;
            } else {
                System.out.println("Login incorrecto! User ou password incorrectos.");
            }
        }
    }

    public static void menu() {
        String menu =  "\n\nEscolha uma das seguintes opções:\n\n" +
                "- Para listar livros pressiona tecla 1\n" + "- Para ver os livros em destaque para si pressione a tecla 2\n" +
                "- Para comprar um livro, pressione tecla 3\n"+
                "- Sair da sessão pressione tecla 4";

        boolean done = false;
        int input;

        while(!done) {
            System.out.println(menu);
            input = sc.nextInt();

            switch (input) {
                case 1:
                    System.out.println("\n\n*** Lista dos livros ***");
                    showBooks();
                    System.out.println("\n\n************************");
                    break;
                case 2:
                    System.out.println("\n\n*** Lista dos destaques ***");
                    showHighlights();
                    System.out.println("\n\n***************************");
                    break;
                case 3:
                    System.out.println("\n\n*** Compra de Livros ***");
                    showBooks();
                    System.out.println("\n\nInsira o número do livros que pretende comprar: ");
                    String idxBook = sc.next();
                    purcharseBook(idxBook);
                    System.out.println("\n\n************************");
                    break;
                case 4:
                    System.out.println("Logout efectuado! Obrigado pela visita!");
                    done = true;
                    break;
                default:
                    System.out.println("Insira um número correcto!");
                    break;
            }
        }


    }

    public static void main(String[] args) {
        String libName = "Biblioteca UAB";


        System.out.println("\n\n***Bem vindo à Biblioteca Uab***");
        System.out.println("\n\n\n");

        try {
            login();
            loaaBooks();
            menu();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }
}
