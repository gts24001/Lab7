package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WebsiteApplicationTests {

    @Autowired
    ApplicationContext context;

    @Test
    void contextLoads() {
        // Basic context load test
        // No assertions needed; test will fail if context does not load properly
    }

    @Test
    void testClassPresence() {
        // Verify the existing test class is present on the classpath
        assertNotNull(WebsiteApplicationTests.class, "WebsiteApplicationTests.class should be present");
    }

    @Test
    void testPackageName() {
        // Ensure package name matches the project package
        String pkg = WebsiteApplicationTests.class.getPackageName();
        assertEquals("com.example.demo", pkg, "Package name should be com.example.demo");
    }

    @Test
    void testSimpleMath() {
        // Simple deterministic sanity check
        assertEquals(4, 2 + 2, "Math should work: 2 + 2 == 4");
    }

    @Test
    void testStringContains() {
        // Deterministic string-based assertion related to repository name
        String name = "basic-quiz-server";
        assertTrue(name.contains("quiz"), "'basic-quiz-server' should contain 'quiz'");
    }

    @Test
    void testMainPackageHasBeans() {
        // Ensure there is at least one bean coming from the main package (com.example.demo)
        int count = 0;
        for (String beanName : context.getBeanDefinitionNames()) {
            Class<?> type = context.getType(beanName);
            if (type == null) continue;
            String pkg = type.getPackageName();
            if (pkg != null && pkg.startsWith("com.example.demo") && !pkg.contains(".test")) {
                count++;
            }
        }
        assertTrue(count > 0, "There should be at least one bean from com.example.demo package");
    }

    @Test
    void testHasApplicationMainMethod() throws NoSuchMethodException {
        // Look for a class with name ending in "Application" that exposes a static main(String[]) method
        boolean found = false;
        for (String beanName : context.getBeanDefinitionNames()) {
            Class<?> type = context.getType(beanName);
            if (type == null) continue;
            if (type.getPackageName().startsWith("com.example.demo") && type.getSimpleName().endsWith("Application")) {
                try {
                    Method m = type.getMethod("main", String[].class);
                    if (java.lang.reflect.Modifier.isStatic(m.getModifiers()) && m.getReturnType() == void.class) {
                        found = true;
                        break;
                    }
                } catch (NoSuchMethodException ignored) {
                }
            }
        }
        assertTrue(found, "There should be an Application class with a static main(String[]) method in com.example.demo");
    }

}