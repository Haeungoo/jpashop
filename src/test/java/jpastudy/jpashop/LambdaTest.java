package jpastudy.jpashop;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class LambdaTest {
    @Test
    public void stream(){
        List<User> users = List.of(new User("a",10), new User("b",6), new User("c",15));
        // User의 이름 목록만 List<String> 형태로 가져오기
        List<String> userList = users.stream() // Stream<User>
            .map(User::getName) // Stream<User> -> Stream<String> -> List<String>
            .collect(Collectors.toList()); // Stream<String> -> List<String>
        userList.forEach(name -> System.out.println(name));

        // age가 10보다 큰 user 이름만 List<String> 형태로 가져오기
        users.stream()
                .filter(user -> user.getAge() >= 10)
                .map(user-> user.getName())
                .forEach(System.out::println);

    }
    @Test
    public void iterable(){
        List<User> users = List.of(new User("스프링"), new User("테스트"));
        // Consumer의 void accept(T t) 메서드 재정의 - 람다식
        users.forEach(user->System.out.println(user));
        // Method Reference
        users.forEach(System.out::println);

    }

    @Test
    public void lambda(){
        // Anonymous Inner class
        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("익명 내부클래스로 구현");
            }
        });
        t1.start();

        // Lambda Expression
        Thread t2 = new Thread(() -> System.out.println("람다식"));
        t2.start();
    }

}
