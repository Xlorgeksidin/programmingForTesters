import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPointMethod {
    @Test
    public void testDistanceMethod(){
        Assert.assertEquals(8.0,Point.distance(new Point(4.0, 4.0), new Point(4.0, -4.0)));
    }
}
