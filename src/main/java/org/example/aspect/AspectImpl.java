package org.example.aspect;

import java.lang.reflect.Method;

import javax.validation.constraints.NotNull;

/**
 * @author Nikiforos Xylogiannopoulos
 */
public class AspectImpl extends AspectModel implements Aspect {

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

  public static final class AspectBuilder extends AspectModel implements Aspect.Builder {

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
    @NotNull
    public Aspect build() {
      final var aspect = new AspectImpl();
      aspect.targets = this.targets;
      aspect.beforeAdviceRunnable = this.beforeAdviceRunnable;
      aspect.beforeAdviceMethods = this.beforeAdviceMethods;
      aspect.afterAdviceRunnable = this.afterAdviceRunnable;
      aspect.afterAdviceMethods = this.afterAdviceMethods;
      aspect.aroundAdviceRunnable = this.aroundAdviceRunnable;
      aspect.aroundAdviceMethods = this.aroundAdviceMethods;
      return aspect;
    }
  }
}
