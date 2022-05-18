package com.cg.code.PFA;

import com.cg.code.domain.cars;

import java.util.List;

public interface carPFA {
    cars getcarbyid(long car_id);

    /**
     * Return a list of cars that match the vendor and model.
     *
     * @param vendor The vendor of the car.
     * @param model The model of the car.
     * @return A list of cars
     */
    static List<cars> carbyvendorandmodel(String vendor, String model) {
        return null;
    }

    /**
     * > This function returns a list of cars
     *
     * @return A list of cars
     */
    static List<cars> allcars() {
        return null;
    }

    /**
     * It returns a boolean value.
     *
     * @param car The car object to be inserted into the database.
     */
    static boolean inssercar(cars car) {
        return false;
    }

    /**
     * This function updates a car in the database.
     *
     * @param car The car object that you want to update.
     */
    static boolean updatecar(cars car) {
        return false;
    }

    /**
     * This function deletes a car from the database.
     *
     * @param car_id The id of the car to delete.
     * @return A boolean value.
     */
    static boolean deletecar(long car_id) {
        return false;
    }
}
