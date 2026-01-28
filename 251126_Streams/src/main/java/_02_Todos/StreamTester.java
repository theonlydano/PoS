package _02_Todos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTester {
    public static void main(String[] args) {
        // your turn: generate a List of Todos with 100 entries.
        // the first To-do starts with 1, next 2, ...
        // the descriptiion of the To-do with id 4 is: <dateOfToday>.To-Do4.togo
        // example: "251126.To-Do4.togo" for To-Do with id 4.

        List<Todo> todoList = new ArrayList<>();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyMMdd");
        String localDate = LocalDate.now().format(dtf);

        IntStream
                .range(1, 100)
                .forEach(e -> todoList.add(new Todo(localDate + ".To-Do" + e + ".togo", e)));

        todoList.stream().forEach(System.out::println);
    }
}
