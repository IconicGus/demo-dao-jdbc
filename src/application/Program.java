package application;

import db.DB;
import db.DbIntegrityException;
import model.entities.Department;
import model.entities.Seller;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Program {
    public static void main(String[] args) {

        Department obj = new Department(1, "Books");
        Seller seller = new Seller(3000.0, new Date(), obj, "bob@gmail.com", 21, "Bob");

        System.out.println(seller);

    }
}
