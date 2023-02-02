package edu.ucr.cs.cs167.mkim410;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.Function;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // check the length of command line args (should be 3)
        if (args.length != 3) {
            System.err.println("Error: At least three parameters expected, from, to, and base.");
            System.exit(-1);
        }

        // convert string args into ints
        int from = Integer.parseInt(args[0]);
        int to = Integer.parseInt(args[1]);
        // int base = Integer.parseInt(args[2]);

        // for part 6
        String bases = args[2];

        if (bases.length() == 1) {
            // single base
            int base = Integer.parseInt(bases);

            Function<Integer, Boolean> divisibleByBase = x -> x % base == 0;
            printNumbers(from, to, divisibleByBase);
            return;
        }
        /*
            call the correct functions based on `base` arg
            (old code from part 2 that doesn't use filtering function)
        */
        // if (base == 2) { printEvenNumbers(from, to); }
        // else if (base == 3) { printNumbersDivisibleByThree(from, to); }
        // else { System.err.println("Error: Invalid value for 'base'"); }

        /*
            part 3
            using printNumbers function with filter functions instead
         */
        // if (base == 2) { printNumbers(from, to, new IsEven()); }
        // else if (base == 3) { printNumbers(from, to, new IsDivisibleByThree()); }
        // else if (base == 5) { printNumbers(from, to, divisibleByFive); }
        // else if (base == 10) { printNumbers(from, to, divisibleByTen); }
        // else { System.err.println("Error: Invalid value for 'base'"); }

        // System.out.println(new IsEven().apply(5));

        // Part 5 (Creating Parametrized Functions)
        // Function<Integer, Boolean> divisibleByBase = x -> x % base == 0;

        // printNumbers(from, to, divisibleByBase);

        /* part 6 (Function Composition) */

        // split according to the delimiting char
        boolean isOr = false;
        String[] basesArr;
        if (bases.contains(",")) {
            basesArr = bases.split(",");
        } else if (bases.contains("v")) {
            basesArr = bases.split("v");
            isOr = true;
        } else {
            System.err.print("invalid delimiter for `bases`");
            return;
        }

        Function<Integer, Boolean>[] filters = new Function[basesArr.length];
        for (int i = 0; i < filters.length; i++) {
            int v = Integer.valueOf(basesArr[i]);
            filters[i] = new Function<Integer, Boolean>() {
                @Override
                public Boolean apply(Integer integer) {
                    return integer % v == 0;
                }
            };
        }

        // select combineWithAnd or combineWithOr based on the base arg
        Function<Integer, Boolean> filter;
        if (isOr) { filter = combineWithOr(filters); }
        else { filter = combineWithAnd(filters); }

        printNumbers(from, to, filter);
    }

    public static Function<Integer, Boolean> combineWithAnd(Function<Integer, Boolean> ... filters) {
        return x -> Arrays.stream(filters).allMatch(filter -> filter.apply(x));
    }
    public static Function<Integer, Boolean> combineWithOr(Function<Integer, Boolean> ... filters) {
        return x -> Arrays.stream(filters).anyMatch(filter -> filter.apply(x));
    }
    public static void printEvenNumbers(int from, int to) {
        System.out.printf("Printing numbers in the range [%d,%d]\n", from, to);
        while (from <= to) {
            if (from % 2 == 0) { System.out.println(from); }
            from++;
        }
    }
    
    // part 3
    public static void printNumbersDivisibleByThree(int from, int to) {
        while (from <= to) {
            if (from % 3 == 0) { System.out.println(from); }
            from++;
        }   
    }
    static class IsEven implements Function<Integer, Boolean> {
        @Override
        public Boolean apply(Integer x) {
            return x % 2 == 0;
        }
    }
    static class IsDivisibleByThree implements Function<Integer, Boolean> {
        @Override
        public Boolean apply(Integer x) {
            return x % 3 == 0;
        }
    }
    // print numbers with a filter function
    public static void printNumbers(int from, int to, Function<Integer, Boolean> filter) {
        System.out.printf("Printing numbers in the range [%d,%d]\n", from, to);
        while (from <= to) {
            if (filter.apply(from)) { System.out.println(from); }
            from++;
        }
    }

    // Part 4
    // Anonymous classes
    static Function<Integer, Boolean> divisibleByFive = new Function<Integer, Boolean>() {
        @Override
        public Boolean apply(Integer x) {
            return x % 5 == 0;
        }
    };
    // Lambda expressions
    static Function<Integer, Boolean> divisibleByTen = x -> x % 10 == 0;
}


