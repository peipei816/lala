import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class iotest {
	public static void main(String args[]) {
		File file = new File("D:" + File.separator + "0412.txt");
		if(file.exists()) {
			try {
				InputStream ins = new FileInputStream(file);
				byte data[] = new byte[1024];
				int temp = 0;
				int foot = 0;
				while((temp = ins.read()) != -1) {
					data[foot++] = (byte)temp;
				}
				System.out.println(new String(data, 0, foot));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
}
