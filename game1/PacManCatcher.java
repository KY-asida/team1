import greenfoot.*;
import java.util.ArrayList;
public class PacManCatcher extends Actor
{
    public Object returnIntersectingBalls()
    {
        return this.getOneIntersectingObject(Ball.class);
    }
    /*public Object returnIntersectingFruit()
    {
        return this.getOneIntersectingObject(Fruit.class);
    }
    public Object returnIntersectingRedGhost()
    {
        return this.getOneIntersectingObject(RedGhost.class);
    }
    public Object returnIntersectingPinkGhost()
    {
        return this.getOneIntersectingObject(PinkGhost.class);
    }
    public Object returnIntersectingBlueGhost()
    {
        return this.getOneIntersectingObject(BlueGhost.class);
    }
    public Object returnIntersectingOrangeGhost()
    {
        return this.getOneIntersectingObject(OrangeGhost.class);
    }
    public Object returnIntersectingBigBall()
    {
        return this.getOneIntersectingObject(BigBall.class);
    }*/
}
