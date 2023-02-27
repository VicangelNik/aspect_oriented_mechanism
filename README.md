# Aspect Mechanism

Simple implementation o aspect mechanism in java. The exercise is the implementation of **Aspect** interface
in package _org.example.aspect_. There is also a module (**spring_aspect_programming_example**) that explores a bit spring with aop
and an example for aspectJ without any framework and another one for dynamic proxies.

## Assumptions

1) Pointcuts should be chosen only by interface and method's signature
2) Weaving will be applied when asked by user

## Resources
* [dynamic example + Aspect interface](https://github.com/saikos/advancedProgramming)
* [aspectJ example with spring](https://etraveligroup.udemy.com/course/springframeworkineasysteps/learn/lecture/6894272#overview)
* [What Is the JDK com.sun.proxy.$Proxy Class?](https://www.baeldung.com/jdk-com-sun-proxy)
* [Dynamic Proxy Classes](https://docs.oracle.com/javase/8/docs/technotes/guides/reflection/proxy.html)
* [Introduction to Spring AOP](https://www.baeldung.com/spring-aop)
* [Spring AOP + @AspectJ Annotation Example](https://www.concretepage.com/spring/spring-aop-aspectj-annotation)



## Knowledge Base

### Join Point

Places where crosscutting concerns can be woven in.
Ex. method call, field access, object creation.

### Pointcut

a pointcut is a predicate on dynamic join points that:

- can match or not match any given join point
- says “what is true” when the pointcut matches
- can optionally expose some values at that join point

It is actually a declaration that selects join points and collects contexts at that point.

example: {execution(void Line.setP1(Point))}
matches method execution join points with this signature

### Advice

Code to be executed at a join point. Three types: before, after and around.

### Weaver

An aspect weaver takes information from raw classes and aspects and creates new classes with the aspect code
appropriately weaved into the classes.

Weaving rules specify how to integrate the final system.

Can be implemented in various ways:

- Source to source translation.
- Bytecode enhancement, first compile source with original compiler, then weave aspects into class files.
- Just-in-time weaving done by a classloader.
- By the language compiler.


