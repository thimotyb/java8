package it.corso.nio2.file;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;

/**
 * Demonstrates Async File Channel with Callback
 * @author thimoty
 *
 */
public class AsyncFileChannelCallback {

	public static void main(String[] args) {
		
		Path file = Path.of("src/it/corso/nio2/file/foobar.txt");

		try (AsynchronousFileChannel channel = AsynchronousFileChannel.open(file)) {
			ByteBuffer buffer = ByteBuffer.allocate(100);
			CompletionHandler handler = new CompletionHandler<Integer, ByteBuffer>() {
		        public void completed(Integer result,
		            ByteBuffer attachment) {
		            System.out.println("Bytes read [" + result + "]");
		        }

		        public void failed(Throwable exception,
		            ByteBuffer attachment) {
		            exception.printStackTrace();
		        }
		   };

		   channel.read(buffer, 0, buffer, handler);
		   
		   // Wait a little bit before exit to allow callback to be completed
		   // before main thread exits
		   Thread.sleep(5000);
		   
		} catch (IOException e) {
		    e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
