package ie.tudublin;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Hello world");

        Animal misty = new Animal("Misty");
        Animal lucy = new Animal("Lucy");

        lucy = misty;
        misty.setName("Tara");

        System.out.println(misty);
        System.out.println(lucy);

        // Tara Misty
        // Tara Tara   (Correct one)
        
        // Create new instance of cat object (created on the heap)
        Cat cat = new Cat("Ginger");

        while (cat.getNumLives() > 0) {
            cat.kill();
        }
        cat.kill();
    }
}