package GenericUtility;

import org.openqa.selenium.*;

import org.testng.Assert;

import java.io.*;

import org.apache.commons.io.FileUtils;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;

import java.text.SimpleDateFormat;
import java.util.HashMap;


public class TestUtil {
	public static void createScreenshot(WebDriver driver, String suiteName)
			throws IOException {
		String path = "screenshot" + "/" + suiteName + "/";
		String fileName = "scrshot.png";
		String fullFileName = path + fileName;
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(fullFileName));
		System.out.println("\tscreenshot stored to " + fullFileName);
	}

	public static String readFileToString(String filePath)
			throws java.io.IOException {
		byte[] buffer = new byte[(int) new File(filePath).length()];
		BufferedInputStream f = null;
		try {
			f = new BufferedInputStream(new FileInputStream(filePath));
			f.read(buffer);
		} finally {
			if (f != null)
				try {
					f.close();
				} catch (IOException ignored) {
				}
		}
		return new String(buffer);
	}

	public static void moveOldScreenshot(String suiteName) {
		String pathToAssert = "screenshot" + "/" + suiteName + "/"
				+ "processed";
		String path = "screenshot" + "/" + suiteName + "/";
		String fileName = "scrshot.png";
		String fullFileName = path + fileName;
		if (!assertDirExist(pathToAssert)) {
			System.out.println("\tunable to create directory tree. exit");
			System.exit(1);
		}
		boolean exists = (new File(fullFileName)).exists();
		if (exists) {
			String dateTimeStr = getDateTime();
			String[] holdem = fileName.split("\\.");
			String name = holdem[0];
			String ext = holdem[1];
			String destFileName = path + name + "_" + dateTimeStr + "." + ext;
			File fileSrc = new File(fullFileName);
			File fileDest = new File(destFileName);
			File destDir = new File(pathToAssert);
			boolean success = fileSrc.renameTo(new File(destDir, fileDest
					.getName()));
			if (!success) {
				System.out.println("\tunable to move the screenshot file "
						+ fileSrc + " .exit");
				System.exit(1);
			}
			System.out.println("\tmoved screenshot file " + fileSrc + " to "
					+ pathToAssert);
		}
	}

	public static boolean writeStrToFile(String str, String file) {
		BufferedWriter out;
		try {
			out = new BufferedWriter(new FileWriter(file, true));
			out.write(str);
			out.close();
			return true;
		} catch (IOException e) {
			System.err.println("exception returned: " + e);
			return false;
		}
	}

	public static boolean assertDirExist(String dirPath) {
		boolean ret = true;
		File dir = new File(dirPath);
		if (!dir.exists()) {
			try {
				boolean success = (dir).mkdirs();
				if (success) {
					System.out
							.println("\tDirectories: " + dirPath + " created");
				}
			} catch (Exception e) {
				System.err.println("\tError: " + e.getMessage());
				ret = false;
			}
		}
		return ret;
	}

	public static boolean cleanDir(File dirPath) {
		boolean ret = true;
		try {
			if (dirPath.exists()) {
				File[] files = dirPath.listFiles();
				for (int i = 0; i < files.length; i++) {
					if (files[i].isDirectory()) {
						cleanDir(files[i]);
					} else {
						files[i].delete();
					}
				}
			}
		} catch (Exception e) {
			System.err.println("Unable to clean dir: " + dirPath + " Error: "
					+ e.getMessage());
			ret = false;
		}
		return ret;
	}

	public static String getCurrentPath() {
		String curPath = "";
		File dir1 = new File(".");
		try {
			curPath = dir1.getCanonicalPath() + "/";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return curPath;
	}

	public static String getDateTime() {
		String dateFormatNow = "MM-dd-yyyy_HH-mm-ss";
		String dateTimeStr = null;
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormatNow);
		dateTimeStr = sdf.format(cal.getTime());
		return dateTimeStr;
	}

	public static String makeStrUnique(String in) {
		String out = null;
		String dateFormatNow = "MMddyyyyHHmmss";
		String dateTimeStr = null;
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormatNow);
		dateTimeStr = sdf.format(cal.getTime());
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(8888);
		String randomStr = Integer.toString(randomInt);
		out = in + "_" + randomStr + "_" + dateTimeStr;
		return out;
	}

	public static long getAvg(List<Long> listOfValues) {
		long sum = 0;
		long size = listOfValues.size();
		for (Long i : listOfValues) {
			sum += i;
		}
		long avg = sum / size;
		return avg;
	}

	/**public static void captureScreen(Webdriver driver, String suiteName)
			throws Exception {
        // To oepn URL "http://softwaretestingmaterial.com"
		  driver.get("https://www.softwaretestingmaterial.com");
		  Thread.sleep(2000);
		  Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		  ImageIO.write(fpScreenshot.getImage(),"PNG",new File("D:///FullPageScreenshot.png"));
		    
	}**/

	public static void deleteFile(String file) {
		File f = new File(file);
		if (!f.exists())
			throw new IllegalArgumentException(
					"Delete: no such file or directory: " + file);
		if (!f.canWrite())
			throw new IllegalArgumentException("Delete: write protected: "
					+ file);
		if (f.isDirectory()) {
			String[] files = f.list();
			if (files.length > 0)
				throw new IllegalArgumentException(
						"Delete: directory not empty: " + file);
		}
		boolean success = f.delete();
		if (!success)
			throw new IllegalArgumentException("Delete: deletion failed");
	}

	public static void deleteDirectory(File dir) throws IOException {
		if (dir.isDirectory()) {
			for (File child : dir.listFiles()) {
				deleteDirectory(child);
			}
		}
		if (!dir.delete()) {
			throw new IOException("\tCould not delete " + dir);
		}
	}

	

	public static void assertFileExists(String file) throws IOException {
		File f = new File(file);
		boolean exists = f.exists();
		boolean success;
		if (exists) {
			success = f.delete();
			if (!success) {
			  System.out.println("\tUnable to delete file " + file);
			  System.exit(1);
			} else {
			  System.out.println("\t\tDeleted file" + file);
			}
		} else {
			success = f.createNewFile();
			if (!success) {
				System.out.println("\tUnable to create file " + file);
				System.exit(2);
			} else {
				System.out.println("\t\tCreated file" + file);
			}
		}
	}

	public static void appendToFile(String lines, String file) {
		 try{
			  FileWriter fstream = new FileWriter(file,true);
			  BufferedWriter out = new BufferedWriter(fstream);
			  out.write(lines);
			  out.close();
		  }catch (Exception e){
			  System.err.println("Error: " + e.getMessage());
		  }
	}

}
