public class MonadDemo {

    public static void demo() {

        addTen(1).ifPresent(x -> System.out.println(x.equals(11)));
        addTen(null).ifPresent(x -> System.out.println("You can not find me!"));

        divide(10,0).ifPresent(x ->System.out.println("Can not see me!"));
        divide(10, 2).ifPresent( x -> System.out.println(x.equals(5)));

        addTenAndDivide(10,0).ifPresent(System.out::println);
        addTenAndDivide(10, -10).ifPresent(System.out::println); //print nothing
        addTenAndDivide(10, null).ifPresent(System.out::println);
    }

    static Optional<Integer> addTen(Integer a){
        return Optional.ofNullable(a).map(x -> x + 10);
    }

    static Optional<Integer> divide(Integer a, Integer b){
        return (a != null && b != null && !b.equals(0)) ? Optional.of(a / b) : Optional.empty();
    }

    static Optional<Integer> addTenAndDivide(Integer a, Integer b){
        return addTen(b).flatMap( x -> x.equals(0) ? Optional.empty() : addTen(a).map(y -> y / x));
    }
}
