package org.example.weaver;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Nikiforos Xylogiannopoulos
 */
public class WeaverInvocationHandler implements InvocationHandler {

  private ActionStatus actionStatus;
  private final Runnable runnable;

  public WeaverInvocationHandler(final Runnable runnable) {
    this.actionStatus = ActionStatus.READY;
    this.runnable = runnable;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws NoSuchMethodException {
    String methodName = method.getName();
    if ("getStatus".equals(methodName)) {
      return actionStatus;
    }
    if ("execute".equals(methodName)) {
      actionStatus = ActionStatus.RUNNING;
      try {
        runnable.run();
        actionStatus = ActionStatus.FINISHED;
        return null;
      } catch (Exception ex) {
        actionStatus = ActionStatus.FAILED;
        throw new RuntimeException(ex);
      }
    }
    if ("toString".equals(methodName)) {
      return "MagicAction";
    }
    throw new NoSuchMethodException(methodName);
  }
}

