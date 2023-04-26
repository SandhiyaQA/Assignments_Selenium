import org.testng.annotations.Test;

public class TestngPrograms {
    @Test(priority = -3)
    public void fun1()
    {

        System.out.println("function1");
    }
    @Test(priority = -2)
    public void fun2()
    {
        System.out.println("function2");

    }
    @Test(priority = -2)
    public void fun0()
    {
        System.out.println("function3");

    }

}
