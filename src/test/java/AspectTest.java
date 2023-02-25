import org.example.udemy.ProductServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Nikiforos Xylogiannopoulos
 */
class AspectTest {

  @Test
  void testMultiply() {
    final var productService = new ProductServiceImpl();
    final int result = productService.multiply(4, 5);
    assertEquals(20, result);
  }
}
