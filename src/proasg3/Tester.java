package proasg3 ;
import java.util.Scanner ;

/**
 * Creates a magic square with a size given by the user, then asks the user if
 * they would like to see another magic square
 */
public class Tester {

    public static void main(String[] args) 
    {
        Scanner scnr = new Scanner(System.in) ;
        int n = scnr.nextInt() ;
        System.out.println() ;
        while( n > 1 && n % 2 != 0 )
        {
            MagicSquare squareOfMagic = new MagicSquare(n) ;
            
            if(squareOfMagic.magicCheck(squareOfMagic, n)) 
            {
                squareOfMagic.sqrToString() ;
                break ;
            }
            
            else 
            {
                System.out.println("It is not magic, woops.") ;
                break ;
            }
        }
        
        System.out.println() ;
        System.out.println("Press 1 if you would like to see another "
        + "magic square, followed by the size you would like for it to be. " 
        + "Press 0 in order to exit") ;
        
        int input = scnr.nextInt() ;
        n = scnr.nextInt() ;
        System.out.println() ;
        
        while( input == 1 && n > 1 && n % 2 != 0 )
        {
            MagicSquare squareOfMagic = new MagicSquare(n) ;
            
            if(squareOfMagic.magicCheck(squareOfMagic, n)) 
            {
                squareOfMagic.sqrToString() ;
            }
            
            else 
            {
                System.out.println("It is not magic, woops.") ;
            }
            
            System.out.println() ;
            System.out.println("Press 1 if you would like to see another "
            + "magic square, followed by the size you would like for it to be. " 
            + "Press 0 in order to exit") ;
            
            input = scnr.nextInt() ;
            n = scnr.nextInt() ;
            System.out.println() ;
        }
    }
}

