package material;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import material.solid.Phone;

import org.junit.Test;

public class MaterialQuantityTest {

    // Create an empty list of materials.
    List<MaterialQuantity> materials = new ArrayList<MaterialQuantity>();


	@Test
	public void testGetMat() {
	    materials.add(new MaterialQuantity(new Phone("HTC One",
	            "Description of the HTC One", TypeOS.ANDROID), 5));
	    System.out.println(materials.get(0).getMat().getObjectValue());
	}

}
