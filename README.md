# Aspect Mechanism

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

## Assumptions

1) Pointcuts should be chosen only by interface and method's signature
2) Weaving will be applied when asked by user


