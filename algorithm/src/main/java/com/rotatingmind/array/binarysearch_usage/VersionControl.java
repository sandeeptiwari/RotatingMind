package com.rotatingmind.array.binarysearch_usage;

public class VersionControl {
    protected int badVersion;

    // Constructor to set the bad version
    public VersionControl() {
    }

    // Method to check if a version is bad or not
    public boolean isBadVersion(int version) {
        return version >= badVersion;
    }
}
