package com.severalcircles.spark.ui;

import com.severalcircles.spark.ui.component.SparkComponent;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;

import java.util.LinkedList;
import java.util.List;

/**
 * The big picture of everything the user sees in response to a request
 */
public abstract class SparkBoard {
    private List<SparkComponent> components = new LinkedList<>();
    private List<MessageEmbed> embeds;
    /**
     * The current embed being built
     */
    public EmbedBuilder builder = new EmbedBuilder();

    /**
     * Adds a component to the SparkBoard
     * @param component The component to add
     */
    public void addComponent(SparkComponent component) { components.add(component); }

    /**
     * Adds a List of SparkComponents to the SparkBoard
     * @param components List of components to add
     */
    public void addComponents(List<SparkComponent> components) {
        this.components.addAll(components);
    }

    /**
     * Starts a new embed below the previous one.
     */
    public void newEmbed() {
        embeds.add(builder.build());
        builder = new EmbedBuilder();
    }

    /**
     * @return A list of embeds to be sent to the user
     */
    public List<MessageEmbed> getEmbeds() {
        components.forEach(component -> {
            component.addTo(this);
        });
        return embeds;
    }
}
