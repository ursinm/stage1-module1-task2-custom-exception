package com.epam.mjc;

import java.util.HashMap;
import java.util.Map;

public class StudentManager {
    private Map<Long, String> students = new HashMap<>();

    // Метод для добавления студентов в систему (опционально)
    public void addStudent(Long id, String name) {
        students.put(id, name);
    }

    // Метод поиска студента по ID
    public String find(Long id) {
        if (!students.containsKey(id)) {
            throw new StudentNotFoundException(id); // Выбрасываем пользовательское исключение
        }
        return students.get(id); // Возвращаем имя студента, если найден
    }
}
