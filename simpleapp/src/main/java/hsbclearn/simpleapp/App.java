package hsbclearn.simpleapp;

import java.util.List;

import hsbclearn.simpleapp.input.FakeDataInput;
import hsbclearn.simpleapp.output.FakeXmlConsoleDataOutput;
import hsbclearn.simpleapp.process.SimpleDataProcessor;

public class App { 

	public static void main(String[] args) {
        IDataInput input = new FakeDataInput();
        List<IntegerWrapper> data = input.getData();        
        
        IDataProcessor processor = new SimpleDataProcessor();
        List<IntegerWrapper> processedData = processor.processData(data);
        
        IDataOutput output = new FakeXmlConsoleDataOutput();
        output.writeData(processedData);        
    }
}
