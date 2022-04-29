//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.ntu;

import com.ntu.dao.BookDAO;
import com.ntu.dao.BookDAOImpl;
import com.ntu.dao.BookRegisterDAO;
import com.ntu.dao.BookRegisterDAOImpl;
import com.ntu.dao.PersonReaderDAO;
import com.ntu.dao.PersonReaderDAOImpl;
import com.ntu.domain.Book;
import com.ntu.domain.BookRegister;
import com.ntu.domain.PersonReader;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        BookDAO bookDAO = new BookDAOImpl();
        PersonReaderDAO personReaderDAO = new PersonReaderDAOImpl();
        BookRegisterDAO bookRegisterDAO = new BookRegisterDAOImpl();
        Scanner sc = new Scanner(System.in);

        label92:
        while(true) {
            System.out.println("1: додати книгу              8: змінити дані про читача");
            System.out.println("2: додати читача             9: повернули книгу");
            System.out.println("3: додати запис до реєстру   10: список книг");
            System.out.println("4: видалити книгу            11: список читачів");
            System.out.println("5: видалити читача           12: список записів у реєстрі");
            System.out.println("6: видалити запис в реєстрі  13: список неповернених книжок у реєстрі");
            System.out.println("7: змінити дані про книгу    14: список повернених книжок у реєстрі");
            System.out.print("-> ");
            String s = sc.nextLine();
            switch(s.hashCode()) {
                case 49:
                    if (!s.equals("1")) {
                        return;
                    }

                    System.out.print("Внесіть назву книги: ");
                    String title = sc.nextLine();
                    System.out.print("Внесіть автора книги: ");
                    String author = sc.nextLine();
                    System.out.print("Внесіть рік друку книги: ");
                    int printYear = sc.nextInt();
                    System.out.print("Внесіть кількість сторінок книги: ");
                    int countOfPages = sc.nextInt();
                    Book book = new Book(title, author, printYear, countOfPages);
                    bookDAO.insertBook(book);
                    break;
                case 50:
                    if (!s.equals("2")) {
                        return;
                    }

                    System.out.print("Внесіть імя читача: ");
                    String firstName = sc.nextLine();
                    System.out.print("Внесіть по-батькові читача: ");
                    String middleName = sc.nextLine();
                    System.out.print("Внесіть прізвище читача: ");
                    String lastName = sc.nextLine();
                    System.out.print("Внесіть телефон читача: ");
                    String phone = sc.nextLine();
                    System.out.print("Внесіть дату народження читача (yyyy-MM-dd): ");
                    String birthDt = sc.nextLine();
                    System.out.print("Внесіть адресу читача: ");
                    String address = sc.nextLine();
                    System.out.print("Внесіть серію паспорта: ");
                    String serialOfPassport = sc.nextLine();
                    System.out.print("Внесіть номер паспорта: ");
                    int numOfPassport = sc.nextInt();
                    Date birthDtIn = DateUtil.convertStringIntoSqlDate("2018-04-05");
                    PersonReader personReader = new PersonReader(firstName, middleName, lastName, phone, birthDtIn, serialOfPassport, numOfPassport, address);
                    personReaderDAO.insertPersonReader(personReader);
                    break;
                case 51:
                    if (!s.equals("3")) {
                        return;
                    }

                    System.out.print("Внесіть дату видачі (yyyy-MM-dd): ");
                    String vydanoDt = sc.nextLine();
                    System.out.print("Внесіть ID книги: ");
                    int bookId = sc.nextInt();
                    System.out.print("Внесіть ID читача: ");
                    int personReaderId = sc.nextInt();
                    Book bookFromDB = bookDAO.getBookById((long)bookId);
                    PersonReader personReaderFromDB = personReaderDAO.getPersonReaderById((long)personReaderId);
                    Date vydanoDtIn = DateUtil.convertStringIntoSqlDate(vydanoDt);
                    BookRegister bookRegister = new BookRegister(bookFromDB, vydanoDtIn, personReaderFromDB);
                    bookRegisterDAO.insertBookRegister(bookRegister);
                    break;
                case 52:
                    if (!s.equals("4")) {
                        return;
                    }

                    System.out.print("Внесіть ID книги: ");
                    int bookIdDel = sc.nextInt();
                    bookDAO.deleteBook((long)bookIdDel);
                    break;
                case 53:
                    if (!s.equals("5")) {
                        return;
                    }

                    System.out.print("Внесіть ID читача: ");
                    int personReaderIdDel = sc.nextInt();
                    personReaderDAO.deletePersonReader((long)personReaderIdDel);
                    break;
                case 54:
                    if (!s.equals("6")) {
                        return;
                    }

                    System.out.print("Внесіть ID запису реєстру: ");
                    int bookRegisterIdDel = sc.nextInt();
                    bookRegisterDAO.deleteBookRegister((long)bookRegisterIdDel);
                    break;
                case 55:
                    if (!s.equals("7")) {
                        return;
                    }
                    break;
                case 56:
                    if (!s.equals("8")) {
                        return;
                    }
                    break;
                case 57:
                    if (!s.equals("9")) {
                        return;
                    }
                    break;
                case 1567:
                    if (!s.equals("10")) {
                        return;
                    }

                    List<Book> books = bookDAO.getAllBooks();
                    Iterator var39 = books.iterator();

                    while(true) {
                        if (!var39.hasNext()) {
                            continue label92;
                        }

                        Book item = (Book)var39.next();
                        System.out.println(item);
                    }
                case 1568:
                    if (!s.equals("11")) {
                        return;
                    }

                    List<PersonReader> personReaders = personReaderDAO.getAllPersonReaders();
                    Iterator var40 = personReaders.iterator();

                    while(true) {
                        if (!var40.hasNext()) {
                            continue label92;
                        }

                        PersonReader item = (PersonReader)var40.next();
                        System.out.println(item);
                    }
                case 1569:
                    if (!s.equals("12")) {
                        return;
                    }

                    List<BookRegister> bookRegisters = bookRegisterDAO.getAllBookRegisters();
                    Iterator var36 = bookRegisters.iterator();

                    while(true) {
                        if (!var36.hasNext()) {
                            continue label92;
                        }

                        BookRegister item = (BookRegister)var36.next();
                        System.out.println(item);
                    }
                case 1570:
                    if (!s.equals("13")) {
                        return;
                    }
                    break;
                case 1571:
                    if (!s.equals("14")) {
                        return;
                    }
                    break;
                default:
                    return;
            }
        }
    }
}