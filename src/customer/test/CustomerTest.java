package customer.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import customer.model.Customer;

public class CustomerTest {
	Customer me = new Customer("Carey", "D", "Blackwell", "Male", "218 Benjamin Blvd", "Bear", "Delaware", "19701");
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testF() {
		assertEquals("First Name Wrong", "Carey", me.getFirstName());
	}
	@Test
	public void testM() {
		assertEquals("Middle Initial Wrong", "D", me.getMiddleInit());
	}
	@Test
	public void testL() {
		assertEquals("Last Name Wrong", "Blackwell", me.getLastName());
	}
	@Test
	public void testG() {
		assertEquals("Gender Wrong", "Male", me.getGender());
	}
	@Test
	public void testA() {
		assertEquals("Address Wrong", "218 Benjamin Blvd", me.getAddress());
	}
	@Test
	public void testC() {
		assertEquals("City Wrong", "Bear", me.getCity());
	}
	@Test
	public void testS() {
		assertEquals("State Wrong", "Delaware", me.getState());
	}
	@Test
	public void testZ() {
		assertEquals("Zip Code Wrong", "19701", me.getZip());
	}

}
