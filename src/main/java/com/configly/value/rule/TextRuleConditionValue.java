package com.configly.value.rule;

import static java.util.Objects.isNull;

record TextRuleConditionValue(
        String value
) implements RuleConditionValue {

    static TextRuleConditionValue create(String value) {
        if (isNull(value)) {
            throw new WrongRuleConditionValue();
        }
        if (value.isBlank()) {
            throw new WrongRuleConditionValue();
        }
        return new TextRuleConditionValue(value);
    }

    @Override
    public String asText() {
        return value;
    }

    @Override
    public Object typedValue() {
        return value;
    }

    @Override
    public RuleConditionValueType type() {
        return RuleConditionValueType.TEXT;
    }

}
