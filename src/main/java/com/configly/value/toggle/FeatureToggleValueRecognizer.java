package com.configly.value.toggle;


class FeatureToggleValueRecognizer {

    static <T> FeatureToggleValue from(FeatureToggleValueSpec<T> spec) {
        return switch (spec.type()) {
            case BOOLEAN -> BooleanFeatureToggleValue.create(asBoolean(spec.value()));
            case NUMBER -> NumberFeatureToggleValue.create(asNumber(spec.value()));
            case TEXT -> TextFeatureToggleValue.create(asText(spec.value()));
        };
    }

    static FeatureToggleValue from(String value, FeatureToggleValueType type) {
        return switch (type) {
            case BOOLEAN -> BooleanFeatureToggleValue.create(value);
            case NUMBER -> NumberFeatureToggleValue.create(value);
            case TEXT -> TextFeatureToggleValue.create(value);
        };
    }

    private static boolean asBoolean(Object value) {
        return (Boolean) value;
    }

    private static String asText(Object value) {
        return (String) value;
    }

    private static Number asNumber(Object value) {
        return (Number) value;
    }

}
