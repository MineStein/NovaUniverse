package com.minestein.novauniverse.util.general;

/**
 * ****************************************************************************************
 * Copyright MineStein © 2015
 * <p>
 * Any code contained within this document, and any associated API's with similar branding
 * are the sole property of MineStein. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the license, and void any
 * agreements with you, the third party.
 * <p>
 * Thanks, and have a nice day.
 * ****************************************************************************************
 */
public class JSONCreator {

    public enum ClickEventType {
        RUN_COMMAND("run_command"),

        SUGGEST_COMMAND("suggest_command"),

        OPEN_URL("open_url");

        String type;

        ClickEventType(String type) {
            this.type = type;
        }

        String getType() {
            return this.type;
        }
    }

    StringBuilder json;

    public JSONCreator() {
        this.json = new StringBuilder();
        add("[\"\",");
    }

    public JSONCreator addText(String text, ClickEventType clickEventType, String clickEventValue, String hoverText) {
        add("{\"text\":\""+text+"\"");

        if (clickEventType!=null&&clickEventValue!=null) {
            add(", \"clickEvent\":{\""+clickEventType.getType()+"\",\"value\":\""+clickEventValue+"\"}");
        }

        if (hoverText!=null) {
            add(", \"hoverEvent\":{\"action\":\"show_text\", \"value\":{\"value\":\"\", \"extra\":[{\"text\":\""+hoverText+"\"}]}}");
        }

        return this;
    }

    public JSONCreator finish() {
        add("}]");

        return this;
    }

    public String toString() {
        return this.json.toString();
    }

    private void add(Object object) {
        this.json.append(object);
    }
}