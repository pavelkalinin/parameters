package xyz.enhorse.parameters.schemas.constraints;

import static xyz.enhorse.parameters.schemas.constraints.NumberExaminers.*;

/**
 * @author <a href="mailto:pavel13kalinin@gmail.com">Pavel Kalinin</a>
 *         06/09/16
 */
public class NumberInRangeExclusive<T extends Number> implements Constraint<T> {

    private final NumberRange range;


    public NumberInRangeExclusive(final Number a, final Number b) {
        range = new NumberRange(a, b);
    }


    @Override
    public boolean isApplicable(final Number value) {
        return (value != null)
                && (GREATER.evaluate(value, range.min()))
                && (LESS.evaluate(value, range.max()));
    }


    @Override
    public int hashCode() {
        return range.hashCode();
    }


    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final NumberInRangeExclusive that = (NumberInRangeExclusive) o;

        return range.equals(that.range);

    }


    @Override
    public String toString() {
        return "NUMBER_IN(" + range.min() + ',' + range.max() + ')';
    }
}
