package com.configly.value.toggle;

record FeatureToggleValueSpec<T>(
        T value,
        FeatureToggleValueType type
) {

    static FeatureToggleValueSpec<?> create(Object value) {
        return recognizeValueSpec(value);
    }

    public static FeatureToggleValueSpec<Object> create(Object value, String type) {
        return new FeatureToggleValueSpec<>(value, FeatureToggleValueType.valueOf(type));
    }

    static FeatureToggleValueSpec<Boolean> bool(Boolean value) {
        return new FeatureToggleValueSpec<>(value, FeatureToggleValueType.BOOLEAN);
    }

    static FeatureToggleValueSpec<String> text(String value) {
        return new FeatureToggleValueSpec<>(value, FeatureToggleValueType.TEXT);
    }

    static FeatureToggleValueSpec<Number> number(Number value) {
        return new FeatureToggleValueSpec<>(value, FeatureToggleValueType.NUMBER);
    }

    private static FeatureToggleValueSpec<?> recognizeValueSpec(Object value) {
        return switch (value) {
            case String s -> FeatureToggleValueSpec.text(s);
            case Boolean b -> FeatureToggleValueSpec.bool(b);
            case Number n -> FeatureToggleValueSpec.number(n);
            default -> throw new UnsupportedFeatureToggleType(value.getClass().getTypeName());
        };
    }

}
