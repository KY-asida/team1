import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class kudomana extends World
{
    private int score = 0; // Player's score
    private int missedBalls = 0; // Count of missed balls

    public kudomana()
    {    
        super(600, 400, 1); 

        Player player = new Player();
        addObject(player, getWidth() / 2, getHeight() - 30);

       Greenfoot.setSpeed(50);
    }

    /**
     * Act - Randomly generate falling balls.
     */
    public void act()
    {
        if (Greenfoot.getRandomNumber(100) < 2) { 
            ball newBall = new ball();
            addObject(newBall, Greenfoot.getRandomNumber(getWidth()), 0);
        }

        showText("Score: " + score, 50, 10);
        showText("Missed: " + missedBalls, 150, 10);

        if (missedBalls >= 5) {
            showText("Game Over!", getWidth() / 2, getHeight() / 2);
            Greenfoot.stop();
        }
    }

    /**
     * Increase the score.
     */
    public void increaseScore()
    {
        score++;
    }

    /**
     * Increase the missed ball count.
     */
    public void increaseMissedBalls()
    {
        missedBalls++;
    }
}
