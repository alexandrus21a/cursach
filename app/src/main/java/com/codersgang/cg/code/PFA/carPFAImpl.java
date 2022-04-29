package com.codersgang.cg.code.PFA;

import static com.ntu.ConnectionFactory.getConnection;

import com.codersgang.cg.code.domain.cars;
import com.codersgang.cg.code.conn;
import com.ntu.ConnectionFactory;
import com.ntu.domain.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class carPFAImpl implements carPFA {
    @Override
    public cars getcarbyid(long car_id) {
        try (Connection connection = conn.connect("jdbc:mysql://bxbeira3epme6fr6hvnr-mysql.services.clever-cloud.com", "uuintsqhtq0ys6z3", "bRg0ti2GrMEl0kAyYqU3");
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM avto1 WHERE car_id=" + car_id);) {
            if (rs.next()) {
                return extractBookFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<cars> carbyvendorandmodel(String vendor, String model) {
        try (Connection connection = conn.connect("jdbc:mysql://bxbeira3epme6fr6hvnr-mysql.services.clever-cloud.com", "uuintsqhtq0ys6z3", "bRg0ti2GrMEl0kAyYqU3");
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM book WHERE Vendor=? AND Model=?")) {
            ps.setString(1, vendor);
            ps.setString(2, model);
            ResultSet rs = ps.executeQuery();
            List<cars> carsbvm = new ArrayList<>();
            while (rs.next()) {
                cars test = extractBookFromResultSet(rs);
                carsbvm.add(test);
            }
            return carsbvm;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }


    public List<cars> allcars() {
        try (Connection connection = conn.connect("jdbc:mysql://bxbeira3epme6fr6hvnr-mysql.services.clever-cloud.com", "uuintsqhtq0ys6z3", "bRg0ti2GrMEl0kAyYqU3");
             Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM avto1");) {
            List<cars> testy = new ArrayList<>();

            while (rs.next()) {
                cars test = extractBookFromResultSet(rs);
                testy.add(test);
            }

            return testy;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean inssercar(cars car) {
        //try-with-resources
        try (Connection connection = conn.connect("jdbc:mysql://bxbeira3epme6fr6hvnr-mysql.services.clever-cloud.com", "uuintsqhtq0ys6z3", "bRg0ti2GrMEl0kAyYqU3");
             PreparedStatement ps = connection.prepareStatement("INSERT INTO avto1(car_id, Vendor, Model, Color, Body_type, Fuel_type, Drive_type, Type_of_gearbox, County_of_origin, Year, Cost) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        ) {
            ps.setLong(1, car.car_id());
            ps.setString(2, car.getVendor());
            ps.setString(3, car.getModel());
            ps.setString(4, car.getBody());
            ps.setString(5, car.getColor());
            ps.setString(6, car.Fuel_type());
            ps.setString(7, car.getDrive_type());
            ps.setString(8, car.getType_of_gearbox());
            ps.setString(9, car.getCountry_of_origin());
            ps.setString(10, car.getYear());
            ps.setString(11, car.getPrice());
            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    @Override
    public boolean updatecar(cars car) {
        try (Connection connection = conn.connect("jdbc:mysql://bxbeira3epme6fr6hvnr-mysql.services.clever-cloud.com", "uuintsqhtq0ys6z3", "bRg0ti2GrMEl0kAyYqU3");
             PreparedStatement ps = connection.prepareStatement("UPDATE avto1 set Vendor = ?, Model = ?, Color = ?, Body_type = ?, Fuel_type = ?, Drive_type = ?, Type_of_gearbox = ?, Country_of_origin = ?, Year = ?, Cost = ? WHERE car_id=?");
        )
        {
            ps.setString(1, car.getVendor());
            ps.setString(2, car.getModel());
            ps.setString(3, car.getColor());
            ps.setString(4, car.getBody());
            ps.setString(5, car.Fuel_type());
            ps.setString(6, car.getDrive_type());
            ps.setString(7, car.getType_of_gearbox());
            ps.setString(8, car.getCountry_of_origin());
            ps.setString(9, car.getYear());
            ps.setString(10, car.getPrice());
            ps.setLong(11, car.car_id());

            int i = ps.executeUpdate();
            if(i == 1) {

                return true;

            }

        } catch (SQLException ex) {

            ex.printStackTrace();

        }

        return false;
    }

    @Override
    public boolean deletecar(long car_id) {
        try (Connection connection = conn.connect("jdbc:mysql://bxbeira3epme6fr6hvnr-mysql.services.clever-cloud.com", "uuintsqhtq0ys6z3", "bRg0ti2GrMEl0kAyYqU3");
             PreparedStatement ps = connection.prepareStatement("DELETE FROM avto1 WHERE car_id=?");)
        {
            ps.setLong(1, car_id);
            int i = ps.executeUpdate();
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    private cars extractBookFromResultSet(ResultSet rs) throws SQLException {
        cars test = new cars();
        test.setCar_id(rs.getLong("car_id"));
        test.setVendor(rs.getString("Vendor"));
        test.setModel(rs.getString("Model"));
        test.setBody_type(rs.getString("Body_type"));
        test.setColor(rs.getString("Color"));
        test.setFuel_type(rs.getString("Fuel_type"));
        test.setDrive_type(rs.getString("Drive_type"));
        test.setType_of_gearbox(rs.getString("Type_of_gearbox"));
        test.setCountry_of_origin(rs.getString("Country_of_origin"));
        test.setYear(rs.getString("Year"));
        test.setPrice(rs.getString("Cost"));

        return test;

    }
}