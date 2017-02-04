import java.io.BufferedReader;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.File;
import java.io.IOException;

public class Scripts {

	public static String getCpu() {
		StringBuilder sb = new StringBuilder();
		OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
		for (Method method : operatingSystemMXBean.getClass().getDeclaredMethods()) {
		    method.setAccessible(true);
		    if (method.getName().startsWith("getProcessCpuTime") 
		        && Modifier.isPublic(method.getModifiers())) {
		            Object value;
		        try {
		            value = method.invoke(operatingSystemMXBean);
		        } catch (Exception e) {
		            value = e;
		        } // try
		        System.out.println("Process Cpu Time" + " = " + value);
		        sb.append("Process Cpu Time = " + value+"\n");
		    } // if
		} // for
		return sb.toString();
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
			System.out.print(sb.toString());
			return sb.toString();
		} catch (IOException e) {
			System.out.println("An IOException happened");
			return "Error";
		}
	}

	public static String getSpeedTest() {
		return "";
	}

	public static String getDirTree() {
		try {
			String dir = System.getProperty("user.dir");
			String result = Scripts.showDir(dir);
			System.out.println(result);
			return result;
		} catch (IOException e) {
			System.out.println("An IOException happened");
			System.out.println(e.getMessage());
			return "Error";
		}
	}

	private static String showDir(String dirPath) throws IOException {
		StringBuilder sb = new StringBuilder();
	    File dir = new File(dirPath);
	    sb.append(dir.getName()+"\n");
        File[] firstLevelFiles = dir.listFiles();
        if (firstLevelFiles != null && firstLevelFiles.length > 0) {
            for (File aFile : firstLevelFiles) {
                sb.append("|--");
                if (aFile.isDirectory()) {
                    sb.append("[" + aFile.getName() + "]");
                    sb.append("\n");
                } else {
                    sb.append(aFile.getName());
                    sb.append("\n");
                }
            }
        }
	    return sb.toString();
	}

	public static String getMemory() {
		String m = Double.toString(Runtime.getRuntime().freeMemory()/Math.pow(10, 6));
		System.out.println("Your free memory is " +m + " MB" );
		return "Your free memory is " + m + " MB";
	}

	public static void main(String[] args) throws IOException {
		// testing these methods
		Scripts s = new Scripts();
		Scripts.getCalendar();
		Scripts.getDirTree();
		Scripts.getMemory();
		Scripts.getCpu();
	}

}