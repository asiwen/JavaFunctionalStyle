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
## Functional Interface

## Stream



