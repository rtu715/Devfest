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
		String result = "";
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
		        result = "<html>Process Cpu Time = <br>" + value+"</html>";
		        System.out.println(result.replace(" ", "&nbsp;"));
		    } // if
		} // for
		return result;
	}
		

	public static String getWeather() {
		return "<html>Sorry, not available yet :(<br>But you can try 'curl -4 wttr.in' in your own shell. </html>".replace(" ", "&nbsp;");
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
			sb.append("<html>");
			while ((line = reader.readLine()) != null) {
			   sb.append(line);
			   sb.append("<br>");
			}
			sb.append("</html>");
			System.out.print(sb.toString());
			return sb.toString().replace(" ", "&nbsp;");
		} catch (IOException e) {
			System.out.println("An IOException happened");
			return "Error";
		}
	}

	public static String getSpeedTest() {
		return "<html>Sorry, not available yet :(<br>But you can try www.speedtest.net. </html>".replace(" ", "&nbsp;");
	}

	public static String getDirTree() {
		try {
			String dir = System.getProperty("user.dir");
			String result = Scripts.showDir(dir);
			System.out.println(result);
			return result.replace(" ", "&nbsp;");
		} catch (IOException e) {
			System.out.println("An IOException happened");
			System.out.println(e.getMessage());
			return "Error";
		}
	}

	private static String showDir(String dirPath) throws IOException {
		StringBuilder sb = new StringBuilder();
	    File dir = new File(dirPath);
	    sb.append("<html>");
	    sb.append("["+dir.getName()+"]");
	    sb.append("<br>");
	    int count = 0;
        File[] firstLevelFiles = dir.listFiles();
        if (firstLevelFiles != null && firstLevelFiles.length > 0) {
            for (File aFile : firstLevelFiles) {
                sb.append("|--");
                if (aFile.isDirectory()) {
                    sb.append("[" + aFile.getName() + "]");
                    sb.append("<br>");
                } else {
                    sb.append(aFile.getName());
                    sb.append("<br>");
                }
                count++;
                if (count > 10)
                	break;
            }
        }
        sb.append("</html>");
	    return sb.toString().replace(" ", "&nbsp;");
	}

	public static String getMemory() {
		String m = Double.toString(Runtime.getRuntime().freeMemory()/Math.pow(10, 6));
		m = "<html>Your free memory is <br>" + m + " MB</html>";
		return m.replace(" ", "&nbsp;");
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