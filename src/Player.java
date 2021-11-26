public class Player {

    private static int health;
    private final String name;

    public Player(String name) {
        health = 200;
        this.name = name;
    }
    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public void adjustHealth(int damageOrHealing){

        health += damageOrHealing;

        if (health <= 0){
            System.out.println("You died");
        }
    }
}
