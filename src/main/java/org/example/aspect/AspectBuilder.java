package org.example.aspect;

import java.lang.reflect.Method;

import org.example.aspect.Aspect.Builder;

/**
 * @author Nikiforos Xylogiannopoulos
 */
public final class AspectBuilder extends AspectModel implements Aspect.Builder {

  @Override
  public Builder withTargets(Class<?>[] targets) {
    this.targets = targets;
    return this;
  }

  @Override
  public Builder withBeforeAdviceFor(Runnable beforeAdvice, Method... methods) {
    this.beforeAdviceRunnable = beforeAdvice;
    this.beforeAdviceMethods = methods;
    return this;
  }

  @Override
  public Builder withAfterAdviceFor(Runnable afterAdvice, Method... methods) {
    this.afterAdviceRunnable = afterAdvice;
    this.afterAdviceMethods = methods;
    return this;
  }

  @Override
  public Builder withAroundAdviceFor(Runnable aroundAdvice, Method... methods) {
    this.aroundAdviceRunnable = aroundAdvice;
    this.aroundAdviceMethods = methods;
    return this;
  }

  @Override
  public Aspect build() {
    return new AspectImpl();
  }
}
