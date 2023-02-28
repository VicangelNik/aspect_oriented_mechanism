package org.example.aspect;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.example.weaver.WeaverInvocationHandler;

/**
 * @author Nikiforos Xylogiannopoulos
 */
public class AspectImpl extends AspectModel implements Aspect {

  private final Map<Runnable, List<Method>> adviceMethodMap = new HashMap<>();

  private AspectImpl() {
    // initialization only via builder
  }

  @Override
  public Class<?>[] getTargets() {
    return targets;
  }

  @Override
  public Runnable beforeAdviceFor(Method method) {
    final List<String> beforeAdviceMethods = adviceMethodMap.get(beforeAdviceRunnable).stream().map(Method::getName).collect(Collectors.toList());

    if (beforeAdviceMethods.contains(method.getName())) {
      return beforeAdviceRunnable;
    }

    return EMPTY_RUNNABLE;
  }

  @Override
  public Runnable afterAdviceFor(Method method) {
    final List<String> afterAdviceMethods = adviceMethodMap.get(afterAdviceRunnable).stream().map(Method::getName).collect(Collectors.toList());

    if (afterAdviceMethods.contains(method.getName())) {
      return afterAdviceRunnable;
    }

    return EMPTY_RUNNABLE;
  }

  @Override
  public Runnable aroundAdviceFor(Method method) {
    final List<String> aroundAdviceMethods = adviceMethodMap.get(aroundAdviceRunnable).stream().map(Method::getName).collect(Collectors.toList());

    if (aroundAdviceMethods.contains(method.getName())) {
      return aroundAdviceRunnable;
    }

    return EMPTY_RUNNABLE;
  }

  public static final class AspectBuilder extends AspectModel implements Aspect.Builder {

    private AspectBuilder() {
      // initialization only via factory
    }

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
      aspect.adviceMethodMap.put(beforeAdviceRunnable, List.of(this.beforeAdviceMethods));
      aspect.beforeAdviceMethods = this.beforeAdviceMethods;

      aspect.afterAdviceRunnable = this.afterAdviceRunnable;
      aspect.adviceMethodMap.put(afterAdviceRunnable, List.of(this.afterAdviceMethods));
      aspect.afterAdviceMethods = this.afterAdviceMethods;

      aspect.aroundAdviceRunnable = this.aroundAdviceRunnable;
      aspect.adviceMethodMap.put(aroundAdviceRunnable, List.of(this.aroundAdviceMethods));
      aspect.aroundAdviceMethods = this.aroundAdviceMethods;

      return aspect;
    }
  }

  public static class WeaverImpl implements Aspect.Weaver {

    private final Aspect aspect;

    private WeaverImpl(Aspect aspect) {
      // initialization only via aspect factory
      this.aspect = aspect;
    }

    @Override
    public Object weave(Object target) {
      if (target == null) {
        throw new RuntimeException("Target should not be null when calling weaver..");
      }
      System.out.println("weaving starting..");
      return Proxy.newProxyInstance(
        target.getClass().getClassLoader(),
        target.getClass().getInterfaces(),
        new WeaverInvocationHandler(target, aspect));
    }
  }

  public static final class AspectFactory implements Aspect.Factory {

    @Override
    @NotNull
    public Builder newBuilder() {
      return new AspectBuilder();
    }

    @Override
    public Weaver newWeaver() {
      return null;
    }

    @NotNull
    public Weaver newWeaver(final Aspect aspect) {
      return new WeaverImpl(aspect);
    }
  }
}
