package com.ironhack;

import java.util.Objects;

public class Person {
    private final long id;
    private final String name;
    private int age;
    private final String occupation;

    public Person(long id, String name, int age, String occupation) {
        validateName(name);
        validateAge(age);
        this.id = id;
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    public static void validateName(String name) {
        if (!isValidName(name)) {
            throw new IllegalArgumentException("Name cannot be null and must be formatted as 'firstName lastName'");
        }
    }

    private static boolean isValidName(String name) {
        if (name == null) return false;

        return name.matches("^[A-Za-z]+\\s[A-Za-z]+$");
    }

    private void validateAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }

    public void setAge(int age) {
        validateAge(age);
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getOccupation() {
        return occupation;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person person)) return false;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(occupation, person.occupation);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id: " + id +
                ", name: " + name +
                ", age: " + age +
                ", occupation: " + occupation +
                '}';
    }
}
