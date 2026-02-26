package com.ironhack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    private Person person;

    @BeforeEach
    void setUp() {
        person = new Person(
                1,
                "Omar Ismayilov",
                19,
                "IT"
        );
    }

    @Test
    void setAge_validAge_setsSuccessfully() {
        person.setAge(20);

        assertEquals(20, person.getAge());
    }

    @Test
    void setAge_invalidAge_throwsIllegalArgumentException() {
       IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> person.setAge(-1));

       assertEquals("Age cannot be negative", exception.getMessage());
    }
}