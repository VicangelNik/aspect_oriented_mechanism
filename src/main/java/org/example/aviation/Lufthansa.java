package org.example.aviation;

import java.time.ZonedDateTime;

/**
 * @author Nikiforos Xylogiannopoulos
 */
public class Lufthansa implements AirLine {

  @Override
  public void scheduleFlight(ZonedDateTime zonedDateTime, Airport airport) {
    if (!airport.getAirlines().contains(this)) {
      throw new RuntimeException("Airline is not cooperated with this airport");
    }
  }
}
