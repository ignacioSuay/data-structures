package com.ignaciosuay.datastructure.regex

import spock.lang.Specification
import spock.lang.Subject

class RegExSampleTest extends Specification {

    @Subject
    RegExSample regExSample = new RegExSample()

    def "Test increment value"() {

        given: "A string"
        String str = "aaaa 12 aaa 1230"

        when: "increment the string"
        def result = regExSample.incrementValues(str)

        then:
        result == "aaaa 13 aaa 1231"
    }

    def "Test valid email"() {

        given: "A string"
        String str = "aaa@aaa.com"

        when: "increment the string"
        def result = regExSample.isEmailAddress(str)

        then:
        result
    }

    def "Test invalid email"() {

        given: "A string"
        String str = "aaa@aa"

        when: "increment the string"
        def result = regExSample.isEmailAddress(str)

        then:
        !result
    }
}
