package com.epam.framework.core.ui;

import org.openqa.selenium.*;

import java.util.List;

import static com.epam.framework.core.listeners.TALogger.logger;

public class Element implements WebElement{
    protected WebElement webElement;

    public Element(WebElement webElement) {
        this.webElement = webElement;
    }

    @Override
    public void click() {
        webElement.click();
    //    logger.info("Click on the element " + String.valueOf(webElement));
    }

    @Override
    public void submit() {
        webElement.submit();
        logger.info("Submit");
    }

    @Override
    public void sendKeys(CharSequence... charSequences) {
        webElement.clear();
   //     logger.info("Typing the text " +  charSequences.toString());
        webElement.sendKeys(charSequences);
    }

    @Override
    public void clear() {
        webElement.clear();
        logger.info("Clear the field " + String.valueOf(webElement));
    }

    @Override
    public String getTagName() {
  //      logger.info("Getting the tagName  " + webElement.getTagName());
        return webElement.getTagName();
    }

    @Override
    public String getAttribute(String s) {
    //   logger.info("Getting the attribute  " + s + " = " + webElement.getAttribute(s));
        return webElement.getAttribute(s);
    }

    @Override
    public boolean isSelected() {
   //     logger.info("Checking element is selected");
        return webElement.isSelected();
    }

    @Override
    public boolean isEnabled() {
    //    logger.info("Checking element is enabled");
        return webElement.isEnabled();
    }

    @Override
    public String getText() {
        String text = webElement.getText();
     //   logger.info("Text is : " + text);
        return text;
    }

    @Override
    public List<WebElement> findElements(By by) {
        return webElement.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return webElement.findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        return webElement.isDisplayed();
    }

    @Override
    public Point getLocation() {
        return webElement.getLocation();
    }

    @Override
    public Dimension getSize() {
        return webElement.getSize();
    }

    @Override
    public Rectangle getRect() {
        return webElement.getRect();
    }

    @Override
    public String getCssValue(String s) {
        return webElement.getCssValue(s);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return webElement.getScreenshotAs(outputType);
    }
}
