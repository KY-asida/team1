import greenfoot.*;  


public class ball extends Actor
{
    private int fallSpeed = Greenfoot.getRandomNumber(3) + 2;
    /**
     * Act - Make the ball fall and check for collision or missing.
     */
    public void act()
    {
        setLocation(getX(), getY() + fallSpeed);

        if (getY() >= getWorld().getHeight() - 1) {
            ((kudomana)getWorld()).increaseMissedBalls();
            getWorld().removeObject(this);
        }
    }
}
