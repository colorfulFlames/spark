package com.severalcircles.spark.ui.component;

import com.severalcircles.spark.ui.SparkBoard;

import java.util.ResourceBundle;

public class ResponseTextSparkComponent implements SparkComponent {
    ResourceBundle icons = ResourceBundle.getBundle("IconURLs");
    private String content;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return content;
    }

    public ResponseTextSparkComponent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public SparkBoard addTo(SparkBoard sparkBoard) {
        sparkBoard.builder.setAuthor(content, url, icons.getString("flamesIcon"));
        return sparkBoard;
    }
}
