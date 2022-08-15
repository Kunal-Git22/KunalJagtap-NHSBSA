package com.utils;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.apache.poi.util.IOUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.constants.FrameworkConstant;
import com.driver.DriverManager;

public final class CommonFunctionsHelper {
	
	private CommonFunctionsHelper() {}
	
	/**
	 * Captures screenshot and returns the screenshot path.
	 * @return return the screenshot path.
	 */
	public static String takeScreenshotAndPullPath() {
		File scrFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
		String targetPath = null;
		try {
			targetPath = FrameworkConstant.testCaseScreenShotPath();
			FileUtils.copyFile(scrFile,new File(targetPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Log.logInfo("Screen shot is captured successfully.");
		return targetPath;
	}
	
	/**
	 * Gives a base64 image to attach in the extent report. 
	 * <br>Converting image into base64 format to avoid screenshots broken.
	 * @return return the encoded Base64 image string.
	 */
	public static String getBase64Image() {
		String base64 = null;
		try {
			InputStream inputStream = new FileInputStream(CommonFunctionsHelper.takeScreenshotAndPullPath());
			byte[] imageBytes = IOUtils.toByteArray(inputStream);
			base64 = Base64.getEncoder().encodeToString(imageBytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return base64;
	}
	
	/**
	 * Gives a base64 image to attach in the extent report. 
	 * <br>Converting image into base64 format to avoid screenshots broken.
	 * @return return the encoded Base64 image string.
	 */
	public static String getImageBase64() {
		return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}
	
	/**
	 * Take screenshot as byte image to attach in the extent report. 
	 * <br>Converting image into byte format.
	 * @return return the image as byte.
	 */
	public static byte[] getImageAsByte() {
		return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
	}
	
	/**
	 * This method gives the current date and time on specific format.
	 * @return It returns time in specific format.
	 */
	public static String getCurrentDateTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("MMddyyyy_hh_mm_ss");
		return formatter.format(new Date());
	}
	
	/**
	 * This method deletes all the X days(mentioned in property file) older reports.
	 */
	public static void deleteOldReports() {
		File targetDirForReport = new File(FrameworkConstant.REPORT_DIR);
		if (PropertyHelper.get(PropertyEnum.DELETEOLDREPORTS).equalsIgnoreCase(FrameworkConstant.YES)) {
			if (targetDirForReport.exists()) {
				deleteOldFiles(targetDirForReport.listFiles());
				Log.logInfo("Old reports are deleted successfully.");
			}
		}
	}
	
	/**
	 * This method deletes all the X days older files.<br>
	 * @param All the files to be deleted
	 */
	private static void deleteOldFiles(File[] filesToDelete) {
		int daysBack = Integer.parseInt(PropertyHelper.get(PropertyEnum.NUMBEROFDAYS));
		long purgeTime = System.currentTimeMillis() - ((long) daysBack * 24 * 60 * 60 * 1000);
		for (File report : filesToDelete) {
			if (report.lastModified() < purgeTime) {
				report.delete();
			}
		}
	}
	
}
