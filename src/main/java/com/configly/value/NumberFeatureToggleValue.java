package com.configly.value;

import java.math.BigDecimal;

import static java.util.Objects.isNull;

record NumberFeatureToggleValue(
        BigDecimal value
) implements FeatureToggleValue {

    static NumberFeatureToggleValue create(String value) {
        if (isNull(value)) {
            throw new WrongFeatureToggleValue();
        }

        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new WrongFeatureToggleValue(value);
        }

        try {
            return new NumberFeatureToggleValue(new BigDecimal(normalized));
        } catch (NumberFormatException ex) {
            throw new WrongFeatureToggleValue(value);
        }
    }

    public static NumberFeatureToggleValue create(Number value) {
        return NumberFeatureToggleValue.create(value.toString());
    }

    @Override
    public String asText() {
        return value.toPlainString();
    }

    @Override
    public Object typedValue() {
        return value;
    }

    @Override
    public FeatureToggleValueType type() {
        return FeatureToggleValueType.NUMBER;
    }
}