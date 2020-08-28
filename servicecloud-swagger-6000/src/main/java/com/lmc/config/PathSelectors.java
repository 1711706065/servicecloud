package com.lmc.config;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.util.AntPathMatcher;

/**
 * @Author lmc
 * @Description
 * @Date: Create in 22:10 2020/8/24
 */
public class PathSelectors {
    private PathSelectors() {
        throw new UnsupportedOperationException();
    }

    public static Predicate<Object> any() {
        return Predicates.alwaysTrue();
    }

    public static Predicate<String> none() {
        return Predicates.alwaysFalse();
    }

    public static Predicate<String> regex(final String pathRegex) {
        return new Predicate<String>() {
            public boolean apply(String input) {
                return input.matches(pathRegex);
            }
        };
    }

    public static Predicate<String> ant(final String antPattern) {
        return new Predicate<String>() {
            public boolean apply(String input) {
                AntPathMatcher matcher = new AntPathMatcher();
                return matcher.match(antPattern, input);
            }
        };
    }
}
