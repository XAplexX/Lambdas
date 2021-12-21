import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String lines;
        Number results = null;
        double[] person = null;

        //Lambdas belegen
        CalculationOperation add = (x,y) -> new Number(x.getA() + y.getA(), x.getB() + y.getB());
        CalculationOperation sub = (x,y) -> new Number(x.getA() - y.getA(), x.getB() - y.getB());
        //Multiplikation Kreuzweise = Kreuzprodukt
        CalculationOperation mul = (x,y) -> new Number(x.getA() * y.getA(), x.getB() * y.getB());
        //Division rationale Zahl - Skalarprodukt bilden
        CalculationOperation div = (x,y) -> new Number(x.getA() / y.getA(), x.getB() / y.getB());

        //Objekte RC, VC, CC
        RationalCalculator rationals = new RationalCalculator(add, sub, mul, div);
        VectorCalculator vectors = new VectorCalculator(add, sub, mul, div);
        ComplexCalculator complexes = new ComplexCalculator(add, sub, mul, div);

        boolean booleans = true;
        boolean running;
        while(booleans){
            chooseCalc();
            lines = sc.nextLine();
            switch (lines){
                case "1":
                    running = false;
                    do {
                        person = numberSelection();
                        chooseOperational();
                        lines = sc.nextLine();
                        if (lines.equals("1")) {
                            results = rationals.add(new Number(person[0], person[1]), new Number(person[2], person[3]));
                            System.out.println("Solution: " + results.getA());
                            System.out.println("Solution: " + results.getB());
                            running = false;
                        } else if (lines.equals("2")) {
                            results = rationals.subtract(new Number(person[0], person[1]), new Number(person[2], person[3]));
                            System.out.println("Solution: " + results.getA());
                            System.out.println("Solution: " + results.getB());
                            running = false;
                        } else if (lines.equals("3")) {
                            results = rationals.multiply(new Number(person[0], person[1]), new Number(person[2], person[3]));
                            System.out.println("Solution: " + results.getA());
                            System.out.println("Solution: " + results.getB());
                            running = false;
                        } else if (lines.equals("4")) {
                            results = rationals.divide(new Number(person[0], person[1]), new Number(person[2], person[3]));
                            System.out.println("Solution: " + results.getA());
                            System.out.println("Solution: " + results.getB());
                            booleans = false;
                        } else if (lines.equals("5")) {
                            running = true;
                        }
                    }while (running);
                    break;

                case "2":
                    running = false;
                    do {
                        person = numberSelection();
                        chooseOperational();
                        lines = sc.nextLine();
                        if (lines.equals("1")) {
                            results = vectors.add(new Number(person[0], person[1]), new Number(person[2], person[3]));
                            System.out.println("Solution: " + results.getA());
                            System.out.println("Solution: " + results.getB());
                            running = false;
                        } else if (lines.equals("2")) {
                            results = vectors.subtract(new Number(person[0], person[1]), new Number(person[2], person[3]));
                            System.out.println("Solution: " + results.getA());
                            System.out.println("Solution: " + results.getB());
                            running = false;
                        } else if (lines.equals("3")) {
                            results = vectors.multiply(new Number(person[0], person[1]), new Number(person[2], person[3]));
                            System.out.println("Solution: " + results.getA());
                            System.out.println("Solution: " + results.getB());
                            running = false;
                        } else if (lines.equals("4")) {
                            results = vectors.divide(new Number(person[0], person[1]), new Number(person[2], person[3]));
                            System.out.println("Solution: " + results.getA());
                            System.out.println("Solution: " + results.getB());
                            running = false;
                        } else if (lines.equals("5")) {
                            running = true;
                        }
                    }while (running);
                    break;

                case "3":
                    running = false;
                    do {
                        person = numberSelection();
                        chooseOperational();
                        lines = sc.nextLine();
                        if (lines.equals("1")) {
                            results = complexes.add(new Number(person[0], person[1]), new Number(person[2], person[3]));
                            System.out.println("Solution: " + results.getA());
                            System.out.println("Solution: " + results.getB());
                            running = false;
                        } else if (lines.equals("2")) {
                            results = complexes.add(new Number(person[0], person[1]), new Number(person[2], person[3]));
                            System.out.println("Solution: " + results.getA());
                            System.out.println("Solution: " + results.getB());
                            running = false;
                        } else if (lines.equals("3")) {
                            results = complexes.add(new Number(person[0], person[1]), new Number(person[2], person[3]));
                            System.out.println("Solution: " + results.getA());
                            System.out.println("Solution: " + results.getB());
                            running = false;
                        } else if (lines.equals("4")) {
                            results = complexes.add(new Number(person[0], person[1]), new Number(person[2], person[3]));
                            System.out.println("Solution: " + results.getA());
                            System.out.println("Solution: " + results.getB());
                            running = false;
                        } else if (lines.equals("5")) {
                            running = true;
                        }
                    }while (running);
                    break;

                case "4":
                    System.out.println("Bye!");
                    booleans = false;
                    break;

                default:
                    System.out.println("Try again!");
            }
        }
    }

    private static void chooseCalc(){
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
