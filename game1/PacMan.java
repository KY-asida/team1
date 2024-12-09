import greenfoot.*;
public class PacMan extends Actor
{
    /* RedGhost red = new RedGhost();
     PinkGhost pink = new PinkGhost();
     BlueGhost blue = new BlueGhost();
     OrangeGhost orange = new OrangeGhost();
     Boundary e = new Boundary();
     Boundary f = new Boundary();
     Boundary g = new Boundary();
     Boundary h = new Boundary();
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
     Timer orangeGhostRespawnTimer = new Timer();
     PacManCatcher catcher = new PacManCatcher();
     boolean powerUp=false;
     int livesLeft=3;
     int teleportCount=0;
     int ballCount=0;
     boolean gameOver=false;
     Timer chompTimer = new Timer();
     int gameWinCount=0;
     Timer ballSoundTimer = new Timer();
     boolean ballTimerStarted=false;
     static int highScore;*/
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
       
       if(livesLeft==0)
       {
            gameOver=true;
            getImage().setTransparency(0);
            if(ballCount>highScore)
            {
            highScore=ballCount;
            setHighScore(highScore);
            }
            
            getWorld().addObject(new GameOverScreen(),300,300);
       }
       /*
       if(gameWinCount==268)
       {
           gameOver=true;
           if(ballCount>highScore)
            {
            highScore=ballCount;
            setHighScore(highScore);
            }
            getImage().setTransparency(0);
            getWorld().addObject(new YouWinScreen(),300,300);
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
       if(catcher.returnIntersectingBalls()!=null&&!gameOver)
       {
           if(ballSoundTimer.getTime()==0)
           {
               Greenfoot.playSound("pacman_chomp.wav");
               ballTimerStarted=true;
            }
           gameWinCount++;
            getWorld().removeObject((Ball)(catcher.returnIntersectingBalls()));
            ballCount++;
            setScore(ballCount);
       }
       if(ballTimerStarted)
       {
           ballSoundTimer.startTimer();
        }
        if(ballSoundTimer.getTime()==60)
        {
            ballSoundTimer.stopTimer();
            ballTimerStarted=false;
        }
       if(catcher.returnIntersectingFruit()!=null&&!gameOver)
       {
           Greenfoot.playSound("pacman_eatfruit.wav");
            getWorld().removeObject((Fruit)(catcher.returnIntersectingFruit()));
            ballCount+=10;
            setScore(ballCount);
       }
       if(catcher.returnIntersectingRedGhost()!=null&&!powerUp&&!gameOver)
       {
           Greenfoot.playSound("pacman_death.wav");
            if(livesLeft==1)
            getWorld().removeObjects(getWorld().getObjectsAt(13,104,Life.class));
            if(livesLeft==2)
            getWorld().removeObjects(getWorld().getObjectsAt(39,104,Life.class));
            if(livesLeft==3)
            getWorld().removeObjects(getWorld().getObjectsAt(66,104,Life.class));
            if(livesLeft==0)
            getWorld().removeObjects(getWorld().getObjectsAt(13,104,Life.class));
            livesLeft--;
            this.setLocation(117,199);
            catcher.setLocation(117,199);
            e.setLocation(118,186);
            f.setLocation(118,214);
            g.setLocation(132,200);
            h.setLocation(102,200);
       }  
       if(catcher.returnIntersectingPinkGhost()!=null&&!powerUp&&!gameOver)
       {
           Greenfoot.playSound("pacman_death.wav");
            if(livesLeft==1)
            getWorld().removeObjects(getWorld().getObjectsAt(13,104,Life.class));
            if(livesLeft==2)
            getWorld().removeObjects(getWorld().getObjectsAt(39,104,Life.class));
            if(livesLeft==3)
            getWorld().removeObjects(getWorld().getObjectsAt(66,104,Life.class));
            if(livesLeft==0)
            getWorld().removeObjects(getWorld().getObjectsAt(13,104,Life.class));
            livesLeft--;
            this.setLocation(117,199);
            catcher.setLocation(117,199);
            e.setLocation(118,186);
            f.setLocation(118,214);
            g.setLocation(132,200);
            h.setLocation(102,200);
       }  
        if(catcher.returnIntersectingBlueGhost()!=null&&!powerUp&&!gameOver)
       {
           Greenfoot.playSound("pacman_death.wav");
            if(livesLeft==1)
            getWorld().removeObjects(getWorld().getObjectsAt(13,104,Life.class));
            if(livesLeft==2)
            getWorld().removeObjects(getWorld().getObjectsAt(39,104,Life.class));
            if(livesLeft==3)
            getWorld().removeObjects(getWorld().getObjectsAt(66,104,Life.class));
            if(livesLeft==0)
            getWorld().removeObjects(getWorld().getObjectsAt(13,104,Life.class));
            livesLeft--;
            this.setLocation(117,199);
            catcher.setLocation(117,199);
            e.setLocation(118,186);
            f.setLocation(118,214);
            g.setLocation(132,200);
            h.setLocation(102,200);
       }  
        if(catcher.returnIntersectingOrangeGhost()!=null&&!powerUp&&!gameOver)
       {
           Greenfoot.playSound("pacman_death.wav");
            if(livesLeft==1)
            getWorld().removeObjects(getWorld().getObjectsAt(13,104,Life.class));
            if(livesLeft==2)
            getWorld().removeObjects(getWorld().getObjectsAt(39,104,Life.class));
            if(livesLeft==3)
            getWorld().removeObjects(getWorld().getObjectsAt(66,104,Life.class));
            if(livesLeft==0)
            getWorld().removeObjects(getWorld().getObjectsAt(13,104,Life.class));
            livesLeft--;
            this.setLocation(117,199);
            catcher.setLocation(117,199);
            e.setLocation(118,186);
            f.setLocation(118,214);
            g.setLocation(132,200);
            h.setLocation(102,200);
       }  
       if(catcher.returnIntersectingRedGhost()!=null&&powerUp&&!gameOver)
       {
           Greenfoot.playSound("pacman_eatghost.wav");
           getWorld().removeObjects(getWorld().getObjectsAt(this.getX(),this.getY(),RedGhost.class));
           redGhostRespawnTimer.startTimer();
           ballCount+=10;
           setScore(ballCount);
       }
       if(catcher.returnIntersectingPinkGhost()!=null&&powerUp&&!gameOver)
       {
           Greenfoot.playSound("pacman_eatghost.wav");
           getWorld().removeObjects(getWorld().getObjectsAt(this.getX(),this.getY(),PinkGhost.class));
           pinkGhostRespawnTimer.startTimer();
           ballCount+=10;
           setScore(ballCount);
        }
       if(catcher.returnIntersectingBlueGhost()!=null&&powerUp&&!gameOver)
       {
           Greenfoot.playSound("pacman_eatghost.wav");
           getWorld().removeObjects(getWorld().getObjectsAt(this.getX(),this.getY(),BlueGhost.class));
           blueGhostRespawnTimer.startTimer();
           ballCount+=10;
           setScore(ballCount);
       }
       if(catcher.returnIntersectingOrangeGhost()!=null&&powerUp&&!gameOver)
       {
           Greenfoot.playSound("pacman_eatghost.wav");
           getWorld().removeObjects(getWorld().getObjectsAt(this.getX(),this.getY(),OrangeGhost.class));
           orangeGhostRespawnTimer.startTimer();
           ballCount+=10;
           setScore(ballCount);
       }
       if(catcher.returnIntersectingBigBall()!=null&&!gameOver)
       {
           ghostTimer.stopTimer();
            getWorld().removeObjects(getWorld().getObjectsAt(this.getX(),this.getY(),BigBall.class));
            powerUp=true;
            this.getRedGhost().setImage("deadghost.jpg");
            this.getPinkGhost().setImage("deadghost.jpg");
            this.getBlueGhost().setImage("deadghost.jpg");
            this.getOrangeGhost().setImage("deadghost.jpg");
       }
       if(powerUp)
       {
            ghostTimer.startTimer();
            if(ghostTimer.getTime()>=525)
            {
             setGhostImage();
            }
            if(ghostTimer.getTime()>526)
            {
              ghostTimer.stopTimer();
              powerUp=false;
            }
       }
       if(redGhostRespawnTimer.getTime()>0)
       {
            redGhostRespawnTimer.startTimer();
            if(redGhostRespawnTimer.getTime()==300)
            {
               red=new RedGhost();
               getWorld().addObject(red,267,200); 
               redGhostRespawnTimer.stopTimer();
            }
       }
       if(pinkGhostRespawnTimer.getTime()>0)
       {
            pinkGhostRespawnTimer.startTimer();
            if(pinkGhostRespawnTimer.getTime()==300)
            {
               pink=new PinkGhost();
               getWorld().addObject(pink,290,200);
               pinkGhostRespawnTimer.stopTimer();
            }
       }
       if(blueGhostRespawnTimer.getTime()>0)
       {
            blueGhostRespawnTimer.startTimer();
            if(blueGhostRespawnTimer.getTime()==300)
            {
               blue=new BlueGhost();
               getWorld().addObject(blue,313,200);  
               blueGhostRespawnTimer.stopTimer();
            }
       }
       if(orangeGhostRespawnTimer.getTime()>0)
       {
            orangeGhostRespawnTimer.startTimer();
            if(orangeGhostRespawnTimer.getTime()==300)
            {
               orange=new OrangeGhost();
               getWorld().addObject(orange,336,200);   
               orangeGhostRespawnTimer.stopTimer();
            }
       }*/ 
    }
    //methods
    /*public void setScore(int count)
    {
        if(count<10)
        {
            this.getScore10().setImage(count+".JPG");
        }
        if(count>10&&count<100)
        {
            this.getScore10().setImage(count%10+".JPG");
            this.getScore100().setImage(count/10+".JPG");
        }
        if(count>100&&count<1000)
        {
            this.getScore10().setImage(count%10+".JPG");
            this.getScore100().setImage((count%100)/10+".JPG");
            this.getScore1000().setImage(count/100+".JPG");
        }
    }
     public void setHighScore(int count)
    {
        if(count<10)
        {
            this.getHighScore10().setImage(count+".JPG");
        }
        if(count>10&&count<100)
        {
            this.getHighScore10().setImage(count%10+".JPG");
            this.getHighScore100().setImage(count/10+".JPG");
        }
        if(count>100&&count<1000)
        {
            this.getHighScore10().setImage(count%10+".JPG");
            this.getHighScore100().setImage((count%100)/10+".JPG");
            this.getHighScore1000().setImage(count/100+".JPG");
        }
    }
    public void setGhostImage()
    {
         this.getRedGhost().setImage("redghost.jpg");
         this.getPinkGhost().setImage("pinkghost.jpg");
         this.getBlueGhost().setImage("blueghost.jpg");
         this.getOrangeGhost().setImage("orangeghost.jpg");
    }
     //accessors
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
    public Score1 getScore1()
    {
        return score1;
    }
    public Score10 getScore10()
    {
        return score10;
    }
    public Score100 getScore100()
    {
        return score100;
    }
    public Score1000 getScore1000()
    {
        return score1000;
    }
     public Score1 getHighScore1()
    {
        return highScore1;
    }
    public Score10 getHighScore10()
    {
        return highScore10;
    }
    public Score100 getHighScore100()
    {
        return highScore100;
    }
    public Score1000 getHighScore1000()
    {
        return highScore1000;
    }
    public Life getLife1()
    {
        return life1;
    }
    public Life getLife2()
    {
        return life2;
    }
    public Life getLife3()
    {
        return life3;
    }
    public Fruit getFruit1()
    {
        return fruit1;
    }
    public Fruit getFruit2()
    {
        return fruit2;
    }
    public BigBall getBigBall1()
    {
        return bigBall1;
    }
    public BigBall getBigBall2()
    {
        return bigBall2;
    }
    public BigBall getBigBall3()
    {
        return bigBall3;
    }
    public BigBall getBigBall4()
    {
        return bigBall4;
    }
    public RedGhost getRedGhost()
    {
        return red;
    }
    public PinkGhost getPinkGhost()
    {
        return pink;
    }
    public BlueGhost getBlueGhost()
    {
        return blue;
    }
    public OrangeGhost getOrangeGhost()
    {
        return orange;
    }
    public PacManCatcher getPacManCatcher()
    {
      return catcher;        
    }
    public int getHighScore()
    {
        return highScore;
    }
    */
}
