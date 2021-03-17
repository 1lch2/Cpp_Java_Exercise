package others;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {
    Person someone = new Person();

    @Before
    public void setUp () {
        //* @Before 注解会在每个测试前都运行，@After 同理
        // JUnit 5 引入了 @BeforeAll，可以只运行一次
        this.someone.setName("name");
        this.someone.setAge(49);
    }

    @Test
    public void testGetBirthYear() {
        // 使用 assertEquals 来测试方法
        assertEquals(20, this.someone.getBirthYear(2001));
        assertEquals("name", this.someone.getName());
    }

    @Test
    public void testGetObjectBirthYear() {
        assertEquals(1972, this.someone.getBirthYear());
    }

    @After
    public void printLine() {
        System.out.println("Test completed.");
    }

}