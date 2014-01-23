package material;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaterialTest {

	private Material material = new Material("Camera","OS");
	@Test
	public void testMaterial() {
		assertNotNull(material);
	}

	@Test
	public void testGetObjectValue() {
		assertEquals(material.getObjectValue(),2);
	}

}
