package annotation;

public class TestAnnotation {
    public static void main(String[] args) {
        Hello h = new Hello();
        // TODO: 找不到符号
    }
}

@Resource("hello")
public class Hello{

    @PostConstruct
    public void hello() {
        System.out.println("Post construction.");
    }
}