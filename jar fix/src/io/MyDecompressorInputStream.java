package io;

import java.io.IOException;
import java.io.InputStream;

public class MyDecompressorInputStream extends InputStream {

	InputStream in;
	int decopressedSize;
	
	public MyDecompressorInputStream(InputStream in) {
		this.in  = in;
		try {
			decopressedSize = in.read();
		} catch (IOException e) {
			System.out.println("the file is empty");
		}
	}
	
	@Override
	public int read() throws IOException {

		return (int)in.read();
	}
	
	@Override
	public int available()
	{
		return decopressedSize;
	}
	
	public int read(byte[] b) throws IOException{
		byte last;
		byte counter;
		int fileSize= in.available();
		int k = 0 ;
		
		for(int i = 0 ; i < fileSize ; i += 2){
			if(b.length <= k)
				break;
			
			last = (byte)in.read();
			counter = (byte)in.read();
			
			
			
			for(int j = 0 ; j < counter ; j++)
			{
				if(b.length <= k)
					break;
				
				b[k++] = last;
			}
		}
		
		
		return -1;
		
	}

}
