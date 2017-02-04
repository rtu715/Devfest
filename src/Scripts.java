import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.File;

public class Scripts {
	
	public static String getCPUInfo() {
		return "";
	}

	public static String getWeather() {
		return "";
	}

	public static String getCalendar() {
		try {
			ProcessBuilder builder = new ProcessBuilder("cal");
			builder.redirectErrorStream(true);
			Process process = builder.start();
			InputStream is = process.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));

			String line = null;
			StringBuilder sb = new StringBuilder();
			while ((line = reader.readLine()) != null) {
			   sb.append(line);
			   sb.append("\n");
			}
			// System.out.print(sb.toString());
			return sb.toString();
		} catch (IOException e) {
			System.out.println("An IOException happened");
			return "Error";
		}
	}

	public static String getSpeedTest() {
		return "";
	}

	public static void getDirTree(String dirPath, int level) {
		
		        File dir = new File(dirPath);
		        File[] firstLevelFiles = dir.listFiles();
		        if (firstLevelFiles != null && firstLevelFiles.length > 0) {
		            for (File aFile : firstLevelFiles) {
		                for (int i = 0; i < level; i++) {
		                    System.out.print("\t");
		                }
		                if (aFile.isDirectory()) {
		                    System.out.println("[" + aFile.getName() + "]");
		                    getDirTree(aFile.getAbsolutePath(), level + 1);
		                } else {
		                    System.out.println(aFile.getName());
		                }
		            }
		        }
		    
		}

	public static void main(String[] args) {
		// testing these methods
		Scripts s = new Scripts();
		Scripts.getCalendar();
		String dir = System.getProperty("user.home") + File.separator + "Downloads";
		Scripts.getDirTree(dir,0);
	}

}