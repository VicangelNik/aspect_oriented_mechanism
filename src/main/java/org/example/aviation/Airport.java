package org.example.aviation;

import java.util.List;

/**
 * @author Nikiforos Xylogiannopoulos
 */
public interface Airport {

  void addAirline(AirLine airline);

  List<AirLine> getAirlines();
}
