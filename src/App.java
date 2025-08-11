package src;

import java.util.*;
import src.cli.Args;
import src.model.Person;
import src.sort.PersonSorters;

public class App {
    public static void main(String[] args) {
        if (args.length == 0) { help(); return; }

        String cmd = args[0].toLowerCase();
        List<String> rest = Arrays.asList(Arrays.copyOfRange(args, 1, args.length));
        List<Person> people;

        switch (cmd) {
            case "demo":
                people = demoData();
                break;

            case "from":
                // from Name:Age:City ...
                if (rest.isEmpty()) { System.out.println("Usage: from Name:Age:City ..."); return; }
                people = fromTriples(rest);
                break;

            default:
                System.out.println("Unknown command: " + cmd);
                help();
                return;
        }

        System.out.println("Input: " + Args.join(people));

        // Show several sort orders
        show("Natural (Comparable: name A->Z)", sortCopy(people, null));
        show("By NAME (Comparator)", sortCopy(people, PersonSorters.BY_NAME));
        show("By AGE (asc), then name", sortCopy(people, PersonSorters.BY_AGE));
        show("By CITY (A->Z), name, age", sortCopy(people, PersonSorters.BY_CITY));
        show("Composite: CITY, AGE desc, NAME", sortCopy(people, PersonSorters.BY_CITY_AGE_DESC_NAME));
    }

    private static List<Person> demoData() {
        return Arrays.asList(
            new Person("Ann", 22, "Austin"),
            new Person("bill", 30, "Dallas"),
            new Person("Chris", 25, "Austin"),
            new Person("don", 30, "Houston"),
            new Person("Alice", 22, "Dallas"),
            new Person("bob", 28, "Austin")
        );
    }

    private static List<Person> fromTriples(List<String> triples) {
        ArrayList<Person> out = new ArrayList<>();
        for (String[] t : Args.parseTriples(triples)) {
            Integer age = Args.tryParseInt(t[1]);
            if (age == null) { System.out.println("  Skipping (bad age): " + t[0] + ":" + t[1] + ":" + t[2]); continue; }
            out.add(new Person(t[0], age, t[2]));
        }
        return out;
    }

    private static List<Person> sortCopy(List<Person> src, Comparator<Person> cmp) {
        ArrayList<Person> copy = new ArrayList<>(src);
        if (cmp == null) Collections.sort(copy); else copy.sort(cmp);
        return copy;
    }

    private static void show(String label, List<Person> list) {
        System.out.println(label + " -> " + Args.join(list));
    }

    private static void help() {
        System.out.println("Usage: java -cp bin src.App <demo|from> [args]");
        System.out.println("  demo                      -> built-in sample people");
        System.out.println("  from Name:Age:City ...    -> custom people triples");
    }
}
