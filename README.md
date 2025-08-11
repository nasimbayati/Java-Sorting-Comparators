# java-sorting-comparators

Beginner/intermediate demo of Java sorting:
- `Comparable<Person>` for natural ordering (name A→Z, case-insensitive)
- Multiple `Comparator<Person>`s (by name, by age, by city, and a composite)

## Build
```bat
build.bat
```

## Run
```bat
java -cp bin src.App demo
java -cp bin src.App from Ann:22:Austin bill:30:Dallas Chris:25:Austin
```

## What this shows
* Implementing compareTo for a domain class

* Writing reusable Comparator instances

* Stable, readable outputs that are easy to verify

## Academic Honesty
Sanitized, original portfolio sample inspired by coursework.
Do not submit it as a class assignment.

## License
MIT