package hsbclearn.simpleapp.output;

import java.util.List;

import hsbclearn.simpleapp.IDataOutput;
import hsbclearn.simpleapp.IntegerWrapper;

public class ConsoleDataOutput implements IDataOutput {

	@Override
	public void writeData(List<IntegerWrapper> data) {
		System.out.println(data);
	}

}
