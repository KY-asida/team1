import greenfoot.*;  
/**
 * The player that catches falling balls.
 */
public class Player extends Actor
{
    /**
     * Constructor for Player.
     */
    public Player()
    {
       
        GreenfootImage image = new GreenfootImage(80, 20);
        image.setColor(Color.BLUE);
        image.fillRect(0, 0, 80, 20); 
        setImage(image);
    }

    /**
     * Act - Move left or right and catch balls.
     */
    public void act()
    {
        
        if (Greenfoot.isKeyDown("left") && getX() > 0) {
            move(-5);
        }
        if (Greenfoot.isKeyDown("right") && getX() < getWorld().getWidth() - 1) {
            move(5);
        }
        
        Actor ball = getOneIntersectingObject(ball.class);
        if (ball != null) {
            ((kudomana)getWorld()).increaseScore();
            getWorld().removeObject(ball);
        }
    }
}
