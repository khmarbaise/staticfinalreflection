package com.soebes.reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Stream;

class ClassWithStaticFinalTest {

  @Test
  void name() {
    ClassWithStaticFinal ClassWithStaticFinal = new ClassWithStaticFinal("name", "sureName");
    System.out.println("ClassWithStaticFinal = " + ClassWithStaticFinal);
  }

  @Test
  void changeViaReflection() throws IllegalAccessException {
    ClassWithStaticFinal ClassWithStaticFinal = new ClassWithStaticFinal("name", "sureName");
    System.out.println("ClassWithStaticFinal = " + ClassWithStaticFinal);

    Field[] declaredFields = ClassWithStaticFinal.getClass().getDeclaredFields();
    System.out.println("declaredFields = " + Arrays.toString(declaredFields));

    Field thisIsValueField = Arrays.stream(declaredFields).filter(f -> f.getName().equals("THIS_IS_VALUE"))
        .findFirst().orElseThrow(() -> new IllegalStateException("Field THIS_IS_VALUE not found"));
    thisIsValueField.setAccessible(true);
    thisIsValueField.set("String", "AnotherNameVALUE");
    System.out.println("classWithStaticFinalAttributes = " + ClassWithStaticFinal);
  }
}