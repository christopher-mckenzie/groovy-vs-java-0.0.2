package com.tutorial.service

import spock.lang.Specification

/**
 * Created by req85404 on 03/27/2017.
 */
class TranslateServiceSpec extends Specification{

    def "translate text"(){
        given:
            String source = 'English'
            String target = 'French'
            String text = 'My name is Chris'
            String result = ''
        when:
            result = new TranslateService().translate source, target, text
        then:
        result == 'Mon nom est Chris'
        println "result: $result"
    }
}
