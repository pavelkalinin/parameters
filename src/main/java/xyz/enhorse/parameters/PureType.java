package xyz.enhorse.parameters;

/**
 * @author <a href="mailto:pavel13kalinin@gmail.com">Pavel Kalinin</a>
 *         16.09.2016
 */
public interface PureType<T> {

    T cast(final String string);
}
