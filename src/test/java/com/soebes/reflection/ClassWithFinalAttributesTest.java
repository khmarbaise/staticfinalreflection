package com.soebes.reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Arrays;

class ClassWithFinalAttributesTest {

  @Test
  void name() {
    ClassWithFinalAttributes classWithFinalAttributes = new ClassWithFinalAttributes("name", "sureName");
    System.out.println("classWithStaticFinalAttributes = " + classWithFinalAttributes);
  }

  @Test
  void changeViaReflection() throws IllegalAccessException {
    ClassWithFinalAttributes classWithFinalAttributes = new ClassWithFinalAttributes("name", "sureName");
    System.out.println("classWithStaticFinalAttributes = " + classWithFinalAttributes);

    Field[] declaredFields = classWithFinalAttributes.getClass().getDeclaredFields();
    System.out.println("declaredFields = " + Arrays.toString(declaredFields));

    Field fieldForName = Arrays.stream(classWithFinalAttributes.getClass().getDeclaredFields())
        .filter(f -> f.getName().equals("name"))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Field name could not be found"));

    fieldForName.setAccessible(true);
    fieldForName.set(classWithFinalAttributes, "AnotherName");
    System.out.println("classWithStaticFinalAttributes = " + classWithFinalAttributes);
  }
}