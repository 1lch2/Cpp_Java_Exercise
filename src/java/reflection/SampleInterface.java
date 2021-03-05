package reflection;

public interface Hello {
    void sayHi(String name);
}

public class SampleInterface implements Hello{
    @Override
    public void sayHi(String name) {
        System.out.println("Hello, " + name);
    }
}