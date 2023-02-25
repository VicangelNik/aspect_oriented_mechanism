package org.example.aviation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nikiforos Xylogiannopoulos
 */
public class ElVenizelos implements Airport{

  List<AirLine> airlineList = new ArrayList<>();
  @Override
  public void addAirline(AirLine airline) {
    airlineList.add(airline);
  }

  @Override
  public List<AirLine> getAirlines() {
    return airlineList;
  }
}
