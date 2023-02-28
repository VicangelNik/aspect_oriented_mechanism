package org.example.weaver;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.example.aspect.Aspect;

/**
 * @author Nikiforos Xylogiannopoulos
 */
public class WeaverInvocationHandler implements InvocationHandler {

  private ActionStatus actionStatus;
  private final Object target;
  private final Aspect aspect;

  public WeaverInvocationHandler(final Object target, final Aspect aspect) {
    this.actionStatus = ActionStatus.READY;
    this.target = target;
    this.aspect = aspect;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) {
    final String methodName = method.getName();

    if (!method.getDeclaringClass().isInterface()) {
      throw new IllegalArgumentException("Method should come from interface as assumptions suggest");
    }

    if (Arrays.stream(target.getClass().getInterfaces()).noneMatch(clazz -> clazz.toString().equals(method.getDeclaringClass().toString()))) {
      throw new IllegalArgumentException("target class should be an implementation of method's interface");
    }

    if ("toString".equals(methodName)) {
      return "WeaverInvocationHandler"; // the name of the proxy instance. proxy is a WeaverInvocationHandler instance
    } else {
      actionStatus = ActionStatus.RUNNING;
      final Runnable aroundRunnable = aspect.aroundAdviceFor(method);
      try {
        aspect.beforeAdviceFor(method).run();
        aroundRunnable.run();
        final Object returnValue = method.invoke(target, args);
        System.out.println(returnValue);
        aspect.afterAdviceFor(method).run();
        aroundRunnable.run();
        actionStatus = ActionStatus.FINISHED;

        return returnValue;
      } catch (Exception ex) {
        System.out.println("exception occurred :" + ex.getMessage() + System.lineSeparator() + " with status " + actionStatus);
        actionStatus = ActionStatus.FAILED;
        throw new RuntimeException(ex);
      }
    }
  }
}

