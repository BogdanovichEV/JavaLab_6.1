package test;
import авиакомпания.airlineBel;
import org.testng.Assert;
import org.testng.annotations.Test;
public class airlineBelTest {
    airlineBel.Plane plane=new airlineBel.Plane();
    @Test(groups = {"group1","group2"})
    public void setFileTest()throws Exception
    {
        plane.setDist(100);
        Assert.assertEquals(100,plane.getDist());

    }
    @Test(groups = {"group1"})
    public void setFileTest1()throws Exception
    {
        plane.setFuel(50);
        Assert.assertEquals(50,plane.getFuel());
    }
    @Test(groups = {"group2"})
    public void setFileTest2()throws Exception
    {
        plane.setDist(18);
        Assert.assertEquals(18,plane.getDist());
    }
}
