package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.channels.SelectableChannel;

import org.junit.Test;

import services.SelectCityGenerator;

public class TestSelectCityGenerator {

	@Test(expected=IOException.class)
	public void test_should_give_exception_when_path_to_file_is_wrong() throws IOException {
		
		SelectCityGenerator selectCityGenerator = new SelectCityGenerator("wrong/path");
		selectCityGenerator.make();
		
	}

}
