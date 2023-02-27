package org.example.udemy;

/**
 * @author Nikiforos Xylogiannopoulos
 */
public class ProductServiceImpl implements ProductService {

  @Override
  public int multiply(int num1, int num2) {
    return num1 * num2;
  }

  @Override
  public double division(double num1, double num2) {
    if (num2 == 0) {
      throw new NumberFormatException("Divide by zero is not allowed");
    }
    return num1 / num2;
  }
}
