package com.configly.value.rule;

import java.util.Set;

import static java.util.Objects.isNull;

record BooleanRuleConditionValue(
        boolean value
) implements RuleConditionValue {

    private static final String ENABLED_VALUE = "TRUE";
    private static final String DISABLED_VALUE = "FALSE";
    private static final Set<String> ALLOWED_VALUES = Set.of(ENABLED_VALUE, DISABLED_VALUE);

    static BooleanRuleConditionValue create(String value) {
        if (isNull(value)) {
            throw new WrongRuleConditionValue();
        }
        if (!ALLOWED_VALUES.contains(value.toUpperCase())) {
            throw new WrongRuleConditionValue(value, ALLOWED_VALUES);
        }
        return new BooleanRuleConditionValue(Boolean.parseBoolean(value));
    }

    static BooleanRuleConditionValue create(boolean value) {
        return BooleanRuleConditionValue.create(String.valueOf(value));
    }


    @Override
    public String asText() {
        return value ? ENABLED_VALUE : DISABLED_VALUE;
    }

    @Override
    public Object typedValue() {
        return value;
    }

    @Override
    public RuleConditionValueType type() {
        return RuleConditionValueType.BOOLEAN;
    }

}
