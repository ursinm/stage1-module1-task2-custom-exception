package com.epam.mjc;


public class StudentManager {
    private Map<String, Student> studentMap;

    public StudentManager() {
        this.studentMap = new HashMap<>();
    }

    // Добавление студента в систему
    public void addStudent(Student student) {
        studentMap.put(student.getId(), student);
    }

    // Поиск студента по ID
    public Student find(String id) throws StudentNotFoundException {
        if (!studentMap.containsKey(id)) {
            throw new StudentNotFoundException(id);
        }
        return studentMap.get(id);
    }
}
