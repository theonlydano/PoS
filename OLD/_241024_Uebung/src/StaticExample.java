public class StaticExample {

    // Instanzvariable
    private String name;

    // Klassenvariable
    private static int counter = 0;

    public StaticExample(String name) {
        this.name = name;
        counter++;
    }

    public void echoName(){
        System.out.println("Mi chiamo " + name);
        System.out.println("the counter is " + counter);
    }

    // Klassenmethode
    public static boolean isPrim(int value){
        boolean isPrime = true;
        if(value % 2 == 0){
            isPrime = false;
        }else{
            for(int i = 3; i < Math.sqrt(value); i+=2){
                if(value % i == 0){
                    isPrime = false;
                    break;
                }
            }
        }
        //if(isPrime){
        //    System.out.println(value + " prime");
        //}
        //if(isPrime == false){
        //    System.out.println(value + " is not a prime number");
        //}
        return isPrime == true;
    }
}
