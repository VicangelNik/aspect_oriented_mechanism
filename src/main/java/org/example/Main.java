package org.example;

import java.lang.reflect.Method;

import org.example.aspect.Aspect;
import org.example.aspect.AspectImpl;
import org.example.udemy.ProductService;
import org.example.udemy.ProductServiceImpl;

/**
 * @author Nikiforos Xylogiannopoulos
 */
public class Main {

  private Class<?>[] targets;
  private static Runnable beforeAdviceRunnable = () -> System.out.println("@Before method execution");
  private Method[] beforeAdviceMethods;
  private static Runnable afterAdviceRunnable = () -> System.out.println("@After method execution");
  private Method[] afterAdviceMethods;
  private static Runnable aroundAdviceRunnable = () -> System.out.println("@Around method execution");
  private Method[] aroundAdviceMethods;

  public static void main(String[] args) throws NoSuchMethodException {

    ProductService productService = new ProductServiceImpl();

    final var factory = new AspectImpl.AspectFactory();

    final var method = productService.getClass().getMethod("division", double.class, double.class);
    Class<?>[] targets = {productService.getClass()};

    final Aspect aspect = factory.newBuilder().withBeforeAdviceFor(beforeAdviceRunnable, method)
      .withAfterAdviceFor(afterAdviceRunnable, method)
      .withAroundAdviceFor(aroundAdviceRunnable, method)
      .withTargets(targets).build();

    final ProductService weave = (ProductService) factory.newWeaver(aspect).weave(productService);
    // weave.multiply(4, 5);
    weave.division(10, 2);
  }
}