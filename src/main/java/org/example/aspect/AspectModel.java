package org.example.aspect;

import java.lang.reflect.Method;

/**
 * @author Nikiforos Xylogiannopoulos
 */
public class AspectModel {

  protected Class<?>[] targets;
  protected Runnable beforeAdviceRunnable;
  protected Method[] beforeAdviceMethods;
  protected Runnable afterAdviceRunnable;
  protected Method[] afterAdviceMethods;
  protected Runnable aroundAdviceRunnable;
  protected Method[] aroundAdviceMethods;
}
