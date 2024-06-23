package com.soebes.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Reflection4All {
  static class TestClass{
    private static final int MY_CONSTANT;
    private final int finalMember;
    static{
      MY_CONSTANT=1;
    }
    TestClass(){
      finalMember=2;
    }
  }
  public static void main(String... args) throws Exception{
    System.out.println("Initial value: " + TestClass.MY_CONSTANT);
    modifyFinalMember(null,"MY_CONSTANT",-2);
    System.out.println("Modified value: " + TestClass.MY_CONSTANT);
    TestClass myClass = new TestClass();
    System.out.println("Initial value: " + myClass.finalMember);
    modifyFinalMember(myClass,"finalMember",-1);
    System.out.println("Modified value: " + myClass.finalMember);

  }

  private static void modifyFinalMember(Object obj,String fieldName, int newValue) throws Exception {
    Field[] declaredFields = TestClass.class.getDeclaredFields();
    Field field = Arrays.stream(declaredFields).filter(f -> f.getName().endsWith(fieldName))
        .findFirst()
        .orElseThrow(() -> new IllegalStateException("Field " + fieldName + " not found"));

    field.setAccessible(true);
    field.set(obj, newValue);
  }
}
