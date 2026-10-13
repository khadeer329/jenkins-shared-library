package org.example

class BuildUtils implements Serializable {
    static String getGreeting(String appName) {
        return "Building application: ${appName}"
    }
}
