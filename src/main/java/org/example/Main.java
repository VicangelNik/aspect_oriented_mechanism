package org.example;

import java.lang.reflect.Proxy;

import org.example.weaver.Action;
import org.example.weaver.WeaverInvocationHandler;

/**
 * @author Nikiforos Xylogiannopoulos
 */
public class Main {

  public static void main(String[] args) {
    System.out.println("execution starting..");
    Action action2 = (Action) Proxy.newProxyInstance(
      WeaverInvocationHandler.class.getClassLoader(),
      new Class[]{Action.class},
      new WeaverInvocationHandler(() -> System.out.println("RUN"))
    );
    action2.execute();
  }
}