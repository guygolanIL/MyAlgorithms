package io;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Compresses and writes a byte array out to any OutputStream.
 * @author Guy Golan & Amit Sandak
 *
 */
public class MyCompressorOutputStream extends OutputStream {

	private OutputStream out;
	
	
	public MyCompressorOutputStream(OutputStream out) {		//Ctor
		this.out = out;	
	}
	
 	@Override
	public void write(int b) throws IOException {
		out.write((byte)b);
 		
	}
 	
 	
 	/**
 	 * The method writes the byte array data into the OutputStream in a compressed fashion.
 	 */
 	public void write(byte[] byteArr) throws IOException 
 	{
	 	byte last = byteArr[0];
	 	byte counter = 0;
	 	
	 		 	
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
