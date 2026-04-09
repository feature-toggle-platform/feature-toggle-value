package com.configly.value.rule;


public class UnsupportedRuleConditionValueType extends RuntimeException {
    public UnsupportedRuleConditionValueType(RuleConditionValueType type) {
        super("Unsupported rule condition type: " + type);
    }

    public UnsupportedRuleConditionValueType() {
        super("Rule condition type is missing.");
    }

    public UnsupportedRuleConditionValueType(String rawType) {
        super("Unsupported rule condition type: " + rawType);
    }
}
