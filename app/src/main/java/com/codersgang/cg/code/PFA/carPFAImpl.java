package com.codersgang.cg.code.PFA;

import static com.ntu.ConnectionFactory.getConnection;

import com.codersgang.cg.code.domain.cars;
import com.codersgang.cg.code.conn;
import com.ntu.ConnectionFactory;

import java.sql.*;
import java.util.List;

public class carPFAImpl  implements carPFA{
    @Override
    public cars getcarbyid(long id) {
        try (Connection connection = conn.connect("jdbc:mysql://bxbeira3epme6fr6hvnr-mysql.services.clever-cloud.com", "uuintsqhtq0ys6z3", "bRg0ti2GrMEl0kAyYqU3");
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM avto1 WHERE id=" + id);
        )
        {
            if(rs.next())
            {
                ///для зручності перенесли даний код у приватний метод extractBookFromResultSet
            	/*
                Book book = new Book();
                book.setId(rs.getLong("id"));
                book.setTitle( rs.getString("title") );
                book.setAuthor( rs.getString("author") );
                book.setPrintYear( rs.getInt("printYear") );
                book.setCountOfPages( rs.getInt("countOfPages") );

                return book;
                */

                return extractBookFromResultSet(rs);


            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
     /*   finally {
        	if (connection != null) {
        		try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
        	}
        }*/

        return null;
    }
        )
    }

    @Override
    public List<cars> carbyvendorandmodel(String vendor, String model) {
         try (Connection connection = conn.connect("","","");
    }

    @Override
    public List<cars> allcars() {
        return null;
    }

    @Override
    public boolean inssercar(cars car) {
        return false;
    }

    @Override
    public boolean updatecar(cars car) {
        return false;
    }

    @Override
    public boolean deletecar(long car_id) {
        return false;
    }

    private Book extractBookFromResultSet(ResultSet rs) throws SQLException {

        Book test = new Book();
        test.setId(rs.getLong("car_id"));
        
        /*
        test.setTitle( rs.getString("title") );
        test.setAuthor( rs.getString("author") );
        test.setPrintYear( rs.getInt("printYear") );
        test.setCountOfPages( rs.getInt("countOfPages") );

        return test;

    }
}
