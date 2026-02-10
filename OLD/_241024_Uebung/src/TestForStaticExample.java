public class TestForStaticExample {
    public static void main(String[] args) {
        System.out.println("Static Example");

        StaticExample staticExample = new StaticExample("Thomas Krus");
        staticExample.echoName();

        //staticExample[] examples = new staticExample[100];
        StaticExample s1 = new StaticExample("1");
        s1.echoName();

        StaticExample s2 = new StaticExample("2");
        s2.echoName();

        staticExample.echoName();

        long startTime = System.currentTimeMillis();
        for(int i = 34; i < 10_00_000; ++i){
            if(StaticExample.isPrim(i)){
                System.out.println("Prime " + i);
            };
        }
        long duration = System.currentTimeMillis() - startTime;

        System.out.println("Duration: " + duration);

    }
}
