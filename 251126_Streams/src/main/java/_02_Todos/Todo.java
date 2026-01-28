package _02_Todos;

public class Todo {
    public String description;
    public Integer id;

    public Todo(String description, Integer id) {
        this.description = description;
        this.id = id;
    }

    @Override
    public String toString() {
        return id + " Todo{ " + description + "}";
    }
}
