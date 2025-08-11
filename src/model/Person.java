package src.model;

import java.util.Objects;

/** Simple POJO with natural ordering by name (case-insensitive, then case). */
public class Person implements Comparable<Person> {
    private final String name;
    private final int age;
    private final String city;

    public Person(String name, int age, String city) {
        if (name == null || city == null) throw new IllegalArgumentException("name/city required");
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public String name() { return name; }
    public int age() { return age; }
    public String city() { return city; }

    /** Natural order = by name, case-insensitive; tie-break by natural (case). */
    @Override
    public int compareTo(Person o) {
        int ci = String.CASE_INSENSITIVE_ORDER.compare(this.name, o.name);
        if (ci != 0) return ci;
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() { return name + "(" + age + ", " + city + ")"; }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Person)) return false;
        Person p = (Person)obj;
        return age == p.age && name.equals(p.name) && city.equals(p.city);
    }
    @Override
    public int hashCode() { return Objects.hash(name, age, city); }
}
