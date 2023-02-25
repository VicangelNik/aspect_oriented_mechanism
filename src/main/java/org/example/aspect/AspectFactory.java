package org.example.aspect;

import javax.validation.constraints.NotNull;

import org.example.aspect.Aspect.Builder;
import org.example.aspect.Aspect.Weaver;

/**
 * @author Nikiforos Xylogiannopoulos
 */
public final class AspectFactory implements Aspect.Factory {

  @Override
  @NotNull
  public Builder newBuilder() {
    return new AspectBuilder();
  }

  @Override
  @NotNull
  public Weaver newWeaver() {
    return new AspectWeaver();
  }
}
