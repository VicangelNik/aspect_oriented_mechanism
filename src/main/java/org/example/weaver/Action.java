package org.example.weaver;

/**
 * @author Nikiforos Xylogiannopoulos
 */
public interface Action {

  ActionStatus getStatus();

  void execute();
}
