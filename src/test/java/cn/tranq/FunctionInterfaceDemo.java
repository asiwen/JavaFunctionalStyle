package cn.tranq;

import org.junit.Assert;
import org.junit.Test;

import java.util.function.BiConsumer;
import java.util.function.Function;

class Person {
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

public class FunctionInterfaceDemo {

    @Test
    public void testmethodreference(){
        Person person = new Person();
        Setter<String> setter = Person::setName;
        setter.apply(person, "Setter Function");
        Assert.assertEquals("Setter Function", person.getName());

        POA<Person, String, Integer> poa = new POA<>(Person::setAge, Integer::parseInt);
        poa.setter.accept(person, poa.parse.apply("100"));
        Assert.assertEquals(100, person.getAge().intValue());
    }
}
