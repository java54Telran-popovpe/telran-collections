package telran.util.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import telran.util.ArrayList;

public class ArrayListTest extends ListTest {
	@BeforeEach
	@Override
	void setUp() {
		collection = new ArrayList<Integer>();
		super.setUp();
	}
	@Test
	@DisplayName(value="List::get(index)")
	void getTest() {
		runGetTest(2,1);
		runGetTest(0, -20);
		runGetTest(5, -5);
		runGetTest(-1, 0);
		runGetTest(6, 0);
		runGetTest(10, 0);
	}
	@Test
	@DisplayName(value="List::add(index,object)")
	void addTest() {
		runAddTest(0, -21, new Integer[]{ -21, -20, 10, 1, 100, -5 });
		runAddTest(6, -6, new Integer[]{ -21, -20, 10, 1, 100, -5, -6 });
		runAddTest(2, -15, new Integer[]{ -21, -20, -15, 10, 1, 100, -5, -6 });
		runAddTest(-1, -15, new Integer[]{ -21, -20, -15, 10, 1, 100, -5, -6 });
		runAddTest(9, -15, new Integer[]{ -21, -20, -15, 10, 1, 100, -5, -6 });
		for ( int count = 0; count < 3; count++ )
			for( Integer i: new Integer[]{ -21, -20, -15, 10, 1, 100, -5, -6 }) //-6, -5, 100, 1, 10, -15, -20, -21
				list.add(4, i);
		assertArrayEquals(new Integer[]{-21, -20, -15, 10, 
											-6, -5, 100, 1, 10, -15, -20, -21, 
											-6, -5, 100, 1, 10, -15, -20, -21, 
											-6, -5, 100, 1, 10, -15, -20, -21, 
											1, 100, -5, -6 },
				getArray());
		
		
	}
	@Test
	@DisplayName(value="List::add(index,object)")
	void removeTest() {
		runRemoveTest(-1, new Integer[]{ -20, 10, 1, 100, -5 });
		runRemoveTest(5, new Integer[]{ -20, 10, 1, 100, -5 });
		runRemoveTest(4, new Integer[]{ -20, 10, 1, 100,});
		runRemoveTest(0, new Integer[]{ 10, 1, 100,});
		runRemoveTest(0, new Integer[]{ 1, 100,});
		runRemoveTest(1, new Integer[]{ 1, });
		runRemoveTest(0, new Integer[]{ });
		runRemoveTest(0, new Integer[]{ 1000 });
		assertEquals(-1, list.indexOf(100));
		
	}
	@Test
	@DisplayName(value="List::indexOf(object)")
	void indexOfTest() {
		assertEquals(3, list.indexOf(100));
		assertEquals(-1, list.indexOf(0));
	}
	
	@Test
	@DisplayName(value="List::lastIndexOf(object)")
	void lastIndexOfTest() {
		list.add(-20);
		assertEquals(5, list.lastIndexOf(-20));
		assertEquals(-1, list.lastIndexOf(0));
	}
	
	@Test
	@DisplayName(value = "Collection::size()")
	void sizeMethodTest() {
		assertEquals(5, collection.size());
	}
	
	@Test
	@DisplayName(value="Collection::contains(object)")
	void containsMethodTest() {
		assertTrue( collection.contains(10) );
		assertTrue(!collection.contains(-3));
	}
	
	@Test
	@DisplayName(value="Collection::remove(object)")
	void removeMethodTest() {
		runRemoveTest(new Integer[]{-20, 10, 100, -5}, 1);
		runRemoveTest(new Integer[]{-20, 10, 100, -5}, -4);
		runRemoveTest(new Integer[]{-20, 10, 100,}, -5);
		runRemoveTest(new Integer[]{10, 100,}, -20);
		runRemoveTest(new Integer[]{ 100,}, 10);
		runRemoveTest(new Integer[]{}, 100);
		runRemoveTest(new Integer[]{}, 100);
		assertEquals(0, collection.size());
		assertTrue(!collection.contains(100));
	}
	@Test
	@DisplayName(value="Collection::add(object)")
	void addObjectTest() {
		for ( int count = 0; count < 3; count++ )
			for( Integer i: new Integer[]{  -20, 10, 1, 100, -5, }) 
				collection.add(i);
		assertArrayEquals(new Integer[]{  	-20, 10, 1, 100, -5, 
											-20, 10, 1, 100, -5, 
											-20, 10, 1, 100, -5, 
											-20, 10, 1, 100, -5,},
				getArray());
	}
	@Test
	void iteratorTest( ) {
		runTest(numbers);
	}


}
