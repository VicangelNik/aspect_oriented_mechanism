package org.example.aviation;

import java.time.ZonedDateTime;

/**
 * @author Nikiforos Xylogiannopoulos
 */
public interface AirLine {

  void scheduleFlight(ZonedDateTime zonedDateTime, Airport airport);
}
