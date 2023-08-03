package lk.ijse.One_To_Many;

import lk.ijse.One_To_Many.Entity.Auther;
import lk.ijse.One_To_Many.Entity.Book;
import lk.ijse.One_To_Many.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner input =new Scanner(System.in);
    static Book book=new Book();
    static Book book1=new Book();
    static Auther auther=new Auther();
  static   Session session = FactoryConfiguration.getInstance().getSession();
    static Transaction transaction =session.beginTransaction();

        public static void main(String[] args) {
            saveAuthorWithMultipleBooks();
        }

        private static void saveAuthorWithMultipleBooks() {

            System.out.print("Enter Author Id: ");
            auther.setId(input.next());
            System.out.print("Enter Author Name: ");
            auther.setName(input.next());
            System.out.print("Enter Author Country: ");
            auther.setCountry(input.next());

            System.out.print("How many books do you want to add for this author? ");
            int numBooks = input.nextInt();

            for (int i = 0; i < numBooks; i++) {
                Book book=new Book();
                System.out.print("Enter Book Id: ");
                book.setId(input.next());
                System.out.print("Enter Book Name: ");
                book.setName(input.next());
                System.out.print("Enter Book Price: ");
                book.setPrice(input.nextDouble());
                // Associate the book with the author
               auther.addBook(book);
              //  auther.addBook(book);

            }
           // session.persist(book);
            session.persist(auther);


            transaction.commit();
            session.close();

            System.out.println("Author with multiple books saved successfully!");
        }
}


