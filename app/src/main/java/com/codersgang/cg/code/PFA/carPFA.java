package com.codersgang.cg.code.PFA;

import com.codersgang.cg.code.domain.cars;

import java.util.List;

public interface carPFA {
    cars getcarbyid(long car_id);
    List<cars> carbyvendorandmodel(String vendor, String model);
    List<cars> allcars();
    boolean inssercar(cars car);
    boolean updatecar(cars car);
    boolean deletecar(long car_id);
}
