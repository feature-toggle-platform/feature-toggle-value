package pl.feature.toggle.service.model.featuretoggle.value;

import pl.feature.toggle.service.model.exception.WrongFeatureToggleValue;

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

    public static FeatureToggleValue create(Number value) {
        return new NumberFeatureToggleValue(BigDecimal.valueOf(value.doubleValue()));
    }

    @Override
    public String asText() {
        return value.toPlainString();
    }

    @Override
    public FeatureToggleValueType type() {
        return FeatureToggleValueType.NUMBER;
    }
}