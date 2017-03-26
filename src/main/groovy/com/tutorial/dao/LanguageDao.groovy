package com.tutorial.dao

import com.tutorial.bean.Language
import groovy.json.JsonSlurper
import groovy.util.logging.Slf4j

/**
 * Created by cmcke on 3/25/2017.
 */
@Slf4j
class LanguageDao {

    def base = 'https://watson-api-explorer.mybluemix.net/language-translator/api/v2/identifiable_languages'

     List<Language> getLanguages(){
         log.info 'getLanguages'
         URL languages_api_url = new URL(base)
         def languages = new JsonSlurper().parseText(languages_api_url.text).languages as List<Language>
         log.info "Successfully parsed getLanguages(): ${languages.collect { element ->  "\n${element}"}}"
         return languages
    }

}
