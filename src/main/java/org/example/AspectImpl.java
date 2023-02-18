package org.example;

import java.lang.reflect.Method;

/**
 * @author Nikiforos Xylogiannopoulos
 */
public class AspectImpl implements Aspect, Aspect.Weaver, Aspect.Factory, Aspect.Builder {

  @Override
  public Class<?>[] getTargets() {
    return new Class[0];
  }

  @Override
  public Runnable beforeAdviceFor(Method method) {
    return null;
  }

  @Override
  public Runnable afterAdviceFor(Method method) {
    return null;
  }

  @Override
  public Runnable aroundAdviceFor(Method method) {
    return null;
  }

  @Override
  public Object weave(Object target) {
    return null;
  }

  @Override
  public Builder newBuilder() {
    return null;
  }

  @Override
  public Weaver newWeaver() {
    return null;
  }

  @Override
  public Builder withTargets(Class<?>[] targets) {
    return null;
  }

  @Override
  public Builder withBeforeAdviceFor(Runnable beforeAdvice, Method... methods) {
    return null;
  }

  @Override
  public Builder withAfterAdviceFor(Runnable afterAdvice, Method... methods) {
    return null;
  }

  @Override
  public Builder withAroundAdviceFor(Runnable aroundAdvice, Method... methods) {
    return null;
  }

  @Override
  public Aspect build() {
    return null;
  }
}
