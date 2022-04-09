/** 
 * File name: Proasg3
 * David Perez
 * I.D. 6116495
 * Section U04
 * I affirm that this program is entirely my own work and none of it is the work
 * of any other person.
 * David Perez
 */
package proasg3 ;

/**
 * A magic square that can be filled, printed, and checked to be truly magic
 */
public class MagicSquare {
    // initializes pointer to the 2d array
    private int [][] magicsq ;
    private static int finalVal ; //holds value of final number in magic square
   
    /**
     * Creates an empty Magic Square
     * @param n The amount of rows and columns. Can only be an odd number
     */
    public MagicSquare(int n)
    {
        //creates the 2d array with user input size
        magicsq = new int [n][n] ;
        MagicSquare.fill(magicsq, n) ;
    }
    
    /**
     * Fills a magic square of any size
     * @param magicsq1 the magic square to be filled 
     * @param z the user's desired size of the square
     */
    private static void fill(int [][] magicsq1, int z)
    {
        int currRow = z - 1 ; //contains int for row to place next i
        int currColumn = (z/2) ; //contains int for column to place next i
        int x ; //used to hold value for row of previous i
        int y ; //used to hold value for column of previous i
        
       //assigns the middle column of last row with 1 and updates 'current' vars
        magicsq1[currRow][currColumn] = 1 ;
        currRow++ ;
        currColumn++;
        finalVal = z * z ;
        
        //cycles through all integers to be placed in magic square
        for(int i = 2; i <= finalVal; i++)
        {        
            if(currRow >= z && currColumn >= z)
            {
                x = currRow - 2 ;
                y = currColumn - 1 ;
                magicsq1[x][y] = i ;

                currRow-- ; 
            }

            else if(currRow > (z - 1)) 
            {
                magicsq1[0][currColumn] = i ;
                
                currRow = 1 ;
                currColumn++ ;
            }

            else if(currColumn > (z - 1))
            {
                magicsq1[currRow][0] = i ;
                
                currColumn = 1 ;
                currRow++ ;
            }
            
            else if(magicsq1[currRow][currColumn] != 0)
            {
                x = currRow - 2 ;
                y = currColumn - 1 ;
                magicsq1[x][y] = i ;
                
                currRow-- ;
            }
           
            else
            {
               magicsq1[currRow][currColumn] = i ;
               
               currRow++ ;
               currColumn++ ;
            }
        }
    }
    
    /**
     * Prints out the Magic Square 
     */
    public void sqrToString()
    {
        //cycles through all values and prints them followed by 2 spaces and 
        //new line after each row
        for(int g = 0; g < Math.sqrt(finalVal); g++ )
        {
            for(int t = 0; t < Math.sqrt(finalVal); t++)
            {
                System.out.print(magicsq[g][t] + "  ") ;                     
            }
        
            System.out.println() ; 
        } 
    }
    
    /**
     * Checks if the square adds up to the same number in every row/column/
     * diagonal
     * @param checker the current magic square
     * @param n the size of the current magic square
     * @return True if it is magic(all sums are equal), false if it is not magic
     * (all sums do not equal each other)
     */
    public boolean magicCheck(MagicSquare checker, int n)
    {
        int magicSum = 0 ;//assigned with target sum
        int magicChecker = 0 ;//assigned with value to be compared with magicSum
        int h = 0 ; //counter for next row when summing diagonal from right side
        
        //adds the first row to create the target value for all sums
        for(int d = 0; d < n; d ++)
        {
            magicSum+= magicsq[0][d] ;
        }
        
        //checks the rows
        for(int c = 1; c < n; c++)
        {
            for(int g = 0; g < n; g++)
            {
                magicChecker+= magicsq[c][g] ;
            }   
            //checks given row is same as target value
            if(magicChecker == magicSum)
            {   
                //resets value of checker to sum next row
                magicChecker = 0 ;
            }
                
            else
            {
                return false ;
            }    
        }
        
        //checks the columns
        for(int g = 0; g < n; g++)
        {
            for(int c = 0; c < n; c++)
            {
                magicChecker+= magicsq[c][g] ;
            }   
                
            //checks given column is same as target value
            if(magicChecker == magicSum)
            {
            //resets value of checker to sum next column
            magicChecker = 0 ;
            }
            else
            {
            return false ;
            }
        }
                
        //checks diagonal beginning from left
        for(int v = 0; v < n; v++)
        {
            magicChecker+= magicsq[v][v] ;
        }
            
        if(magicChecker == magicSum)
        {   
            magicChecker = 0 ;
        }
        else
        {
            return false ;
        }    

        //checks diagonal beginning from right
        for(int g = (n - 1); g >= 0; g--)
        {
            magicChecker+= magicsq[h++][g] ;
        }
            
        if(magicChecker == magicSum)
        {   
        }
        else
        {
            return false ;
        }

        return true ;       
    }
}
