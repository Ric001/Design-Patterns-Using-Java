public class TestDrive {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        ((MallardDuck) mallard).display();
        mallard.performFly();
        mallard.performQuack();
        
    }
}