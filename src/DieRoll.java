import java.util.Random;

public class DieRoll 
{
    int rollNum;
    int sides = 6;
    
    public void roll()
    {
        Random rand = new Random();
        rollNum = rand.nextInt(sides) + 1;
    }
    
    public int getRoll()
    {
        return rollNum;
    }
}