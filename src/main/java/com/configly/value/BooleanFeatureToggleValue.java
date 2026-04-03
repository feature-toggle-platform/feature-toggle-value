package com.configly.value;

import java.util.Set;

import static java.util.Objects.isNull;

record BooleanFeatureToggleValue(
        boolean value
) implements FeatureToggleValue {

    private static final String ENABLED_VALUE = "TRUE";
    private static final String DISABLED_VALUE = "FALSE";
    private static final Set<String> ALLOWED_VALUES = Set.of(ENABLED_VALUE, DISABLED_VALUE);

    static BooleanFeatureToggleValue create(String value) {
        if (isNull(value)) {
            throw new WrongFeatureToggleValue();
        }
        if (!ALLOWED_VALUES.contains(value.toUpperCase())) {
            throw new WrongFeatureToggleValue(value, ALLOWED_VALUES);
        }
        return new BooleanFeatureToggleValue(Boolean.parseBoolean(value));
    }

    static BooleanFeatureToggleValue create(boolean value) {
        return BooleanFeatureToggleValue.create(String.valueOf(value));
    }


    @Override
    public String asText() {
        return value ? ENABLED_VALUE : DISABLED_VALUE;
    }

    @Override
    public Object typedValue() {
        return value;
    }

    @Override
    public FeatureToggleValueType type() {
        return FeatureToggleValueType.BOOLEAN;
    }
}
