package libraries;

public class Test {
   private String testName;
    private String testFileName;

    public Test(String testName, String testFileName)
    {
        this.testName = testName;
        this.testFileName = testFileName;
    }
    public String getTestName()
    {
        return this.testName;
    }

    public String getTestFileName()
    {
        return this.testFileName;
    }

}
