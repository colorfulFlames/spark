package com.severalcircles.spark.ui;

import com.severalcircles.spark.ui.component.SparkComponent;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;

import java.util.LinkedList;
import java.util.List;

public abstract class SparkBoard {
    private List<SparkComponent> components = new LinkedList<>();
    private List<MessageEmbed> embeds;
    public EmbedBuilder builder = new EmbedBuilder();
    public void addComponent(SparkComponent component) { components.add(component); }
    public void addComponents(List<SparkComponent> components) {
        this.components.addAll(components);
    }
    public void newEmbed() {
        embeds.add(builder.build());
        builder = new EmbedBuilder();
    }
    public List<MessageEmbed> getEmbeds() {
        components.forEach(component -> {
            component.addTo(this);
        });
        return embeds;
    }
}
