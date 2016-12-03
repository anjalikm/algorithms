import java.io.File;
import java.io.IOException;

public class FileSorter {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File directory = new File(args[0]);
		System.out.println(directory.getCanonicalPath().toString());
		File files[] = directory.listFiles();
		System.out.println(files.length);
		MySelectionSort.sort(files);
		//MyShell.sort(files);
		for(int i = 0 ;i < files.length; i++)
			System.out.println(files[i]);

	}

}
