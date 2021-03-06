package com.bonitoo.qa.flux.rest.artifacts.telegraf;

import com.bonitoo.qa.flux.rest.artifacts.Label;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Telegraf {

    String id;
    String organizationID;
    String name;
    String description;
    Agent agent;
    List<TelegrafPluginIgnoreConf> plugins;
    List<Label> labels;
    TelegrafLinks links;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrganizationID() {
        return organizationID;
    }

    public void setOrganizationID(String organizationID) {
        this.organizationID = organizationID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public List<TelegrafPluginIgnoreConf> getPlugins() {
        return plugins;
    }

    public void setPlugins(List<TelegrafPluginIgnoreConf> plugins) {
        this.plugins = plugins;
    }
}
