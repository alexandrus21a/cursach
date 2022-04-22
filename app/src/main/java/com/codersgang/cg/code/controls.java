package com.codersgang.cg.code;

import java.util.List;

public interface controls {
    cars getcarbyid(long id);
    List<cars> carbyvendorandmodel(String vendor, String model);
    List<cars> allcars();
    boolean inssercar(cars car);
    boolean updatecar(cars car);
    boolean deletecar(long car_id);
}
