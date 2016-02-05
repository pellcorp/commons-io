package com.pellcorp.commons.io.output;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Test;

public class ByteArrayOutputStreamTest extends Assert {
	@Test
	public void testToInputStream() throws Exception {
		String data = StringUtils.repeat("X", 10000000);
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			os.write(data.getBytes("UTF-8"));
			
			String result1 = new String(IOUtils.toByteArray(os.toInputStream()), "UTF-8");
			String result2 = new String(IOUtils.toByteArray(os.toInputStream()), "UTF-8");
			assertEquals(result1, result2);
		} finally {
			os.close();
		}
	}
}
