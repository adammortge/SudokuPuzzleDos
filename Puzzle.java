public interface Puzzle
{
    public int [][] getOriginal ();
    public int [][] getSolved ();
    public int getPuzzleSize ();
    public boolean [][] checkGuess (int [][] guesses);
}
