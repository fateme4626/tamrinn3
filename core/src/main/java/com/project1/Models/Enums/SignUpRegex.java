package com.project1.Models.Enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum SignUpRegex {
    Password("^(?=.*\\d)(?=.*[@%$#&*()_])(?=.*[A-Z]).+$");
    private final String regex;

    SignUpRegex(String regex) {
        this.regex = regex;
    }

    public Matcher getMatcher(String input) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(input);
    }
}
