package com.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaExample1 {

  static class Person {
    String name;
    int age;
    String email;

    public Person(String name, int age, String email) {
      this.name = name;
      this.age = age;
      this.email = email;
    }
  }



  public static void printPerson(List<Person> roster, Predicate<Person> predicate, Consumer<Person> consumer) {
    for (Person p : roster) {
      if (predicate.test(p)) {
        consumer.accept(p);
      }
    }
  }

  public static void printVal(List<Person> roster, Predicate<Person> predicate, Function<Person, String> mapper, Consumer<String> consumer) {
    for (Person p : roster) {
      if (predicate.test(p)) {
        String data = mapper.apply(p);
        consumer.accept(data);
      }
    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    List<Person> roster = new ArrayList<>();
    roster.add(new Person("Ram", 12, "Ram@gmail.com"));
    roster.add(new Person("Shyam", 10, "Shyam@gmail.com"));
    roster.add(new Person("Ravi", 35, "Ravi@gmail.com"));
    roster.add(new Person("Anuj", 19, "Anuj@gmail.com"));
    roster.add(new Person("Ajay", 30, "Ajay@gmail.com"));

    printPerson(roster, p -> p.age >= 18 || p.name.startsWith("R"), p -> System.out.println(p.name));
    printVal(roster, p -> p.age >= 18 || p.name.startsWith("R"), p -> p.email, email -> System.out.println(email));
    roster.stream().filter(p -> p.age < 18).map(p -> p.email).forEach(email -> System.out.println("Not Eligible Email:" + email));
  }

}
