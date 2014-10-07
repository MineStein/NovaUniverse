package com.minestein.novauniverse.exception;

/**
 * Copyright MineStein 2014©
 * All files included within the project are subject under the standard
 * GNU license. Any and all assets are the sole property of MineStein.
 */
public class ServerNotFoundException extends Exception {

    public ServerNotFoundException() {

    }

    public String getMessage() {
        return "§4This server currently is offline/doesn't exist! Check back later!";
    }
}
