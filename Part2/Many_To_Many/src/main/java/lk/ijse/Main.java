package lk.ijse;

import lk.ijse.Entity.Auther;
import lk.ijse.Entity.Book;
import lk.ijse.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);

//        System.out.print("How many books do you want to add for this author? ");
//        int numBooks = input.nextInt();
//
//        for (int i = 0 ;i<numBooks ;i++) {
//            Auther auther=new Auther();
//            System.out.print("Enter Author Id: ");
//            auther.setId(input.next());
//            System.out.print("Enter Author Name: ");
//            auther.setName(input.next());
//            System.out.print("Enter Author Country: ");
//            auther.setCountry(input.next());
//            auther.addAuthor(auther);
//
//        }
//
//        for (int i = 0; i < numBooks; i++) {
//            Book book =new Book();
//
//            System.out.print("Enter Book Id: ");
//            book.setId(input.next());
//            System.out.print("Enter Book Name: ");
//            book.setName(input.next());
//            System.out.print("Enter Book Price: ");
//            book.setPrice(input.nextDouble());
//            // Associate the book with the author
//            book.addBook(book);
//            //  auther.addBook(book);
//
//        }

        public static void main (String[]args){
            Book book1 = new Book();
            book1.setId("B001");
            book1.setName("Nature");
            book1.setPrice(1000.00);

            Book book2 = new Book();
            book2.setId("B002");
            book2.setName("One_Piece");
            book2.setPrice(1500.00);

            Auther author1 = new Auther();
            author1.setId("A001");
            author1.setName("Mr.MartienWickramasingha");
            author1.setCountry("SriLanka");

            Auther author2 = new Auther();
            author2.setId("A002");
            author2.setName("Mr.Dao");
            author2.setCountry("Japan");

            List<Book> books = new ArrayList<>();
            books.add(book1);
            books.add(book2);

            List<Auther> authors = new ArrayList<>();
            authors.add(author1);
            authors.add(author1);

            book1.setAuthers(authors);
            book2.setAuthers(authors);

            Session session = FactoryConfiguration.getInstance().getSession();
            Transaction transaction = session.beginTransaction();
            session.persist(author1);
            session.persist(author2);
            session.persist(book1);
            session.persist(book2);
            transaction.commit();
            session.close();
        }
}
