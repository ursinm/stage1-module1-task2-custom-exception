import java.util.Arrays;

public enum Student {

  Shax(1, "Shax", 23),
 Artem(2, "Artem", 21),
 Gleb(3, "Gleb", 24),
  Java(4, "Java", 21),
  Maruf(5, "Maruf", 22),
  Sultan(6, "Sultan", 24),
  Yara(7, "Yara", 20),
  Vahdi(8, "Vahdi", 25),
  Kir(9, "Kir", 26),
  Sultan(10, "Sultan", 24);

  private long id;
  private String name;
  private int age;

  Student(long id, String name, int age) {
    this.id = id;
    this.name = name;
    this.age = age;
  }

  public static Student getValueOf(long id) {
    return Arrays.stream(Student.values())
        .filter(student -> id == student.getId())
        .findFirst()
        .orElse(null);
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
}
