package pl.feature.toggle.service.model.featuretoggle.value;

import pl.feature.toggle.service.model.exception.WrongFeatureToggleValue;

import static java.util.Objects.isNull;

record TextFeatureToggleValue(
        String value
) implements FeatureToggleValue {

    static TextFeatureToggleValue create(String value) {
        if (isNull(value)) {
            throw new WrongFeatureToggleValue();
        }
        return new TextFeatureToggleValue(value);
    }

    @Override
    public String asText() {
        return value;
    }

    @Override
    public FeatureToggleValueType type() {
        return FeatureToggleValueType.TEXT;
    }
}