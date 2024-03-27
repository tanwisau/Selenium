import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormat;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Listener1 implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd/HH-mm-ss");
        Date date =new Date();
        String name =dateFormat.format(date);

        File file = ((TakesScreenshot)BaseClass.driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(file, new File("img.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}



