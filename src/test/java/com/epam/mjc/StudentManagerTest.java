package com.epam.mjc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StudentManagerTest {
    private StudentManager manager;

    @Before
    public void setUp() {
        manager = new StudentManager();
        // Добавляем студента с ID 1
        manager.addStudent(new Student(1L, "John Doe"));
        manager.addStudent(new Student(2L, "Jane Doe"));
    }

    @Test(expected = StudentNotFoundException.class)
    public void findNotValid() {
        // Ожидаем, что студент с ID 1000 не существует и будет выброшено исключение
        manager.find(1000L);
    }

    @Test
    public void findValidStudent() {
        // Проверяем, что студент с ID 1 существует и успешно найден
        Student student = manager.find(1L);
        assertNotNull("Студент должен быть найден", student);
        assertEquals("John Doe", student.getName());
    }

    @Test
    public void testExceptionMessage() {
        // Проверяем, что выбрасывается правильное сообщение исключения
        try {
            manager.find(1000L);
            fail("Ожидалось исключение StudentNotFoundException");
        } catch (StudentNotFoundException e) {
            assertEquals("Не удалось найти студента с ID 1000", e.getMessage());
        }
    }

    @Test
    public void testIDsNotChanged() {
        // Проверяем, что выбрасывается исключение с корректным ID
        try {
            manager.find(11L);
            fail("Ожидалось исключение StudentNotFoundException");
        } catch (StudentNotFoundException e) {
            assertTrue("Сообщение должно содержать ID 11", e.getMessage().contains("11"));
        }
    }
}
