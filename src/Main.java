public class Main {
    public static void main(String[] args) {

        Game game = new Game(5,5);

        game.addAliveField(new Field(2, 2));
        game.addAliveField(new Field(3, 2));
        game.addAliveField(new Field(4, 2));

        System.out.println(game);

        System.out.println("------------------------");

        game.step();

        System.out.println(game);
    }
}