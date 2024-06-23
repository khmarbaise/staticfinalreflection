package com.soebes.reflection;

import java.util.Objects;

public final class ClassWithStaticFinal {

  public static final String THIS_IS_VALUE = "thisIsValue";

  private final String name;
  private final String sureName;

  public ClassWithStaticFinal(String name, String sureName) {
    this.name = name;
    this.sureName = sureName;
  }

  @Override
  public String toString() {
    return "UserAsClass{" +
           "name='" + name + '\'' +
           ", sureName='" + sureName + '\'' +
           '}';
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, sureName);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ClassWithStaticFinal)) return false;
    ClassWithStaticFinal that = (ClassWithStaticFinal) o;
    return Objects.equals(name, that.name) && Objects.equals(sureName, that.sureName);
  }

  public String name() {
    return name;
  }

  public String sureName() {
    return sureName;
  }

}
