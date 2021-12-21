import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String line;
        Number result = null;
        double[] users = null;

        //Lambdas belegen
        //Multiplikation Kreuzweise = Kreuzprodukt
        CalculationOperation add = (x,y) -> new Number(x.getA() + y.getA(), x.getB() + y.getB());
        CalculationOperation sub = (x,y) -> new Number(x.getA() - y.getA(), x.getB() - y.getB());
        //Multiplikation Kreuzweise = Kreuzprodukt
        CalculationOperation mul = (x,y) -> new Number(x.getA() * y.getA(), x.getB() * y.getB());
        //Division rationale Zahl - Skalarprodukt bilden
        CalculationOperation div = (x,y) -> new Number(x.getA() / y.getA(), x.getB() / y.getB());

        //Objekte RC, VC, CC
        RationalCalculator rational = new RationalCalculator(add, sub, mul, div);
        VectorCalculator vector = new VectorCalculator(add, sub, mul, div);
        ComplexCalculator complex = new ComplexCalculator(add, sub, mul, div);

        boolean bool = true;
        boolean running2;
        while(bool){
            chooseCalculator();
            line = scanner.nextLine();
            switch (line){
                case "1":
                    running2 = false;
                    do {
                        users = numberSelection();
                        chooseOperational();
                        line = scanner.nextLine();
                        if (line.equals("1")) {
                            result = rational.add(new Number(users[0], users[1]), new Number(users[2], users[3]));
                            System.out.println("Solution: " + result.getA());
                            System.out.println("Solution: " + result.getB());
                            running2 = false;
                        } else if (line.equals("2")) {
                            result = rational.subtract(new Number(users[0], users[1]), new Number(users[2], users[3]));
                            System.out.println("Solution: " + result.getA());
                            System.out.println("Solution: " + result.getB());
                            running2 = false;
                        } else if (line.equals("3")) {
                            result = rational.multiply(new Number(users[0], users[1]), new Number(users[2], users[3]));
                            System.out.println("Solution: " + result.getA());
                            System.out.println("Solution: " + result.getB());
                            running2 = false;
                        } else if (line.equals("4")) {
                            result = rational.divide(new Number(users[0], users[1]), new Number(users[2], users[3]));
                            System.out.println("Solution: " + result.getA());
                            System.out.println("Solution: " + result.getB());
                            bool = false;
                        } else if (line.equals("5")) {
                            running2 = true;
                        }
                    }while (running2);
                    break;

                case "2":
                    running2 = false;
                    do {
                        users = numberSelection();
                        chooseOperational();
                        line = scanner.nextLine();
                        if (line.equals("1")) {
                            result = vector.add(new Number(users[0], users[1]), new Number(users[2], users[3]));
                            System.out.println("Solution: " + result.getA());
                            System.out.println("Solution: " + result.getB());
                            running2 = false;
                        } else if (line.equals("2")) {
                            result = vector.subtract(new Number(users[0], users[1]), new Number(users[2], users[3]));
                            System.out.println("Solution: " + result.getA());
                            System.out.println("Solution: " + result.getB());
                            running2 = false;
                        } else if (line.equals("3")) {
                            result = vector.multiply(new Number(users[0], users[1]), new Number(users[2], users[3]));
                            System.out.println("Solution: " + result.getA());
                            System.out.println("Solution: " + result.getB());
                            running2 = false;
                        } else if (line.equals("4")) {
                            result = vector.divide(new Number(users[0], users[1]), new Number(users[2], users[3]));
                            System.out.println("Solution: " + result.getA());
                            System.out.println("Solution: " + result.getB());
                            running2 = false;
                        } else if (line.equals("5")) {
                            running2 = true;
                        }
                    }while (running2);
                    break;

                case "3":
                    running2 = false;
                    do {
                        users = numberSelection();
                        chooseOperational();
                        line = scanner.nextLine();
                        if (line.equals("1")) {
                            result = complex.add(new Number(users[0], users[1]), new Number(users[2], users[3]));
                            System.out.println("Solution: " + result.getA());
                            System.out.println("Solution: " + result.getB());
                            running2 = false;
                        } else if (line.equals("2")) {
                            result = complex.add(new Number(users[0], users[1]), new Number(users[2], users[3]));
                            System.out.println("Solution: " + result.getA());
                            System.out.println("Solution: " + result.getB());
                            running2 = false;
                        } else if (line.equals("3")) {
                            result = complex.add(new Number(users[0], users[1]), new Number(users[2], users[3]));
                            System.out.println("Solution: " + result.getA());
                            System.out.println("Solution: " + result.getB());
                            running2 = false;
                        } else if (line.equals("4")) {
                            result = complex.add(new Number(users[0], users[1]), new Number(users[2], users[3]));
                            System.out.println("Solution: " + result.getA());
                            System.out.println("Solution: " + result.getB());
                            running2 = false;
                        } else if (line.equals("5")) {
                            running2 = true;
                        }
                    }while (running2);
                    break;

                case "4":
                    System.out.println("Bye!");
                    bool = false;
                    break;

                default:
                    System.out.println("Try again!");
            }
        }
    }

    private static void chooseCalculator(){
        System.out.println("Choose calculator:");
        System.out.println("1 - Relational calculator");
        System.out.println("2 - Vector calculator");
        System.out.println("3 - Complex calculator");
        System.out.println("4 - Exit programm");
    }

    private static void chooseOperational(){
        System.out.println("Choose operation:");
        System.out.println("1 - add");
        System.out.println("2 - subtract");
        System.out.println("3 - multiply");
        System.out.println("4 - divide");
        System.out.println("5 - enter numbers again");
    }

    private static double[] numberSelection(){
        Scanner scanner = new Scanner(System.in);
        double [] numberSelection = new double[4];
        String[] numbers = new String[4];
        numbers[0] = "x a> "; numbers[1] = "x b> "; numbers[2] = "y a> "; numbers[3] = "y b> ";
        for (int i = 0; i < numbers.length; i++){
            System.out.print("Enter number " + numbers[i]);
            String line = scanner.nextLine();
            numberSelection[i] = text(line);
        }
        return numberSelection;
    }

    private static double text(String line) {
        double user = 0;
        try {
            user = Double.parseDouble(line);
        }catch (NumberFormatException exception){
            System.out.println("Error");
        }
        return user;
    }
}
