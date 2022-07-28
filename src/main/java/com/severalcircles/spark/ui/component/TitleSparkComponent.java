package com.severalcircles.spark.ui.component;

import com.severalcircles.spark.ui.SparkBoard;

public class TitleSparkComponent implements SparkComponent{
    private String content;

    @Override
    public String toString() {
        return content;
    }

    public TitleSparkComponent(String content) {
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
        sparkBoard.newEmbed();
        sparkBoard.builder.setTitle(content);
        return sparkBoard;
    }
}
