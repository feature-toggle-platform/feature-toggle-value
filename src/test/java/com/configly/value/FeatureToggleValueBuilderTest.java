package com.configly.value;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FeatureToggleValueBuilderTest {

    @Nested
    class DirectFactories {

        @Test
        void should_build_text_value() {
            // when
            FeatureToggleValue value = FeatureToggleValueBuilder.text("hello");

            // then
            assertThat(value.type()).isEqualTo(FeatureToggleValueType.TEXT);
            assertThat(value.typeName()).isEqualTo("TEXT");
            assertThat(value.asText()).isEqualTo("hello");
        }

        @Test
        void should_build_number_value() {
            // when
            FeatureToggleValue value = FeatureToggleValueBuilder.number(123);

            // then
            assertThat(value.type()).isEqualTo(FeatureToggleValueType.NUMBER);
            assertThat(value.typeName()).isEqualTo("NUMBER");
            assertThat(value.asText()).isEqualTo("123");
        }

        @Test
        void should_build_boolean_value() {
            // when
            FeatureToggleValue value = FeatureToggleValueBuilder.bool(true);

            // then
            assertThat(value.type()).isEqualTo(FeatureToggleValueType.BOOLEAN);
            assertThat(value.typeName()).isEqualTo("BOOLEAN");
            assertThat(value.asText()).isEqualTo("TRUE");
        }
    }

    @Nested
    class FromObject {

        static Stream<Arguments> should_build_from_object_cases() {
            return Stream.of(
                    Arguments.of("abc", FeatureToggleValueType.TEXT, "abc"),
                    Arguments.of(7, FeatureToggleValueType.NUMBER, "7"),
                    Arguments.of(7L, FeatureToggleValueType.NUMBER, "7"),
                    Arguments.of(3.14, FeatureToggleValueType.NUMBER, "3.14"),
                    Arguments.of(false, FeatureToggleValueType.BOOLEAN, "FALSE")
            );
        }

        @ParameterizedTest
        @MethodSource("should_build_from_object_cases")
        void should_build_from_object(Object input, FeatureToggleValueType expectedType, String expectedText) {
            // when
            FeatureToggleValue value = FeatureToggleValueBuilder.from(input);

            // then
            assertThat(value.type()).isEqualTo(expectedType);
            assertThat(value.asText()).isEqualTo(expectedText);
        }
    }

    @Nested
    class FromSnapshot {

        static Stream<Arguments> should_build_from_snapshot_cases() {
            return Stream.of(
                    Arguments.of(snapshot("true"), FeatureToggleValueType.BOOLEAN, "TRUE"),
                    Arguments.of(snapshot("false"), FeatureToggleValueType.BOOLEAN, "FALSE"),
                    Arguments.of(snapshot("123"), FeatureToggleValueType.NUMBER, "123"),
                    Arguments.of(snapshot("hello"), FeatureToggleValueType.TEXT, "hello")
            );
        }

        @ParameterizedTest
        @MethodSource("should_build_from_snapshot_cases")
        void should_build_from_snapshot_and_enum_type(FeatureToggleValueSnapshot rawValue,
                                                      FeatureToggleValueType type,
                                                      String expectedText) {
            // when
            FeatureToggleValue value = FeatureToggleValueBuilder.from(rawValue, type);

            // then
            assertThat(value.type()).isEqualTo(type);
            assertThat(value.asText()).isEqualTo(expectedText);
        }

        @ParameterizedTest
        @MethodSource("should_build_from_snapshot_cases")
        void should_build_from_snapshot_and_string_type(FeatureToggleValueSnapshot rawValue,
                                                        FeatureToggleValueType type,
                                                        String expectedText) {
            // when
            FeatureToggleValue value = FeatureToggleValueBuilder.from(rawValue, type.name());

            // then
            assertThat(value.type()).isEqualTo(type);
            assertThat(value.asText()).isEqualTo(expectedText);
        }

        @Test
        void should_fail_when_type_string_is_unknown() {
            // given
            FeatureToggleValueSnapshot raw = snapshot("whatever");

            // expect
            assertThatThrownBy(() -> FeatureToggleValueBuilder.from(raw, "UNKNOWN"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    private static FeatureToggleValueSnapshot snapshot(String value) {
        return FeatureToggleValueSnapshot.of(value);
    }

}