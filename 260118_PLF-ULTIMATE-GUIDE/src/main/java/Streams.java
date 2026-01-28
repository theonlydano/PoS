import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {

    static int WIDTH = 20;
    static int HEIGHT = 10;

    public static void main(String[] args) {
        ArrayList<Square> object = new ArrayList<>();

        object.add(new Square(0,0));

        object.add(new Square(1,0));
        object.add(new Square(2,0));
        object.add(new Square(3,0));



        object.stream().forEach(square -> {
            // square.update(WIDTH, HEIGHT);
            square.draw(WIDTH, HEIGHT);
            System.out.println();
        });

        List<Square> objectOnlyUneven = object.stream()
                .filter(square -> square.location.getX() % 2 == 1)
                .collect(Collectors.toList());

        System.out.println("#########################################################################################");

        objectOnlyUneven.stream().forEach(square -> {
            // square.update(WIDTH, HEIGHT);
            square.draw(WIDTH, HEIGHT);
            System.out.println();
        });
    }
}
