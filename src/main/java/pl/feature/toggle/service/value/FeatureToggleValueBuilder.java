package pl.feature.toggle.service.model.featuretoggle.value;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class FeatureToggleValueBuilder {

    public static FeatureToggleValue text(String value) {
        return FeatureToggleValueRecognizer.from(FeatureToggleValueSpec.text(value));
    }

    public static FeatureToggleValue number(int value) {
        return FeatureToggleValueRecognizer.from(FeatureToggleValueSpec.number(value));
    }

    public static FeatureToggleValue bool(boolean value) {
        return FeatureToggleValueRecognizer.from(FeatureToggleValueSpec.bool(value));
    }

    public static FeatureToggleValue from(Object value) {
        return FeatureToggleValueRecognizer.from(FeatureToggleValueSpec.create(value));
    }

    public static FeatureToggleValue from(String value, String type) {
        return FeatureToggleValueRecognizer.from(value, FeatureToggleValueType.valueOf(type));
    }

    public static FeatureToggleValue from(String value, FeatureToggleValueType type) {
        return FeatureToggleValueRecognizer.from(value, type);
    }

}
