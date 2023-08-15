import org.testng.Assert;
import org.testng.annotations.Test;

public class TestingAssertion
{

    @Test
    public void test1() {
        try {
            int value = 5;
            Assert.fail(String.valueOf(value > 9));

        } catch (Exception e) {
            System.out.println("Am I entering catch");

        }
    }

    @Test
    public void test2() {
        String str1="Last Note";
        String str2="Last Note Updated";
        System.out.println(str1.contains(str2));
    }
}