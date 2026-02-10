
import java.util.*;
public class Level1Jan {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int numberOfFlights = scanner.nextInt();
            scanner.nextLine();


            int[] values = new int[numberOfFlights];
            for (int i = 0; i < numberOfFlights; i++) {
                String line = scanner.nextLine();
                String[] velocitiesStr = line.split(" ");

                int height = 0;

                for (String v : velocitiesStr) {
                    int velocity = Integer.parseInt(v);
                    height += velocity;
                    if (height < 0) {
                        height = 0;
                    }
                }
                values[i] = height;
            }
            for (int i = 0; i < numberOfFlights; i++) {
                System.out.println(values[i]);
            }
        }
    }

