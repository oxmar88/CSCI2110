/*
*
*
*
*
*
*
* */




import java.util.Random;

public class Demo {
    public static void main(String[] args) {

        Field field = new Field(0.0,0.0,500.0,400.0);
        Ball ball = new Ball();
        ball.setBx(100.0);
        ball.setBy(200.0);



        Player player1 = new Player("Omar");
        Player player2 = new Player("Srini");

        System.out.println("SOCCER GAME SETUP!");
        System.out.println();

        System.out.println("Player 1: " + player1);
        System.out.println("Player 2: " + player2);
        System.out.println(); // just for output display purposes

        Random rand = new Random();

        /*
          used W3 schools java documentation to figure out how to create random numbers
          source : https://www.w3schools.in/java/examples/generate-random-numbers
        */


        for(int i = 0; i < 10; i++ ){
            double distance = rand.nextDouble(500.0);
            double direction = rand.nextDouble(360.0);

            boolean reflected = player1.kick(field,ball,distance,direction); // letting player 1 kick the ball 10 times using kick method in player class

            System.out.printf("kick " + (i +1) + ": " + player1 + " kicks the ball a distance of " + "%.2f" , distance);
            System.out.printf(" m and at an angle of " + "%.2f" , direction);
            System.out.println(" degrees.");

            ball.printBallPos(); // extra method I created to enable simpler printing of ball position

            System.out.println();
            System.out.println("Reflected = " + reflected);
            System.out.println();
        }

        System.out.println("NEXT PLAYERS TURN ");
        System.out.println();

        for(int i = 0; i < 10; i++ ){
            double distance = rand.nextDouble(500.0);
            double direction = rand.nextDouble(360.0);

            boolean reflected = player2.kick(field,ball,distance,direction);

            System.out.printf("kick " + (i +1) + ": " + player2 + " kicks the ball a distance of " + "%.2f" , distance);
            System.out.printf(" m and an angle of " + "%.2f" , direction);
            System.out.println(" degrees.");

            ball.printBallPos();

            System.out.println();
            System.out.println("Reflected = " + reflected);
            System.out.println();
        }


    }

}