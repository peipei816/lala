import java.io.*;

public class copytest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File in = new File("D:" + File.separator + "0412.txt");
		File out = new File("D:" + File.separator + "new0412.txt");
		if(!in.exists()) {
			System.out.println("输入文件不存在！");
			System.exit(1);
		}
		if(!out.getParentFile().exists()) {
			out.getParentFile().mkdirs();
		}
		InputStream input = new FileInputStream(in);
		OutputStream output = new FileOutputStream(out);
		
		byte data[] = new byte[1024];
		int temp = 0;
		while((temp = input.read(data)) != -1) {
			output.write(data, 0, temp);
		}
		
		input.close();
		output.close();
		
	}

}
