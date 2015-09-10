package io;

import java.io.IOException;
import java.io.OutputStream;

public class MyCompressorOutputStream extends OutputStream {

	private OutputStream out;
	
	
	public MyCompressorOutputStream(OutputStream out) {
		this.out = out;	
	}
	
 	@Override
	public void write(int b) throws IOException {
		out.write((byte)b);
 		
	}
 	
 	
 	public void write(byte[] byteArr) throws IOException 
 	{
	 	byte last = byteArr[0];
	 	byte counter = 0;
	 	
	 	//specify the number of bytes in the uncompressed array.
	 	out.write(byteArr.length); 
	 	
	 	//compress and write the array.
 		for(byte b : byteArr)
 		{
 			if(b == last)
 			{
 				counter++;
 			}
 			else
 			{
 				out.write(last);
 				out.write(counter);
 				last = b;
 				counter = 1;
 			}
 		}
 		if(counter > 0) //flush the buffer
 		{
 			out.write(last);
 			out.write(counter);
 		}
 		
 	}
}
