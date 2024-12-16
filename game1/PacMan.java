import greenfoot.*;
public class PacMan extends Actor
{
    /* RedGhost red = new RedGhost();
     PinkGhost pink = new PinkGhost();
     BlueGhost blue = new BlueGhost();
     OrangeGhost orange = new OrangeGhost();*/
     Boundary e = new Boundary();
     Boundary f = new Boundary();
     Boundary g = new Boundary();
     Boundary h = new Boundary();
     /*
     Score1 score1 = new Score1();
     Score10 score10 = new Score10();
     Score100 score100 = new Score100();
     Score1000 score1000 = new Score1000();
     Score1 highScore1 = new Score1();
     Score10 highScore10 = new Score10();
     Score100 highScore100 = new Score100();
     Score1000 highScore1000 = new Score1000();
     Life life1 = new Life();
     Life life2 = new Life();
     Life life3 = new Life();
     Fruit fruit1 = new Fruit();
     Fruit fruit2 = new Fruit();
     BigBall bigBall1 = new BigBall();
     BigBall bigBall2 = new BigBall();
     BigBall bigBall3 = new BigBall();
     BigBall bigBall4 = new BigBall();
     Timer ghostTimer = new Timer();
     Timer redGhostRespawnTimer = new Timer();
     Timer pinkGhostRespawnTimer = new Timer();
     Timer blueGhostRespawnTimer = new Timer();
     Timer orangeGhostRespawnTimer = new Timer();*/
     PacManCatcher catcher = new PacManCatcher();
     /*
     boolean powerUp=false;
     int livesLeft=3;
     */
     int teleportCount=0;
     
     int ballCount=0;
     /*
     boolean gameOver=false;
     Timer chompTimer = new Timer();
     */
     int gameWinCount=0;
     Timer ballSoundTimer = new Timer();
     boolean ballTimerStarted=false;
     //static int highScore;
     int pacManImage=0;    
     
    public void act() 
    
    {
        if(pacManImage==0)
        {
            this.setImage("pacman3.jpg");
        }
        if(pacManImage==1)
        {
            this.setImage("pacman2.gif");
        }
        if(pacManImage==2)
        {
            this.setImage("pacman4.gif");
        }
        
        //setHighScore(highScore);
        //movement
       if(Greenfoot.isKeyDown("Right"))
       {
           if(!g.getIsTouching())
           {
               if(pacManImage==2)
               {
                   pacManImage=0;
                }
                else
                {
                    pacManImage++;
                }
               catcher.setRotation(0);
                catcher.move(2);
                e.setRotation(0);
                e.move(2);
                f.setRotation(0);
                f.move(2);
                g.setRotation(0);
                g.move(2);
                h.setRotation(0);
                h.move(2);
                setRotation(0);
                move(2);
           }
       }
        if(Greenfoot.isKeyDown("Left"))
       {
           if(!h.getIsTouching())
           {
               if(pacManImage==2)
               {
                   pacManImage=0;
                }
                else
                {
                    pacManImage++;
                }
               catcher.setRotation(180);
               catcher.move(2);
               e.setRotation(180);
               e.move(2);
               f.setRotation(180);
               f.move(2);
               g.setRotation(180);
               g.move(2);
               h.setRotation(180);
               h.move(2);
               setRotation(180);
               move(2);
            }
       }
       if(Greenfoot.isKeyDown("Up"))
       {
           if(!e.getIsTouching())
           {
               if(pacManImage==2)
               {
                   pacManImage=0;
                }
                else
                {
                    pacManImage++;
                }
               catcher.setRotation(270);
               catcher.move(2);
               e.setRotation(270);
               e.move(2);
               f.setRotation(270);
               f.move(2);
               g.setRotation(270);
               g.move(2);
               h.setRotation(270);
               h.move(2);
               setRotation(270);
               move(2);
           }
        }
        if(Greenfoot.isKeyDown("Down"))
       {
           if(!f.getIsTouching())
           {
               if(pacManImage==2)
               {
                   pacManImage=0;
                }
                else
                {
                    pacManImage++;
                }
               catcher.setRotation(90);
               catcher.move(2);
               e.setRotation(90);
               e.move(2);
               f.setRotation(90);
               f.move(2);
               g.setRotation(90);
               g.move(2);
               h.setRotation(90);
               h.move(2);
               setRotation(90); 
               move(2);
           }
       }
       if(catcher.returnIntersectingBalls()!=null)
       {
           if(ballSoundTimer.getTime()==0)
           {
               
               ballTimerStarted=true;
            }
           gameWinCount++;
            getWorld().removeObject((Ball)(catcher.returnIntersectingBalls()));
            ballCount++;
       }
       if(this.isTouching(TeleportWall.class))
       {
           teleportCount++;
           if(teleportCount%2==1)
           {
               this.setLocation(497,200);
               catcher.setLocation(497,200);
               e.setLocation(498,186);
               f.setLocation(498,214);
               g.setLocation(511,200);
               h.setLocation(484,200);
            }
           if(teleportCount%2==0)
           {
                this.setLocation(117,200);
                catcher.setLocation(117,200);
                e.setLocation(118,186);
                f.setLocation(118,214);
                g.setLocation(132,200);
                h.setLocation(102,200);
           }
       }
       
    }
    public Boundary getUpperBound()
    {
        return e;
    }
    public Boundary getLowerBound()
    {
        return f;
    }
    public Boundary getRightBound()
    {
        return g;
    }
    public Boundary getLeftBound()
    {
        return h;
    }
    public PacManCatcher getPacManCatcher()
    {
      return catcher;        
    }
    
}
