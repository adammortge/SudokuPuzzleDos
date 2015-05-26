/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author akumar5
 */

public class SudokuPuzzle 
{
    private int [][] solvedPuzzle;
    private int [][] origPuzzle;
    int puzzleSize;

    /* Precondition: input contains only ints from 0 to 9 inclusive. 0 means an empty cell.*/

    public SudokuPuzzle (int [][] input, boolean solved)
    { 
        origPuzzle = input.clone();
        solvedPuzzle = input.clone();
        puzzleSize = input.length;
        if (!solved)
        {
            try 
            {
                solve(0,0); 
            }
            catch (Exception e)
            {
            }
        }
    }

    private void solve (int row, int col) throws Exception
    {
        if (row >= puzzleSize)
        {
            throw new Exception("Solution Found");
        }

        if (solvedPuzzle[row][col] != 0)
        {
            next(row,col);
        }

        else
        {
            for (int num = 1; num <= puzzleSize; num++)
            {
                if (isValid (row,col,num))
                {
                    solvedPuzzle[row][col] = num;
                    next(row,col);
                }
            }
            solvedPuzzle[row][col] = 0;
        }
    }

    private void next(int row, int col) throws Exception
    {
        if (col < puzzleSize - 1)
        {
            solve(row,col + 1);
        }
        else
        {
            solve(row + 1, 0);
        }
    }
    
    private boolean isValid (int row, int col, int num)
    {
        return checkRow(row, num) && checkCol(col,num) && checkBox(row,col,num);
    }

    private boolean checkRow(int row, int num)
    {
        for (int col = 0; col < puzzleSize; col++)
        {
            if (solvedPuzzle[row][col] == num)
            {
                return false;
            }
        }
        return true;
    }

    private boolean checkCol(int col, int num)
    {
        for (int row = 0; row < puzzleSize; row++)
        {
            if (solvedPuzzle[row][col] == num)
            {
                return false;
            }
        }
        return true;
    }

    private boolean checkBox(int row, int col, int num)
    {
        row = (row/3)*3;
        col = (col/3)*3;
        for( int r = 0; r < 3; r++ )
        {
            for( int c = 0; c < 3; c++ )
            {
                if(solvedPuzzle[row+r][col+c] == num )
                {
                    return false;
                }
            }
        }
        return true;
    }

    public int [][] getOriginal ()
    {
        return origPuzzle;
    }

    public int [][] getSolved ()
    {
        return solvedPuzzle;
    }

    public int getPuzzleSize ()
    {
        return puzzleSize;
    }

    public boolean [][] checkGuess (int [][] guesses)
    {
        boolean [][] results = new boolean [puzzleSize][puzzleSize];
        for (int x = 0; x < solvedPuzzle.length; x++)
        {
            for (int y = 0; y < solvedPuzzle[0].length; y++)
            {
                try
                {
                    results[x][y] = (guesses[x][y] == solvedPuzzle[x][y]);
                }
                catch (ArrayIndexOutOfBoundsException e)
                {
                    results[x][y] = false;
                }
            }
        }
        return results;
    }
}
