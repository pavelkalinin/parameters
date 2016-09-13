package xyz.enhorse.parameters;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author <a href="mailto:pavel13kalinin@gmail.com">Pavel Kalinin</a>
 *         27.04.2016
 */
public class ConcurrentParameters extends BasicParameters<ConcurrentHashMap> {

    public ConcurrentParameters() {
        super(ConcurrentHashMap.class);
    }
}
