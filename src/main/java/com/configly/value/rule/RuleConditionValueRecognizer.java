package com.configly.value.rule;

import com.configly.value.toggle.FeatureToggleValueType;

final class RuleConditionValueRecognizer {

    static <T> RuleConditionValue from(RuleConditionValueSpec<T> spec) {
        return switch (spec.type()) {
            case BOOLEAN -> BooleanRuleConditionValue.create(asBoolean(spec.value()));
            case NUMBER -> NumberRuleConditionValue.create(asNumber(spec.value()));
            case TEXT -> TextRuleConditionValue.create(asText(spec.value()));
        };
    }

    static RuleConditionValue from(String value, FeatureToggleValueType type) {
        return switch (type) {
            case BOOLEAN -> BooleanRuleConditionValue.create(value);
            case NUMBER -> NumberRuleConditionValue.create(value);
            case TEXT -> TextRuleConditionValue.create(value);
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
