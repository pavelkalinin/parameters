package xyz.enhorse.parameters.loaders;

/**
 * @author <a href="mailto:pavel13kalinin@gmail.com">Pavel Kalinin</a>
 *         24.08.2016
 */
public interface Companion {

    default String preProcessKey(final String key) {
        return key;
    }

    default String preProcessValue(final String value) {
        return value;
    }

    default String postProcessKey(final String key) {
        return key;
    }

    default String postProcessValue(final String value) {
        return value;
    }
}
