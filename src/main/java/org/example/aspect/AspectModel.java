package org.example.aspect;

import java.lang.reflect.Method;

/**
 * @author Nikiforos Xylogiannopoulos
 */
public class AspectModel {

  protected static final Runnable EMPTY_RUNNABLE = () -> {
  };

  protected Class<?>[] targets;
  protected Runnable beforeAdviceRunnable;
  protected Method[] beforeAdviceMethods;
  protected Runnable afterAdviceRunnable;
  protected Method[] afterAdviceMethods;
  protected Runnable aroundAdviceRunnable;
  protected Method[] aroundAdviceMethods;
}
