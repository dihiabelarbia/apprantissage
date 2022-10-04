
package JUnit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;


import gameBuilder.Manager;


public class TestUnitaire {
	
	private Manager manager;
	
	@Test
	public void test() {
		boolean result = !(manager.getVerre().isEmpty());
		Assert.assertTrue("verres nest pas vide", result);
	}
}
