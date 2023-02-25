package org.example.aviation;

import java.time.ZonedDateTime;

/**
 * @author Nikiforos Xylogiannopoulos
 */
public class Aegean implements AirLine{

  @Override
  public void scheduleFlight(ZonedDateTime zonedDateTime, Airport airport) {
    if (!airport.getAirlines().contains(this)) {
      airport.addAirline(this);
    }
  }
}
