package pl.feature.toggle.service.value;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchException;

class NumberFeatureToggleValueTest {

    @Test
    void should_throw_exception_when_number_value_is_null() {
        // given && when
        var exception = catchException(() -> NumberFeatureToggleValue.create((String) null));
        // then
        assertThat(exception).isNotNull()
                .isInstanceOf(WrongFeatureToggleValue.class)
                .hasMessageContaining("Feature toggle value is missing");

    }

    @Test
    void should_throw_exception_when_number_feature_toggle_value_is_empty() {
        // given && when
        var exception = catchException(() -> NumberFeatureToggleValue.create(" "));

        // then
        assertThat(exception).isNotNull()
                .isInstanceOf(WrongFeatureToggleValue.class)
                .hasMessageContaining("Wrong feature toggle value: ");
    }

    @Test
    void should_throw_exception_when_number_feature_toggle_value_is_not_a_number() {
        // given && when
        var exception = catchException(() -> NumberFeatureToggleValue.create("not a number"));

        // then
        assertThat(exception).isNotNull()
                .isInstanceOf(WrongFeatureToggleValue.class)
                .hasMessageContaining("Wrong feature toggle value:not a number");
    }

    @ParameterizedTest
    @CsvSource({"10.222", "0.1", "0.2323", "0.00004", "     0.001    "})
    void should_create_number_feature_toggle_value_from_string(String rawValue) {
        // given && when
        var actual = NumberFeatureToggleValue.create(rawValue);

        // then
        assertThat(actual).isNotNull();
        assertThat(actual.asText()).isEqualTo(rawValue);
        assertThat(actual.type()).isEqualTo(FeatureToggleValueType.NUMBER);
        assertThat(actual.value()).isEqualTo(new BigDecimal(rawValue));
        assertThat(actual.typedValue()).isEqualTo(new BigDecimal(rawValue));
    }

    @Test
    void should_create_number_feature_toggle_value_from_number() {
        // given
        var number = new BigDecimal("10.222");

        // when
        var actual = NumberFeatureToggleValue.create(number);

        // then
        assertThat(actual).isNotNull();
        assertThat(actual.asText()).isEqualTo(number.toString());
        assertThat(actual.type()).isEqualTo(FeatureToggleValueType.NUMBER);
        assertThat(actual.value()).isEqualTo(number);
        assertThat(actual.typedValue()).isEqualTo(number);
    }

}