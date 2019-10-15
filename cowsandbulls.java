import java.util.Random;
import java.util.Scanner;

public class klkl
{
    public static void main(String[] args)
    {

        Random num= new Random();
        int random= 0;
        while(checkDuplicate(random=(num.nextInt(9000) + 1000)));


        String randomNum = Integer.toString(random);
        Scanner console = new Scanner(System.in);

        boolean isGuessed=false;

        int guesses=0;

        while(!isGuessed)
        {
            System.out.print("Enter a number: ");
            int cows=0;
            int bulls=0;

            String input = console.nextLine();

            if(hasSymbols(input))
            {
                System.out.println("Enter number with no symbols.");
                continue;
            }
            int guessedNum=Integer.parseInt(input);
            if(checkDuplicate(guessedNum))
            {
                System.out.println("Enter number with no duplicate digits.");
                continue;
            }

            if(guessedNum<1000 || guessedNum>9999)
            {
                System.out.println("Enter number with 4 digits.");
                continue;
            }


            for(int i= 0;i < 4;i++)
            {
                if(randomNum.charAt(i) == input.charAt(i))
                {
                    bulls++;
                }
                else if(randomNum.contains(input.charAt(i)+""))
                {
                    cows++;
                }

            }
            if(bulls==4)
            {
                isGuessed=true;
                System.out.println("You won after "+guesses+" guesses.");
            }

            else
            {
                guesses++;
                System.out.println(cows+" Cows and "+bulls+" Bulls.");
            }

        }

    }

    public static boolean hasSymbols(String str)
    {
        for (int i = 0; i <str.length() ; i++)
        {
            if(str.charAt(i)>'9' || str.charAt(i)<'0')
                return true;
        }
        return false;
    }

    public static boolean ifContains(String str, String str2)
    {
        for (int i = 0; i <str.length() ; i++)
        {
            for (int j = 0; j <str2.length() ; j++)
            {
                if(str.charAt(i)==str2.charAt(j))
                    return true;
            }
        }
        return false;
    }

    public static boolean checkDuplicate(int num)
    {
        boolean[] flagArr = new boolean[10];
        while(num > 0)
        {
            int r = num%10;
            if(flagArr[r])
                return true;
            else flagArr[r] = true;
            num = num/10;
        }
        return false;
    }
}
