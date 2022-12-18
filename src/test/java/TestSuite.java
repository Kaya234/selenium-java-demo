import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.AdminSearchTests;
import tests.LoginTests;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        LoginTests.class,
        AdminSearchTests.class
})

public class TestSuite {


}
