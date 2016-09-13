package xyz.enhorse.parameters.loaders;

import xyz.enhorse.commons.Check;
import xyz.enhorse.commons.StringPair;
import xyz.enhorse.commons.Validate;
import xyz.enhorse.parameters.Parameter;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author <a href="mailto:pavel13kalinin@gmail.com">Pavel Kalinin</a>
 *         18.08.2016
 */
public class StringLoader implements Loader {

    private final Map<String, String> map = new HashMap<>();
    private final String content;
    private final String splitter;


    public StringLoader(final String string, final String delimiter) {
        content = Validate.defaultIfNull(string, "");
        splitter = Validate.notNullOrEmpty("delimiter", delimiter);
    }


    @Override
    public Map<String, String> load() {
        return load(new Companion() {
        });
    }


    @Override
    public Map<String, String> load(final Companion companion) {
        map.clear();

        Companion processor = Validate.defaultIfNull(companion, new Companion() {
        });

        StringTokenizer tokenizer = new StringTokenizer(content, splitter, false);
        while (tokenizer.hasMoreElements()) {
            processEntry(tokenizer.nextToken(), processor);
        }

        return new HashMap<>(map);
    }


    private void processEntry(final String string, final Companion companion) {
        StringPair pair = StringPair.create(string, Parameter.SEPARATOR);

        String key = companion.preProcessKey(pair.leading());
        String value = companion.preProcessValue(pair.trailing());

        if (!Check.isNullOrEmpty(key)) {
            if (map.containsKey(key)) {
                LOGGER.warn("\'" + key + "\' already defined. The previous value will be replaced with a new one.");
            }

            map.put(companion.postProcessKey(key), companion.postProcessValue(value));
        }
    }


    @Override
    public String toString() {
        return "[" + content + "]:[" + splitter + ']';
    }
}
