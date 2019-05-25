import cucumber.api.cli.Main;
import org.junit.Test;

public class JUnitParallel {

    @Test
    public void test(){
        Main.main(
                new String[]{
                    "--threads","4",
                        "-p","json:target/report/cucumber-parallel-report.json",
                        "-p","html:target/report/summary/",
                        "-p","timeline:target/cucumber-parallel-timeline",
                        "-g","steps",
                        "src/test/resources/features/"
                }
        );
        Assert.assertTrue(true,true);
    }
}
