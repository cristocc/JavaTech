package study.spring.a20;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.Yaml;

@Controller
//@RestController
public class Controller1 {

    @GetMapping("/test1")
    public void test1(){
        System.out.println("test1");
    }

    @PostMapping("/test2")
    public void test2(@RequestParam("name")String name){
        System.out.println("test2");
    }

    @PutMapping("/test3")
    public void test3(@Token String token){
        System.out.println("test3 ,token:"+token);
    }

    @GetMapping("/test4")
    //@ResponseBody
    @Yml
    public User test4(){
        return new User("cc",18);
    }

    public static class User{
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    public static void main(String[] args) {

    }
}
