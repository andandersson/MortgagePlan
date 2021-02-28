import application.PropertyValues;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

public class PropertyValuesTest {
    PropertyValues prop;

   @Test
    public void testGetPropValues() throws IOException {
       prop = new PropertyValues();
       assertNotNull(prop.getPropValues());

   }
}
