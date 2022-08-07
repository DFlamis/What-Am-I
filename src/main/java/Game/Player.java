package Game;

public class Player
{
    private int rounds;
    private int hits;

    public Player()
    {
        this.rounds = 0;
        this.hits = 0;
    }

    //Something----------------------------------------------------------------------
    public int getRounds()
    {
        return this.rounds;
    }

    public double guessPorcetage()
    {
        return ((hits - rounds) / rounds) * 100;
    }


}
