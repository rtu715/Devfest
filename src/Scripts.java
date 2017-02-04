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
	public static void getCpu() {
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
	    } // if
	  } // for
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

	public static void showDir(int indent, File file) throws IOException {
	    for (int i = 0; i < indent; i++)
	        System.out.print('-');
	      System.out.println(file.getName());
	      if (file.isDirectory()) {
	        File[] files = file.listFiles();
	        for (int i = 0; i < Math.min(5,files.length); i++)
	          showDir(indent + 4, files[i]);
	      }
	      }
	public static void getMemory() {
		String m = Double.toString(Runtime.getRuntime().freeMemory()/Math.pow(10, 6));
		System.out.println("Your free memory is " +m + " MB" );
	}

	public static void main(String[] args) throws IOException {
		// testing these methods
		Scripts s = new Scripts();
		Scripts.getCalendar();
		String dir = System.getProperty("user.home") + File.separator + "Desktop";
		Scripts.showDir(1, new File(dir));
		Scripts.getMemory();
		Scripts.getCpu();
	}

}