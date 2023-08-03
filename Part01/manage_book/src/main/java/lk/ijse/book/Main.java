package lk.ijse.book;

import lk.ijse.book.Entity.Book;
import lk.ijse.book.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Scanner;

public class Main {
    static  Book book =new Book();
    static Scanner input =new Scanner(System.in);


    public static void main(String[] args) {



        Main2();
    }

    public    static void Main2(){

        System.out.print("save your book (Enter no 1)");
        System.out.print("///");
        System.out.print("Update your book (Enter no 2)");
        System.out.print("///");
        System.out.print("delete your book (Enter no 3)");
        System.out.print("///");
        System.out.println("Serch your book (Enter no 4)");

        int type =input.nextInt();
        switch (type){
            case 1:
                Save();break;
            case 2:
                Update();break;
            case 3:
                Delete();break;
            case 4:
                Serch();break;
        }
    }

     static void Serch() {
         Session session = FactoryConfiguration.getInstance().getSession();
         Transaction transaction =session.beginTransaction();
         System.out.println("enter book Id:");
         book=session.get(Book.class,input.next());
         System.out.println(book.getId() +" "+book.getName()+" "+book.getPrice());

         transaction.commit();
         session.close();
         System.out.println("you wont to back to the menu!!(Press number 5)");
         int i=input.nextInt();
         switch (i){
             case 5:Main2();break;
         }
    }

    static void Delete() {
        System.out.println("Input book id");
        book.setId(input.next());
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction =session.beginTransaction();

        session.remove(book);
        transaction.commit();
        session.close();
        System.out.println("you wont to back to the menu!!(Press number 5)");
        int i=input.nextInt();
        switch (i){
            case 5:Main2();break;
        }
    }

    static void Save(){
        System.out.println("Input book id");
        book.setId(input.next());
        System.out.println("Input book Name");
        book.setName(input.next());
        System.out.println("Input book Price");
        book.setPrice( input.nextDouble());


         Session session = FactoryConfiguration.getInstance().getSession();
         Transaction transaction =session.beginTransaction();

        session.persist(book);

        transaction.commit();
        session.close();
        System.out.println("you wont to back to the menu!!(Press number 5)");
        int i=input.nextInt();
        switch (i){
            case 5:Main2();break;
        }







    }

    static void Update(){
        System.out.println("Update ID:");
        book.setId(input.next());
        System.out.println("Update NAME:");
        book.setName(input.next());
        System.out.println("Update PRICE:");
        book.setPrice(input.nextDouble());


         Session session = FactoryConfiguration.getInstance().getSession();
         Transaction transaction =session.beginTransaction();

        session.update(book);

        transaction.commit();
        session.close();
        System.out.println("you wont to back to the menu!!(Press number 5)");
        int i=input.nextInt();
        switch (i){
            case 5:Main2();break;
        }


    }

}
