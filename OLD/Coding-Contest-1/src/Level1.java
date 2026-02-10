import java.util.Scanner;

public class Level1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numberOfFlights = sc.nextInt();
        int velocity;
        //int[] height = new int[numberOfFlights+1];
        //height[0] = 0;


        //splitting rawr UwU <3 awww :3  0v0
        //:3 :=3 :==3 ((.))<=====3
        //   (ovo)
        //  /(.)(.)\
        //    | |
        /*
        // UwU
        //  .____.
        //  |  \ |
        //  |   \|
        //  o    |
        // /|\   |
        //  |    |
        // / \   |
        //       |
        //^^^^^ ____
        int[][] velocities = new int[numberOfFlights][];
        for(int i = 0;i < numberOfFlights;i++){
            String[] input = sc.nextLine().split(" ");

            for (int j = 0; j < input.length; j++){
                velocities[i][j] = Integer.parseInt(input[j]);
            }
        }*/






        // Berechnung der höhe[i+1] = höhe[i] + geschwindigkeit

        /*for(int i = 0; i < numberOfFlights; i++){
            for(int j = 0; j < 4; j++){
                velocity = sc.nextInt();
                height[i+1] += height[i] + velocity;
            }
            System.out.println(height[i+1]);
            for(int j = 0; j < height.length; j++){

                height[j] = 0;
            }
        }*/

        for(int i = 0; i < numberOfFlights; i++){
            int height = 0;
            for(int j = 0; j < 20; j++){
                velocity = sc.nextInt();
                height += velocity;
            }
            System.out.println(height);
        }
    }
}
