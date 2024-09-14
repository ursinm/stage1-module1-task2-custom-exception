package com.epam.mjc;

public class Student {
    private Long id;
    private String name;

    // Конструктор
    public Student(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Геттеры
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Сеттеры (если нужно изменять данные студента)
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Переопределим equals и hashCode для корректного сравнения объектов Student
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return id.equals(student.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    // Переопределим метод toString для удобного вывода данных студента
    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "'}";
    }
}
