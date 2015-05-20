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
        solvedPuzzle = input;
        origPuzzle = input;
        puzzleSize = input.length;
        if (!solved)
        {
            solve(0,0); 
        }
    }

    private void solve(int row, int col)
    {
        if (row == puzzleSize)
        {
            return;
        }
        else
        {
            if (solvedPuzzle[row][col] != 0)
            {
                next(row,col);
            }

            else
            {
                for (int x  = 0; x < puzzleSize + 1; x++)
                {
                    if (checkRow(row, x) && checkCol(col,x) && checkBox(row,col,x))
                    {
                        solvedPuzzle[row][col] = x;
                        next(row,col);
                    }
                }
                solvedPuzzle[row][col] = 0;
            }
        }
    }

    private void next(int row, int col)
    {
        if (col < puzzleSize - 1)
            solve(row,col + 1);
        else
            solve(row + 1, 0);
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
}