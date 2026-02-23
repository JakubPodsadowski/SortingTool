import java.util.function.BiFunction;
import java.util.function.IntBinaryOperator;

class Operator {

    public static IntBinaryOperator binaryOperator = (x, y) ->  x > y ? x : y;
    //public static Integer binaryOperator = f.apply(1, 2);
}