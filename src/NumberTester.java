import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NumberTester implements NumberTesters {

    private final String fileName;
    private NumberTesters primeTester;
    private NumberTesters oddTester;
    private NumberTesters palindromeTester;

    public NumberTester(String fileName){
        this.fileName = fileName;
    }

    public void setOddEvenTester(NumberTesters oddTester){
        this.oddTester = oddTester;
    }

    public void setPrimeTester(NumberTesters primeTester){
        this.primeTester = primeTester;
    }

    public void setPalindromeTester(NumberTesters palindromeTester){
        this.palindromeTester = palindromeTester;
    }

    public void testFile(){
        String line;
        try (BufferedReader bfr = new BufferedReader(new FileReader(fileName))){
            line = bfr.readLine();
            while(line != null) {
                line = bfr.readLine();
                if (line != null) {
                    String[] array = line.split(";");
                    int numberCheck = Integer.parseInt(array[1]);
                    switch (array[0]) {
                        case "1":
                            NumberTesters isEven = (n) -> (n%2) == 0;
                            setOddEvenTester(isEven);
                            if (oddTester.testNumber(numberCheck)){
                                System.out.println("EVEN");
                            }else{
                                System.out.println("ODD");
                            }
                            break;
                        case "2":
                            NumberTesters isPrimeNumber = (n) -> {
                                if (n < 2)
                                    return false;
                                for (int i = 2; i * i <= n; i++) {
                                    if (n % i == 0)
                                        return false;
                                }
                                return true;
                            };
                            setPrimeTester(isPrimeNumber);
                            if (primeTester.testNumber(numberCheck)){
                                System.out.println("PRIME");
                            }else{
                                System.out.println("NO PRIME");
                            }
                            break;
                        case "3":
                           NumberTesters isPalindrome = (n) -> {
                               String str = String.valueOf(n);
                               char[] chars = str.toCharArray();
                               for (int i = 0; i < chars.length/2; i++){
                                   if(chars[i] != chars[chars.length-1-i])
                                       return false;
                               }
                               return true;
                            };
                            setPalindromeTester(isPalindrome);
                            if (palindromeTester.testNumber(numberCheck)){
                                System.out.println("PALINDROME");
                            }else{
                                System.out.println("NO PALINDROME");
                            }
                           break;
                        }
                    }
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean testNumber(int number) {
        return false;
    }
}
