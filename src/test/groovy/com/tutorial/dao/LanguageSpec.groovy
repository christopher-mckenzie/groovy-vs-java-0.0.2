package com.tutorial.dao

import com.tutorial.bean.Language
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

/**
 * Created by cmcke on 3/26/2017.
 */
@SpringBootTest
class LanguageSpec extends Specification{

    def 'retrieve possible languages for translation'(){
        when: 'calling ibm url we get a list of possible langauges to translate true and from'
        List<Language> languages = new LanguageDao().getLanguages()

        then: 'result/languages  are not empty'
        assert languages.size() > 0
    }
}
