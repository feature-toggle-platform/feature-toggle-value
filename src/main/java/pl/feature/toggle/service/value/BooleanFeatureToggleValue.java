package pl.feature.toggle.service.value;

import java.util.Set;

import static java.util.Objects.isNull;

record BooleanFeatureToggleValue(
        boolean value
) implements FeatureToggleValue {

    static final String ENABLED_VALUE = "TRUE";
    static final String DISABLED_VALUE = "FALSE";
    static final Set<String> ALLOWED_VALUES = Set.of(ENABLED_VALUE, DISABLED_VALUE);

    static BooleanFeatureToggleValue disabled() {
        return new BooleanFeatureToggleValue(false);
    }

    static BooleanFeatureToggleValue enabled() {
        return new BooleanFeatureToggleValue(true);
    }

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
        return new BooleanFeatureToggleValue(value);
    }


    @Override
    public String asText() {
        return value ? ENABLED_VALUE : DISABLED_VALUE;
    }

    @Override
    public FeatureToggleValueType type() {
        return FeatureToggleValueType.BOOLEAN;
    }
}
