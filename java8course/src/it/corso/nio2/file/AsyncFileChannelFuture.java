package it.corso.nio2.file;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Demonstrates Async File Channel with Future
 * @author thimoty
 *
 */
public class AsyncFileChannelFuture {

	public static void main(String[] args) {
		
		var file = Path.of("src/it/corso/nio2/file/foobar.txt");

		try (var channel =
		  AsynchronousFileChannel.open(file)) {
		    var buffer = ByteBuffer.allocate(100);
		    Future<Integer> result = channel.read(buffer, 0);

		    // BusinessProcess.doSomethingElse();

		    var bytesRead = result.get();
		    System.out.println("Bytes read [" + bytesRead + "]");
		    //
		    System.out.println(result);
		    //
		    // Printing contents from read buffer		    
		    //
		    StringBuffer contents = new StringBuffer();
	        contents.append(new String(buffer.array()).trim());
	        System.out.println(contents.toString());
		    
		  } catch (IOException | ExecutionException |
		    InterruptedException e) {
		    e.printStackTrace();
		}
		
	}
	
}
