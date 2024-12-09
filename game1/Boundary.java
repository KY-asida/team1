import greenfoot.*; 
public class Boundary extends Actor
{ 
    public boolean getIsTouching()
    {
     if(isTouching(Wall.class)||isTouching(SmallWall.class))
     {
      return true;   
     }
     return false;
    }
}
