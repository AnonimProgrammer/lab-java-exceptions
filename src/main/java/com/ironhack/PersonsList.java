package com.ironhack;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonsList {
    private List<Person> persons;
    private int nextId = 1;

    public PersonsList() {
        this.persons = new ArrayList<>();
    }

    public Person add(String name, int age, String occupation) {
        Person person = new Person(nextId++, name, age, occupation);
        persons.add(person);

        return person;
    }

    public Person findByName(String name) {
        Person.validateName(name);
        for (Person person : persons) {
            if (person.getName().equalsIgnoreCase(name)) {
                return person;
            }
        }
        return null;
    }

    public Person clone(Person person) {
        return new Person(
                nextId++,
                person.getName(),
                person.getAge(),
                person.getOccupation()
        );
    }

    public void writeToFile(Person person, String fileName) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(person.toString());
            writer.write(System.lineSeparator());
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
