package com.tutorial.service

import spock.lang.Specification

/**
 * Created by req85404 on 03/27/2017.
 */
class TranslateServiceSpec extends Specification{

    def "translate text"(){
        given: 'source & target language along with text to be translated'
            String source = 'English'
            String target = 'French'
            String text = 'My name is Chris'
            String result = ''
        when: 'calling ibm url to translate inputs'
            result = new TranslateService().translate source, target, text
        then: 'translation must equal: Mon nom est Chris'
        result == 'Mon nom est Chris'
        println "result: $result"
    }
}
