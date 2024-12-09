import greenfoot.*;
public class Timer extends Actor
{
    int count=0;
    public void startTimer()
    {
        count++;
    }
    public void stopTimer()
    {
        count=0;
    }
    public int getTime()
    {
        return count;
    }
}
