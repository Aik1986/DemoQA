package com.demoqa.enums;

import lombok.Getter;

public enum Endpoints {

    ALERT("/alerts"),

    FRAMES("/frames"),

    BUTTONS("/buttons"),

    MENU("/menu"),

    PRACTICEFORM("/automation-practice-form"),

    PROGRESSBAR("/progress-bar"),

    SELECTMENU("/select-menu"),

    WEBTABLES("/webtables"),

    TEXTBOX("/text-box");

    @Getter
    String endpoint;

    Endpoints(String endpoint){
        this.endpoint=endpoint;
    }
}
