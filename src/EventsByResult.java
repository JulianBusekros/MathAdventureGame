public class EventsByResult {

    private static final Player player = new Player("Julian");

    public void eventIfResultIsFalse(String event){
        switch (event) {
            case "A bandit is trying to attack you. Solve this task to defend yourself: " -> {
                System.out.println("The bandit robbed you and you lost 50HP.");
                player.adjustHealth(-50);
                System.out.println("Current HP: " + player.getHealth());
            }
            case "A friendly pilgrim is offering you a healing potion. Solve this task to gain 20 health: " -> {
                System.out.println("The Pilgrim won't give you the potion.");
                System.out.println("Current HP: " + player.getHealth());
            }
            case "You stumble over a rock. Solve this task to damp the fall: " -> {
                System.out.println("You fell over the rock and lost 10HP.");
                player.adjustHealth(-10);
                System.out.println("Current HP: " + player.getHealth());
            }
            case "A hostile wolf is trying to bite you. Solve this task to defend yourself: " -> {
                System.out.println("The wolf bit you and you lost 40HP.");
                player.adjustHealth(-40);
                System.out.println("Current HP: " + player.getHealth());
            }
            case "You find a medical plant. Solve this task to eat it: " -> {
                System.out.println("You can't eat the plant.");
                System.out.println("Current HP: " + player.getHealth());
            }
            case "A stranger with a sword is appearing. Solve this task to run away: " -> {
                System.out.println("The stranger stabbed you and you lost 120HP.");
                player.adjustHealth(-120);
                System.out.println("Current HP: " + player.getHealth());
            }
            case "A wizard appears. He wants you to solve this task to see if he can trust you: " -> {
                System.out.println("The wizard decided to attack you with his spells and you lost 75HP.");
                player.adjustHealth(-75);
                System.out.println("Current HP: " + player.getHealth());
            }
            case "A soldier appears. Solve this task to show that you are friendly." -> {
                System.out.println("The soldier thinks you are hostile and injures you. You lost 75HP");
                player.adjustHealth(-75);
                System.out.println("Current HP: " + player.getHealth());
            }
        }
    }
    public void eventsIfResultIsTrue(String event){
        switch (event) {
            case "A bandit is trying to attack you. Solve this task to defend yourself: " -> {
                System.out.println("You defended yourself against the bandit.");
                System.out.println("Current HP: " + player.getHealth());
            }
            case "A friendly pilgrim is offering you a healing potion. Solve this task to gain 20 health: " -> {
                System.out.println("The Pilgrim gave you the potion");
                player.adjustHealth(25);
                System.out.println("Current HP: " + player.getHealth());
            }
            case "You stumble over a rock. Solve this task to damp the fall: " -> {
                System.out.println("You managed to damp the fall.");
                System.out.println("Current HP: " + player.getHealth());
            }
            case "A hostile wolf is trying to bite you. Solve this task to defend yourself: " -> {
                System.out.println("You scared the wolf and he ran away.");
                System.out.println("Current HP: " + player.getHealth());
            }
            case "You find a medical plant. Solve this task to eat it: " -> {
                System.out.println("You ate the plant");
                player.adjustHealth(15);
                System.out.println("Current HP: " + player.getHealth());
            }
            case "A stranger with a sword is appearing. Solve this task to run away: " -> {
                System.out.println("You managed to run away fast enough.");
                System.out.println("Current HP: " + player.getHealth());
            }
            case "A wizard appears. He wants you to solve this task to see if he can trust you: " -> {
                System.out.println("The wizard trusts you and heals your wounds. You gain 50HP");
                player.adjustHealth(50);
                System.out.println("Current HP: " + player.getHealth());
            }
            case "A soldier appears. Solve this task to show that you are friendly." -> {
                System.out.println("The soldier thinks you are friendly and gives you a health potion. You gain 50HP");
                player.adjustHealth(50);
                System.out.println("Current HP: " + player.getHealth());
            }
        }
    }
}
