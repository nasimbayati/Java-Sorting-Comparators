package src.sort;

import java.util.Comparator;
import src.model.Person;

/** Alternate comparators for Person. */
public class PersonSorters {
    /** By name A->Z (case-insensitive), tie-break by natural case. */
    public static final Comparator<Person> BY_NAME =
        Comparator.comparing(Person::name, String.CASE_INSENSITIVE_ORDER)
                  .thenComparing(Person::name);

    /** By age ascending, then name. */
    public static final Comparator<Person> BY_AGE =
        Comparator.comparingInt(Person::age)
                  .thenComparing(BY_NAME);

    /** By city A->Z (case-insensitive), then name, then age. */
    public static final Comparator<Person> BY_CITY =
        Comparator.comparing(Person::city, String.CASE_INSENSITIVE_ORDER)
                  .thenComparing(BY_NAME)
                  .thenComparingInt(Person::age);

    /** Composite: city A->Z, then age desc, then name A->Z. */
    public static final Comparator<Person> BY_CITY_AGE_DESC_NAME =
        Comparator.comparing(Person::city, String.CASE_INSENSITIVE_ORDER)
                  .thenComparing((Person p) -> -p.age())
                  .thenComparing(BY_NAME);
}
