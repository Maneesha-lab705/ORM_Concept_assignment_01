package lk.ijse.One_To_One;

import lk.ijse.One_To_One.Entity.Auther;
import lk.ijse.One_To_One.Entity.Book;
import lk.ijse.One_To_One.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Scanner;

public class Main {
    static Book book =new Book();
    static Auther auther=new Auther();
    static Scanner input =new Scanner(System.in);


    public static void main(String[] args) {
        Main2();





    }

    private static void Main2() {
        System.out.print("save your book (Enter no 1)");
       // System.out.print("///");
        System.out.println("Update your book (Enter no 2)");
        //System.out.print("///");
        System.out.print("delete your book (Enter no 3)");
        //System.out.println("///");
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

    private static void Serch() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction =session.beginTransaction();
        System.out.println("enter book Id:");
        book=session.get(Book.class,input.next());
        System.out.println(book.getId() +" "+book.getName()+" "+book.getPrice()+" "+book.getAuther().getId());

        transaction.commit();
        session.close();

        System.out.print("back to the menu press no 5");
          int a=input.nextInt();
        switch (a){
            case 5:Main2();break;
        }

    }

    private static void Delete() {
        System.out.println("Input book id");
        book.setId(input.next());
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction =session.beginTransaction();

        session.remove(book);
        transaction.commit();
        System.out.print("You wont to Delete Auther(yes OR no)");
        String click=input.next();
        switch (click){
            case "yes":DeleteAuther();break;
            case "no":Main2();break;
        }
        DeleteAuther();

    }

    private static void DeleteAuther() {
        System.out.print("Enter Auther ID:");
        auther.setId(input.next());
        Session session=FactoryConfiguration.getInstance().getSession();
        Transaction transaction =session.beginTransaction();

        session.remove(auther);
        transaction.commit();
        session.close();

        System.out.print("back to the menu press no 5");
        int a=input.nextInt();
        switch (a){
            case 5:Main2();break;
        }


    }

    private static void Update() {
        System.out.print("Enter Book Id:");
        book.setId(input.next());
        System.out.print( "Enter Book Name:");
        book.setName(input.next());
        System.out.print( "Enter Book Price:");
        book.setPrice(input.nextDouble());
        System.out.print( "Enter Auther Id:");
        auther.setId(input.next());
        System.out.print( "Enter Auther Name:");
        auther.setName( input.next());
        System.out.print( "Enter Auther Country:");
        auther.setCountry( input.next());

        book.setAuther(auther);


        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction =session.beginTransaction();

        session.update(book);
        session.update(auther);

        transaction.commit();
        session.close();
        System.out.print("back to the menu press no 5");
        int a=input.nextInt();
        switch (a){
            case 5:Main2();break;
        }


    }

    private static void Save() {
        System.out.print("Enter Book Id:");
       book.setId(input.next());
        System.out.print( "Enter Book Name:");
        book.setName(input.next());
        System.out.print( "Enter Book Price:");
        book.setPrice(input.nextDouble());
        System.out.print( "Enter Auther Id:");
        auther.setId(input.next());
        System.out.print( "Enter Auther Name:");
        auther.setName( input.next());
        System.out.print( "Enter Auther Country:");
        auther.setCountry( input.next());

        book.setAuther(auther);


        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction =session.beginTransaction();

        session.persist(book);
        session.persist(auther);

        transaction.commit();
        session.close();

        System.out.print("back to the menu press no 5");
        int a=input.nextInt();
        switch (a){
            case 5:Main2();break;
        }
    }
}
