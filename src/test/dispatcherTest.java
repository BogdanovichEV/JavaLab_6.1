package test;
import org.testng.annotations.*;
import авиакомпания.airlineBel;
import диспетчер.dispatcher;
import org.testng.Assert;

public class dispatcherTest {

    dispatcher disp=dispatcher.get_instanse();
    airlineBel x=new airlineBel();
    @BeforeSuite
    public void startSuit()
    {
        System.out.println("Начала тестов");
    }
    @AfterSuite
    public void endSuit()
    {
        System.out.println("Конец тестов");
    }
    @BeforeTest
    public void  BeforeTest()
    {
        System.out.println("После BeforeSuite");
    }
    @AfterTest
    public void  afterTest()
    {
        System.out.println("Перед AfterSuite");
    }
    @BeforeClass
    public void  BeforeClass()
    {
        System.out.println("После BeforeTest");
    }
    @AfterClass
    public void  AfterClass()
    {
        System.out.println("Перед AfterTest");
    }
    @BeforeMethod
    public void BeforeMethod()
    {
        System.out.println("Перед каждым тестом");
    }
    @AfterMethod
    public void AfterMethod()
    {
        System.out.println("После каждым тестом");
    }
    @Test(timeOut = 6000)
    public void countPlane()throws Exception
    {
        System.out.println("тест_1");
        disp.addPlane(x.plane1);
        disp.addPlane(x.plane4);
        //Assert.assertEquals(5,disp.getObj().size());
        Assert.assertEquals(2,disp.getObj().size());
        Thread.sleep(4000);
    }
    @Test (enabled = false)
    public void countPlane1()throws Exception
    {
        System.out.println("тест_2");
        disp.addPlane(x.plane1);
        Assert.assertEquals(3,disp.getObj().size());
    }
}
