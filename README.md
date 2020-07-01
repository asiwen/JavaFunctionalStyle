## Anonymous method
Before Java8
```java
@Test
public void demoAnonymousMethod(){

    Runnable r = new Runnable() {
        @Override
        public void run() {
            System.out.println("This is in a anonymous method!");
        }
    };

    r.run();
}

@Test
public void demoAnonymousMethodAsParam(){
    Arrays.asList(1,2,3).forEach(new Consumer<Integer>() {
        @Override
        public void accept(Integer integer) {
            System.out.print(integer);
        }
    });
}
```

## Lambda
Beyond Java8(included), we can recode the above demos in Lambda expression:
```java
@Test
public void demoLambda(){
    Runnable r = () -> System.out.println("This is in a lambda!");
    r.run();
}

@Test
public void demoLambdaAsParam(){
    Arrays.asList(1,2,3).forEach((x) -> System.out.print(x));
}
```
## Function Interface
A Functional interface is also known as Single Abstract Method Interfaces or SAM Interfaces, 
which has following KEY points:
* An Interface that contains exactly one abstract method.
* It can have any number of default, static methods but can contain only one abstract method. 
  It can also declare methods of the object class.

```java
// It`s a functional interface
interface MyFunction{
    void coding();
}

// It is not a function interfac.
interface MyFunction1{
    void coding();
    void happy();
}

// It is a function interface
interface MyFunction2{
    void coding();
    default void happy(){System.out.print("happly");}
}
```

Practical tips:
* Function interface usually annotated with __@FunctionalInterface__, but is not necessary.
* A function interface can be instantiated by using __Lambda__ and __Method Reference__ concisely.(Of course, )

JDK built-in function interfaces:
* Runnable, Callable, Comparator, ActionListener etc.
* Interfaces in package of java.util.function, such as Function<T, R>, Consumer<T>, Predicate<T>.

### Method Reference
Method references are a special type of lambda expressions. 
They're often used to create simple lambda expressions by referencing existing methods.
There are 4 kinds of method references:

Kind                            |                         Example
--------------------------------|---------------------------
Reference to a static method	| ContainingClass::staticMethodName
Reference to an instance method of a particular object	| containingObject::instanceMethodName
Reference to an instance method of an arbitrary object of a particular type	| ContainingType::methodName
Reference to a constructor |	ClassName::new

```java
/**
 * Created by Asiwen on 2018/11/19.
 */
public class Person {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
@FunctionalInterface
interface Setter<T>
{
    void apply(Person p, T a);
}

class POA<T, U, R>{
    public BiConsumer<T, R> setter = null;
    public Function<U, R> parse = null;

    public POA(BiConsumer<T, R> setter, Function<U, R> parse){
        this.setter = setter;
        this.parse  = parse;
    }
}

public static void testmethodreference(){
    Person person = new Person();
    Setter<String> setter = Person::setName;
    setter.apply(person, "Setter Function");
    System.out.println(person.getName());
    
    POA<Person, String, Integer> poa = new POA<>(Person::setAge, Integer::parseInt);
    poa.setter.accept(person, poa.parse.apply("100"));
    System.out.println(person.getAge());
}
```

## Stream


## Reference
* https://www.cnblogs.com/chenpi/p/5890144.html
* https://www.geeksforgeeks.org/functional-interfaces-java/
* https://www.javaguides.net/2018/07/java-8-functional-interfaces.html
* [Method references](https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html)
* [Using Method references](http://note.youdao.com/noteshare?id=2901c9b7e3311b4d669990eee47c3dbf&sub=FBAACF8118CB48A28A8D79BED66E97F4)


