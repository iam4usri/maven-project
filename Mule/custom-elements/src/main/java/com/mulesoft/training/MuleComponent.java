package com.mulesoft.training;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mule.api.annotations.param.InboundHeaders;
import org.mule.api.annotations.param.Payload;

public class MuleComponent {
	
	Integer count = 0;

	public Map<String, String> processMap(Map<String, String> input) {
		input.put("executed by", "processMap method");
		return input;
	}

	public Map<String, String> processArray(List<String> input) {
		HashMap<String, String> output = new HashMap<String, String>();
		int index = 0;
		for(String str : input) {
			output.put(String.valueOf(index++), str);
		}
		return output;
	}

	public Map<String, String> processString() {
		// processString implementation
		return null;
	}

	public Map<String, String> processAll(@Payload Object input,@InboundHeaders("http.method") String httpMethod) {
		HashMap<String, String> output = new HashMap<String, String>();
		output.put("message", input.toString());
		output.put("http.method", httpMethod);
		output.put("method-name", "processAll");
		output.put("count", String.valueOf(count++));
		return output;
	}

}
