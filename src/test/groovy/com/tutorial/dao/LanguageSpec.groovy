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
        when:
        List<Language> languages = new LanguageDao().getLanguages()

        then:
        assert languages.size() > 0
    }
}
