package com.configly.value.rule;

import com.configly.value.toggle.UnsupportedFeatureToggleType;

record RuleConditionValueSpec<T>(
        T value,
        RuleConditionValueType type
) {

    static RuleConditionValueSpec<?> create(Object value) {
        return recognizeValueSpec(value);
    }

    public static RuleConditionValueSpec<Object> create(Object value, String type) {
        return new RuleConditionValueSpec<>(value, RuleConditionValueType.valueOf(type));
    }

    static RuleConditionValueSpec<Boolean> bool(Boolean value) {
        return new RuleConditionValueSpec<>(value, RuleConditionValueType.BOOLEAN);
    }

    static RuleConditionValueSpec<String> text(String value) {
        return new RuleConditionValueSpec<>(value, RuleConditionValueType.TEXT);
    }

    static RuleConditionValueSpec<Number> number(Number value) {
        return new RuleConditionValueSpec<>(value, RuleConditionValueType.NUMBER);
    }

    private static RuleConditionValueSpec<?> recognizeValueSpec(Object value) {
        return switch (value) {
            case String s -> RuleConditionValueSpec.text(s);
            case Boolean b -> RuleConditionValueSpec.bool(b);
            case Number n -> RuleConditionValueSpec.number(n);
            default -> throw new UnsupportedFeatureToggleType(value.getClass().getTypeName());
        };
    }

}
