package com.constants;

import java.io.File;
import java.util.Random;
import com.utils.CommonFunctionsHelper;

public class FrameworkConstant {

	// Project root directory
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String RESOURCE_PATH = PROJECT_PATH + File.separator + "src" + File.separator + "test"
			+ File.separator + "resources" + File.separator;

	// Property file
	public static final String PROPERTY_FILE_PATH = RESOURCE_PATH + "config.properties";

	// Wait timing
	public static final int EXPLICIT_MAXWAIT = 10;
	public static final int EXPLICIT_MINWAIT = 2;

	// Screenshot paths
	public static final String SCREENSHOT_DIR = PROJECT_PATH + File.separator + "screenShots" + File.separator;
	public static final String testCaseScreenShotPath() {
		return SCREENSHOT_DIR + CommonFunctionsHelper.getCurrentDateTime() + new Random().nextInt(20) + ".png";
	}

	// Extent reporting
	public static final String REPORT_DIR = PROJECT_PATH + File.separator + "reports" + File.separator;
	public static final String NEW_REPORT_PATH = REPORT_DIR + "Extent-TestReport-"
			+ CommonFunctionsHelper.getCurrentDateTime() + ".html";

	public static final String YES = "yes";
	public static final String NO = "no";

}
