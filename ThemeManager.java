package com.example.finalcalculatorproj;

// ThemeManager class
class ThemeManager {
    boolean darkMode;

    // constructor
    public ThemeManager() {
        darkMode = true; // default to dark mode
    }

    // set dark mode default
    void setDarkMode(boolean enabled) {
        darkMode = enabled;
    }

    // check if dark mode is enabled
    boolean darkModeEnabled() {
        return darkMode;
    }
}