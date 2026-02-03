package pl.feature.toggle.service.model.featuretoggle.value;

import pl.feature.toggle.service.model.exception.UnsupportedFeatureToggleType;

public enum FeatureToggleValueType {
    BOOLEAN,
    NUMBER,
    TEXT;

    public static FeatureToggleValueType fromString(String rawType) {
        if (rawType == null || rawType.isBlank()) {
            throw new UnsupportedFeatureToggleType();
        }

        for (FeatureToggleValueType type : FeatureToggleValueType.values()) {
            if (type.name().equalsIgnoreCase(rawType.trim())) {
                return type;
            }
        }

        throw new UnsupportedFeatureToggleType(rawType);
    }
}
