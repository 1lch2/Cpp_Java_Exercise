package junit;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class) //* 为测试类使用 @RunWith 注解来启用参数测试
public class PersonTest {
    private static Person someone; // 使用 static 修饰成员变量，将变量绑定到类而不是对象

    @BeforeClass
    public static void setUpObject () {
        //* @BeforeClass 必须为 static void，一般用于分配创建成本较大的资源
        someone = new Person();
    }

    @Before
    public void setUp() {
        //* @Before 注解会在每个测试前都运行，@After 同理
        someone.setName("name");
        someone.setAge(49);
    }

    @AfterClass
    public static void printLine() {
        System.out.println("Test completed.");
    }

    @Test
    public void testGetBirthYear() {
        // 使用 assertEquals 来测试方法
        assertEquals(2001, someone.getBirthYear(20));
        assertEquals("name", someone.getName());
    }

    @Test
    public void testGetObjectBirthYear() {
        assertEquals(1972, someone.getBirthYear());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testException () throws Exception{
        //* 使用JUnit注解的办法只能判断异常的类型
        someone.getBirthYear(500);
    }

    //* @Disable 系列注解只在JUnit 5才有

    //* 使用 @Parameters 注解构造测试参数
    @Parameters
    public static Collection<Object> data() {
        return Arrays.asList(new Object[][] {
                {24, 1997}, {20, 2001}, {21, 2000}
        });
    }

    @Parameter
    public int tInput;

    @Parameter(1)
    public int tOutput;

    @Test
    public void testParametersTest() {
        assertEquals(tOutput, someone.getBirthYear(tInput));
    }
}