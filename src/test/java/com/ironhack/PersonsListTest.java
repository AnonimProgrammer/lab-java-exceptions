package com.ironhack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonsListTest {
    private PersonsList personsList;
    private Person person;

    @BeforeEach
    void setUp() {
        personsList = new PersonsList();
        person = personsList.add("Omar Ismayilov", 19, "IT");
    }

    @Test
    void findByName_validName_personExists_returnsPerson() {
        Person person = personsList.findByName("Omar Ismayilov");

        assertNotNull(person);
        assertEquals("Omar Ismayilov", person.getName());
    }

    @Test
    void findByName_invalidName_throwsIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> personsList.findByName("Omar"));

        assertEquals("Name cannot be null and must be formatted as 'firstName lastName'",  exception.getMessage());
    }

    @Test
    void clone_returnsCorrectPerson_exceptId() {
        Person clonedPerson = personsList.clone(person);

        assertNotNull(clonedPerson);
        assertNotEquals(person.getId(), clonedPerson.getId());
        assertEquals("Omar Ismayilov", clonedPerson.getName());
        assertEquals(19, clonedPerson.getAge());
        assertEquals("IT", clonedPerson.getOccupation());
    }
}