package com.rottaingmind.application.canonicalpath;

import com.rottaingmind.ds.stack.applications.canonicalpath.SimplifiedCanonicalPath;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimplifiedCanonicalPathTest {
    private SimplifiedCanonicalPath simplifiedCanonicalPath;

    @BeforeEach
    public void setUp() {
        simplifiedCanonicalPath = new SimplifiedCanonicalPath();
    }

    @Test
    public void testCanonicalPath() {
        String result = simplifiedCanonicalPath.simplifiedCanonicalPath("/home/");
        assertEquals("/home", result);
        String result1 = simplifiedCanonicalPath.simplifiedCanonicalPath("/../");
        assertEquals("/", result1);
        String result2 = simplifiedCanonicalPath.simplifiedCanonicalPath("/home//foo/");
        assertEquals("/home/foo", result2);
        String result3 = simplifiedCanonicalPath.simplifiedCanonicalPath("/a/./b/../../c/");
        assertEquals("/c", result3);
    }
}
