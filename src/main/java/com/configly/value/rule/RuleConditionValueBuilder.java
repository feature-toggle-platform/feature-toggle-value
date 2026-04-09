package com.configly.value.rule;

import com.configly.value.toggle.FeatureToggleValueSnapshot;
import com.configly.value.toggle.FeatureToggleValueType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class RuleConditionValueBuilder {

    public static RuleConditionValue text(String value) {
        return RuleConditionValueRecognizer.from(RuleConditionValueSpec.text(value));
    }

    public static RuleConditionValue number(int value) {
        return RuleConditionValueRecognizer.from(RuleConditionValueSpec.number(value));
    }

    public static RuleConditionValue bool(boolean value) {
        return RuleConditionValueRecognizer.from(RuleConditionValueSpec.bool(value));
    }

    public static RuleConditionValue from(Object value) {
        return RuleConditionValueRecognizer.from(RuleConditionValueSpec.create(value));
    }

    public static RuleConditionValue from(FeatureToggleValueSnapshot rawValue, String type) {
        return RuleConditionValueRecognizer.from(rawValue.value(), FeatureToggleValueType.valueOf(type));
    }

    public static RuleConditionValue from(FeatureToggleValueSnapshot rawValue, FeatureToggleValueType type) {
        return RuleConditionValueRecognizer.from(rawValue.value(), type);
    }



}
