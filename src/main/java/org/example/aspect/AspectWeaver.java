package org.example.aspect;

import javax.validation.constraints.NotNull;

/**
 * @author Nikiforos Xylogiannopoulos
 */
public class AspectWeaver implements Aspect.Weaver{

  @Override
  public Object weave(@NotNull final Object target) {
    return null;
  }
}
