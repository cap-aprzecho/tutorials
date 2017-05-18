package hsbclearn.simpleapp.process;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import hsbclearn.simpleapp.IntegerWrapper;

public class SimpleDataProcessorTest extends SimpleDataProcessor {

	@Test
	public void test_processData_uniqueness() {
		// given
		List<IntegerWrapper> testData = generateData(new int[] {1, 2, 3, 3});
		SimpleDataProcessor processor = new SimpleDataProcessor();		
		
		// when
		List<IntegerWrapper> actuals = processor.processData(testData);
		
		// then
		List<IntegerWrapper> expected = generateData(new int[] {1, 2, 3, 6});
		Assert.assertEquals(expected, actuals);
	}
	
	@Test
	public void test_processData_sort() {
		// given
		List<IntegerWrapper> testData = generateData(new int[] {3, 20, -1, 19});
		SimpleDataProcessor processor = new SimpleDataProcessor();
		
		// when
		List<IntegerWrapper> actuals = processor.processData(testData);
		
		// then
		List<IntegerWrapper> expected = generateData(new int[] {-1, 3, 19, 20, 41});
		Assert.assertEquals(expected, actuals);
	}	
	
	List<IntegerWrapper> generateData(int[] data) {
		List<IntegerWrapper> generatedData = new ArrayList<IntegerWrapper>();
		
		for(int i: data) {
			generatedData.add(new IntegerWrapper(i));
		}
		
		return generatedData;
	}

}
