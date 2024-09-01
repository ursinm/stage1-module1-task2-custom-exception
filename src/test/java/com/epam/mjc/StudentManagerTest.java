package com.epam.mjc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StudentManagerTest {
    private StudentManager manager;

    @Before
    public void setUp() {
        manager = new StudentManager();
    }

    @Test(expected = StudentNotFoundException.class)
    public void findNotValid() {
        manager.find(1000); // ожидаем исключение StudentNotFoundException
    }

    @Test
    public void findValidStudent() {
        assertNotNull("Should find an existing student", manager.find(1));
    }

    @Test
    public void testExceptionMessage() {
        try {
            manager.find(1000);
            fail("Expected an StudentNotFoundException to be thrown");
        } catch (StudentNotFoundException e) {
            assertEquals("Could not find student with ID 1000", e.getMessage());
        }
    }

    @Test
    public void testIDsNotChanged() {
        try {
            manager.find(11);
            fail("Expected an StudentNotFoundException to be thrown");
        } catch (StudentNotFoundException e) {
            assertTrue("The message should indicate the missing ID", e.getMessage().contains("11"));
        }
    }
}
