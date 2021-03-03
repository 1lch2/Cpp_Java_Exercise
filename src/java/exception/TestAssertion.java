package exception;

public class TestAssertion {
    public static void main(String[] args) {
        int x = 50 / 5;
        assert x < 4; // 必须给 JVM 传入 -ea 参数才会打印 AssertionError
    }
}