package application;

import db.DB;
import db.DbIntegrityException;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1: seller findById =====");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n=== TEST 2: seller findByDepartment =====");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);

        for (Seller obj: list) {
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 3: seller findAll =====");
        List<Seller> list2 = sellerDao.findAll();

        for (Seller obj: list2) {
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 4: seller insert =====");

        Seller newSeller = new Seller(4000.0, new Date(), department, "greg@gmail.com", null, "Greg");
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());

        System.out.println("\n=== TEST 5: seller update =====");

        seller = sellerDao.findById(1);
        seller.setName("Martha Waine");
        sellerDao.update(seller);
        System.out.println("Update completed!");

        System.out.println("\n=== TEST 5: seller delete =====");
        System.out.println("Enter id to delete: ");
        int id = sc.nextInt();

        sellerDao.deleteById(id);
        System.out.println("Delete completed!");

        sc.close();

    }
}
