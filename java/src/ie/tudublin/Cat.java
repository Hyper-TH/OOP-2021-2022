package ie.tudublin;

public class Cat extends Animal
{
    private int numLives = 9;

    public void kill() {
        if (numLives > 0) {
            System.out.println("Ouch!");
            numLives --;
        }
        else {
            System.out.println("I'm dead");
        }
    }

    // Accessor
    public int getNumLives() {
        return numLives;
    }


    public Cat(String name) {
        super(name);
    }
}