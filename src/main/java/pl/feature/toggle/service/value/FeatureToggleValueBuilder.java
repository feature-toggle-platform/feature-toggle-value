package pl.feature.toggle.service.value;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import pl.feature.toggle.service.value.raw.FeatureToggleRawValue;

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

    public static FeatureToggleValue from(FeatureToggleRawValue rawValue, String type) {
        return FeatureToggleValueRecognizer.from(rawValue.value(), FeatureToggleValueType.valueOf(type));
    }

    public static FeatureToggleValue from(FeatureToggleRawValue rawValue, FeatureToggleValueType type) {
        return FeatureToggleValueRecognizer.from(rawValue.value(), type);
    }

}
